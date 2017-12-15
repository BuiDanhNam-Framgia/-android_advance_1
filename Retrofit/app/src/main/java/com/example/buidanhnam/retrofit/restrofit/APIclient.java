package com.example.buidanhnam.retrofit.restrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bui Danh Nam on 15/12/2017.
 */
// Khởi tạo Retrofit để gán API ENDPOINT (Domain URL) cho Retrofit 2.0
public class APIclient {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    public static Retrofit getRetrofit(){
        if(retrofit == null){
            // Sử dụng GSON cho việc parse và maps JSON data tới Object
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit ;
    }
}
