package com.agile.dating.api;

import com.agile.dating.pojo.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("ByLiked")
    Observable<Response> getUsers(
            @Query("page") int pageNumber);

}
