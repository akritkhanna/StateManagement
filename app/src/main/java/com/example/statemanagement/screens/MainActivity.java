package com.example.statemanagement.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.statemanagement.R;
import com.example.statemanagement.adapter.PostRecyclerAdapter;
import com.example.statemanagement.databinding.ActivityMainBinding;
import com.example.statemanagement.models.Post;
import com.example.statemanagement.view_model.PostViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostViewModel viewModel;
    private ActivityMainBinding binding;
    private List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        posts = new ArrayList<>();
        PostRecyclerAdapter adapter = new PostRecyclerAdapter(posts);
        binding.postRV.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(PostViewModel.class);
        viewModel.getPosts();



        viewModel.postsData.observe(this, posts ->{
            if (posts != null){
                switch (posts.getState()){
                    case LOADING:
                        binding.progressBar.setVisibility(View.VISIBLE);
                        binding.postRV.setVisibility(View.GONE);
                        break;
                    case SUCCESS:
                        binding.progressBar.setVisibility(View.GONE);
                        binding.postRV.setVisibility(View.VISIBLE);
                        this.posts.addAll(posts.getData());
                        break;
                    case ERROR:
                        Toast.makeText(this, posts.getErrorMessage(), Toast.LENGTH_SHORT).show();
                        binding.progressBar.setVisibility(View.GONE);
                        binding.postRV.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }
}