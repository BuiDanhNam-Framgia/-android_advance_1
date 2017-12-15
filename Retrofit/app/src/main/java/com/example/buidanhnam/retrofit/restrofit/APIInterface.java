package com.example.buidanhnam.retrofit.restrofit;

import com.example.buidanhnam.retrofit.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Bui Danh Nam on 15/12/2017.
 */

public interface APIInterface {
    @GET
    Call<Movie> getmovie()
}
