package com.example.statemanagement.api;

import com.example.statemanagement.models.Post;
import com.google.gson.JsonArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("posts/")
    Call<ArrayList<Post>> getPosts();


}
