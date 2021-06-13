package com.codingwithrufat.retrofitpostmethod.api;

import com.codingwithrufat.retrofitpostmethod.models.ResponseItem;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IApi {

    @FormUrlEncoded
    @POST("posts")
    Call<ResponseItem> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body

    );


}
