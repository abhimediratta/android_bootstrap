package com.experiementapp;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;

/**
 * Created by abhi on 11/8/15.
 */
public class BaseFragment extends Fragment {
    private View mRootView;

    public View getmRootView() {
        return mRootView;
    }

    public void setmRootView(View mRootView) {
        this.mRootView = mRootView;
    }

    public void onCustomCreateView(int layoutId, LayoutInflater inflater, ViewGroup container){
        mRootView = inflater.inflate(layoutId, container, false);
        ButterKnife.bind(this, mRootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = ExperimentApp.getRefWatcher();
        refWatcher.watch(this);
    }
}
