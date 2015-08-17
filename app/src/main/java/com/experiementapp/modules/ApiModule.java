package com.experiementapp.modules;

import com.experiementapp.api.ApiManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by abhi on 17/8/15.
 */
@Module
public class ApiModule {

    public static final String API_URL = "https://api.github.com";

    @Singleton
    @Provides
    public ApiManager.GitHubService provideGitService(){
        return new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build().create(ApiManager.GitHubService.class);
    }

}
