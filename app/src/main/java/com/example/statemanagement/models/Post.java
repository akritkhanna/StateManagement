package com.example.statemanagement.models;

import com.google.gson.annotations.SerializedName;

public class Post{

	@SerializedName("id")
	private Integer id;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("userId")
	private Integer userId;

	public Integer getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getBody(){
		return body;
	}

	public Integer getUserId(){
		return userId;
	}
}