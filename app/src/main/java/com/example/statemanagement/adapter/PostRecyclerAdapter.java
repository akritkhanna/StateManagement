package com.example.statemanagement.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.statemanagement.databinding.PostListLayouBinding;
import com.example.statemanagement.models.Post;

import java.util.List;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.PostViewHolder> {
    private List<Post> posts;

    public PostRecyclerAdapter(List<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(PostListLayouBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.binding.titleTV.setText(posts.get(holder.getAdapterPosition()).getTitle());
        holder.binding.descriptionTV.setText(posts.get(holder.getAdapterPosition()).getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{
        private PostListLayouBinding binding;
        public PostViewHolder(@NonNull PostListLayouBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
