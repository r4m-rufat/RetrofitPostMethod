package com.codingwithrufat.retrofitpostmethod.models;

public class ResponseItem{
	private int id;
	private String title;
	private String body;
	private int userId;

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getBody(){
		return body;
	}

	public int getUserId(){
		return userId;
	}
}
