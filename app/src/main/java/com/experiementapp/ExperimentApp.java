package com.experiementapp;

import android.app.Application;

import com.experiementapp.components.ExperimentAppComponent;

import timber.log.Timber;

/**
 * Created by abhi on 11/8/15.
 */
public class ExperimentApp extends Application {
    private static ExperimentAppComponent component;
    private static ExperimentApp _instance;
    //private RefWatcher _refWatcher;

    public static ExperimentApp get() {
        return _instance;
    }

//    public static RefWatcher getRefWatcher() {
//        return ExperimentApp.get()._refWatcher;
//    }

    @Override
    public void onCreate() {
        super.onCreate();

        _instance = (ExperimentApp) getApplicationContext();
//        _refWatcher = LeakCanary.install(this);

        buildComponentAndInject();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

    }

    public static ExperimentAppComponent component() {
        return component;
    }

    public static void buildComponentAndInject(){
        component = ExperimentAppComponent.AppComponentInitializer.getApplicationComponent(_instance);
    }

}
