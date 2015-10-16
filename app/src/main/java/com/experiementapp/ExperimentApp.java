package com.experiementapp;

import android.app.Application;
import android.os.StrictMode;

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
            setupStrictMode();
            Timber.plant(new Timber.DebugTree());
        }

    }

    private void setupStrictMode(){
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }

    public static ExperimentAppComponent component() {
        return component;
    }

    public static void buildComponentAndInject(){
        component = ExperimentAppComponent.AppComponentInitializer.getApplicationComponent(_instance);
    }

}
