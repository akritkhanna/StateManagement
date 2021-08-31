package com.example.statemanagement.view_model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.statemanagement.api.Resources;
import com.example.statemanagement.api.RetrofitClient;
import com.example.statemanagement.api.States;
import com.example.statemanagement.models.Post;
import com.google.gson.JsonArray;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    public MutableLiveData<Resources<ArrayList<Post>>> postsData;

    public PostViewModel(){
        postsData = new MutableLiveData<>();
        getPosts();

    }

    public void getPosts(){
        postsData.setValue(new Resources<>(null, States.LOADING, null));
        RetrofitClient.getApiServices().getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()){
                    postsData.setValue(new Resources<>(response.body(), States.SUCCESS, null));
                }else {
                    postsData.setValue(new Resources<>(null, States.ERROR, response.message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                postsData.setValue(new Resources<>(null, States.ERROR, t.getMessage()));
            }
        });
    }
}
