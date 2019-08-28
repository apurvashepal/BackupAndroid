package com.example.apiapplication.Repository;

import android.content.Context;

import androidx.lifecycle.ViewModelProviders;

import com.example.apiapplication.Activity.MainActivity;
import com.example.apiapplication.Model.Post;
import com.example.apiapplication.WebHttp.JsonPlaceHolderApi;
import com.example.apiapplication.WebHttp.RetrofitClient;
import com.example.apiapplication.viewmodel.MyViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    Context context;
    private JsonPlaceHolderApi jsonPlaceHolderApi = RetrofitClient.getClient().create(JsonPlaceHolderApi.class);
    private MyViewModel mViewModel;
    public PostRepository(Context context){
        this.context = context;
    }

    public void getDataMethod(final MyViewModel myViewModel) {

        Call<ResponseBody> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if( response.body()!=null) try {
                    JSONArray jsonArray = new JSONArray(response.body().string());
                    JSONObject jsonObject;
                    for(int count=0;count<jsonArray.length();count++){
                        jsonObject=jsonArray.getJSONObject(count);
                        Post post = new Post(jsonObject);
                        myViewModel.posts.add(post);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
