package com.experiementapp.modules;

import android.app.Application;
import android.content.res.Resources;

import com.experiementapp.ExperimentApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhi on 17/8/15.
 */
@Module
public class AppModule {
    private final ExperimentApp app;

    public AppModule(ExperimentApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return app;
    }

    @Provides
    @Singleton
    public Resources provideResources(){
        return app.getResources();
    }
}
