package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.data.remote;

import com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.model.search_repository.ExampleRB;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by erlangparasu on 2/28/18.
 */

public interface IApiService {

    @GET("search/repositories")
    Call<ExampleRB> searchRepository(@Query("q") String keywords);
}
