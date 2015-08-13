package com.experiementapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.experiementapp.BaseFragment;
import com.experiementapp.R;

import butterknife.Bind;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCustomCreateView(R.layout.fragment_main,inflater,container);
        Timber.d("Button text: " + tapBtn.getText());
        return super.getmRootView();
    }


}
