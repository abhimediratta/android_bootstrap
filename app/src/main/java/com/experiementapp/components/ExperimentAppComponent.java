package com.experiementapp.components;

import com.experiementapp.ExperimentApp;
import com.experiementapp.MainActivity;
import com.experiementapp.fragments.MainFragment;
import com.experiementapp.modules.ApiModule;
import com.experiementapp.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abhi on 17/8/15.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ApiModule.class
        }
)
public interface ExperimentAppComponent {
    void inject(MainActivity mainActivity);
    void inject(MainFragment mainFragment);

    final class AppComponentInitializer {
        private AppComponentInitializer() {

        }

        public static ExperimentAppComponent getApplicationComponent(ExperimentApp app) {
            return DaggerExperimentAppComponent.builder().appModule(new AppModule(app)).build();
        }
    }

}
