package com.experiementapp.modules;

import android.app.Application;

import com.experiementapp.R;
import com.experiementapp.api.ApiManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import timber.log.Timber;

/**
 * Created by abhi on 17/8/15.
 */
@Module
public class ApiModule {

    public static final String API_URL = "https://api.github.com";

    @Singleton
    @Provides
    public ApiManager.GitHubService provideGitService(final Application app){
        RestAdapter.Builder builder = new RestAdapter.Builder();
        return builder.setEndpoint(API_URL)
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        Timber.d("Token: " + app.getResources().getString(R.string.github_token));
                        //request.addHeader("Authorization", format("token %s", app.getResources().getString(R.string.github_token)));
                    }
                })
                .build().create(ApiManager.GitHubService.class);
    }

}
