package com.example.admin.videoapp.networks;

import com.example.admin.videoapp.models.Video;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 9/14/2018.
 */

public interface ApiService {
    @GET("api/videos/")
    Call<Video> getVideo(@Query("key")String key,@Query("q")String q,@Query("pretty")String pretty);
}
