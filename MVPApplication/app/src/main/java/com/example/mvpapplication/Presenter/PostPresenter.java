package com.example.mvpapplication.Presenter;

import android.view.View;

import com.example.mvpapplication.MainActivity;
import com.example.mvpapplication.WebHttp.JsonPlaceHolderApi;
import com.example.mvpapplication.WebHttp.RetrofitClient;
import com.example.mvpapplication.model.Post;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPresenter implements Postpresent, Postpresent.IPresenter {
    public List<Post> posts=new ArrayList<>();


    public void getData() {
        JsonPlaceHolderApi jsonPlaceHolderApi = RetrofitClient.getClient().create(JsonPlaceHolderApi.class);
        Call<okhttp3.ResponseBody> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<okhttp3.ResponseBody>() {
            @Override
            public void onResponse(Call<okhttp3.ResponseBody> call, Response<okhttp3.ResponseBody> response) {
                if (response.body() != null) try {
                    JSONArray jsonArray = new JSONArray(response.body().string());
                    JSONObject jsonObject;
                    for (int count = 0; count < jsonArray.length(); count++) {
                        jsonObject = jsonArray.getJSONObject(count);
                        Post post = new Post(jsonObject);
                        posts.add(post);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<okhttp3.ResponseBody> call, Throwable t) {

            }
        });

    }

    @Override
    public void attachView(View view) {

    }

    @Override
    public void detachView() {

    }


}
