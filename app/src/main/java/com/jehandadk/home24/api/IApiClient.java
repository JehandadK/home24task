package com.jehandadk.home24.api;

import com.jehandadk.home24.models.ArticleListResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jehandad.kamal on 5/11/2016.
 */
public interface IApiClient {

    @GET("articles?appDomain=1")
    Observable<ArticleListResponse> getArticles(@Query("limit") int limit);
}
