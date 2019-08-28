package com.example.apiapplication.WebHttp;

import com.example.apiapplication.Model.Post;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;

import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("Posts")
    Call<ResponseBody> getPosts();

    @GET("Posts")
    Call<Post> getPost(@Query("id") int id);

    @POST("posts")
    Call<ResponseBody> createPost(@Body Post post);

}
