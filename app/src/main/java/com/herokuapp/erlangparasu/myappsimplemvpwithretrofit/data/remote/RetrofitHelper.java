package com.herokuapp.erlangparasu.myappsimplemvpwithretrofit.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by erlangparasu on 2/28/18.
 */

public class RetrofitHelper {

    private static final String BASE_URL = "https://api.github.com/";
    private static Retrofit sRetrofit;

    public static Retrofit getInstance() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return sRetrofit;
    }
}
