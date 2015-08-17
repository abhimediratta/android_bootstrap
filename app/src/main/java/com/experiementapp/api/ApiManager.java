package com.experiementapp.api;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by abhi on 17/8/15.
 */
public class ApiManager {
    public interface GitHubService {

        @GET("/users/{user}/repos")
        Observable<Response> listRepos(@Path("user") String user);

    }
}
