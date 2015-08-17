package com.experiementapp.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.experiementapp.BaseFragment;
import com.experiementapp.ExperimentApp;
import com.experiementapp.R;
import com.experiementapp.RxUtils;
import com.experiementapp.api.ApiManager;
import com.experiementapp.models.User;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends BaseFragment {

    @Bind(R.id.tap_btn)
    Button tapBtn;

    @Inject
    ApiManager.GitHubService gitHubService;

    @Inject
    Resources resources;

    private CompositeSubscription mCompositeSubscription
            = new CompositeSubscription();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainFragment.
     */
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExperimentApp.component().inject(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        RxUtils.unsubscribeIfNotNull(mCompositeSubscription);
    }

    @Override
    public void onResume() {
        super.onResume();
        mCompositeSubscription = RxUtils.getNewCompositeSubIfUnsubscribed(mCompositeSubscription);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCustomCreateView(R.layout.fragment_main, inflater, container);
        return super.getmRootView();
    }

    @OnClick(R.id.tap_btn)
    void onClickTap(){
        mCompositeSubscription.add(gitHubService.user("abhimediratta")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<User>() {
            @Override
            public void onCompleted() {
                Timber.d("Call Complete");
            }

            @Override
            public void onError(Throwable e) {
                Timber.e(e, "woops we got an error while getting user details");
            }

            @Override
            public void onNext(User user) {
                //Timber.d("Call Complete, User details: " + user.getName());
            }
        }));
    }


}
