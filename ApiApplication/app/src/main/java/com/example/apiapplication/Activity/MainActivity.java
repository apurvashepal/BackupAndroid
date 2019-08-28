package com.example.apiapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.apiapplication.Adapter.ListViewAdapter;
import com.example.apiapplication.Repository.PostRepository;
import com.example.apiapplication.Utility.Utils;
import com.example.apiapplication.WebHttp.JsonPlaceHolderApi;
import com.example.apiapplication.Model.Post;
import com.example.apiapplication.R;
import com.example.apiapplication.WebHttp.RetrofitClient;
import com.example.apiapplication.viewmodel.MyViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewResult, textViewResultSingle;
    private Button getData, getData1, postData, putData, deleteData;
    private EditText getId;
    private ProgressBar progressBar;

    private MyViewModel mViewModel;
    private JsonPlaceHolderApi jsonPlaceHolderApi = RetrofitClient.getClient().create(JsonPlaceHolderApi.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData = findViewById(R.id.getData);
        getData.setOnClickListener(this);
        getData1 = findViewById(R.id.getData1);
        getData1.setOnClickListener(this);
        postData = findViewById(R.id.postData);
        postData.setOnClickListener(this);
        progressBar = findViewById(R.id.progress_circular);
        progressBar.setVisibility(View.GONE);

        mViewModel= ViewModelProviders.of(this).get(MyViewModel.class);


    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        recyclerView();
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.getData:
                if(!Utils.isNetworkAvailable(this))
                {
                    Utils.showDialog(this,"Network Error", "No Internet Access Found", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();

                        }
                    }, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

                }
                processDialogMethod();
                mViewModel.callMethod(mViewModel);
                recyclerView();

                break;
            case R.id.getData1:
                getId = findViewById(R.id.dataId);
                int id = Integer.valueOf(getId.getText().toString());
                Call<Post> call1 = jsonPlaceHolderApi.getPost(id);
                call1.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        Post post = response.body();
                        textViewResultSingle.setText(post.toString());
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        textViewResult.setText(t.getMessage());
                    }
                });
                break;

            case R.id.postData:
                postMethod();

        }


    }

    private void postMethod() {

    //Call<ResponseBody> call = jsonPlaceHolderApi.createPost();
    }

    private void processDialogMethod() {
        final ProgressBar progressBar1 = new ProgressBar(MainActivity.this, null, R.id.progress_circular);
        progressBar.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            progressBar.setVisibility(View.VISIBLE);
            }
        }).start();
        progressBar.setVisibility(View.GONE);
    }



    private void recyclerView() {
        RecyclerView listHolder= findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        listHolder.setLayoutManager(linearLayoutManager);
        ListViewAdapter listViewAdapter= new ListViewAdapter(this,mViewModel.posts);
        listHolder.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
    }
}
