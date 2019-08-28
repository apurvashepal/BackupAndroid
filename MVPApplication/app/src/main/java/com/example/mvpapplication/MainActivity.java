package com.example.mvpapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mvpapplication.Adapter.ListViewAdapter;
import com.example.mvpapplication.Presenter.PostPresenter;
import com.example.mvpapplication.Presenter.Postpresent;
import com.example.mvpapplication.Utility.Utils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    PostPresenter presenter;
    private TextView textViewResult, textViewResultSingle;
    private Button getData, getData1, postData, putData, deleteData;
    private EditText getId;
    private ProgressBar progressBar;

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
        attachPresenter();
    }

    private void attachPresenter() {
        presenter = (PostPresenter) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = new PostPresenter();
        }

    }

    @Override
    public Object getLastCustomNonConfigurationInstance() {

        return presenter;
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {

        return presenter;
    }

    private void recyclerView() {
        RecyclerView listHolder = findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listHolder.setLayoutManager(linearLayoutManager);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, presenter.posts);
        listHolder.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();
    }

    private void processDialogMethod() {
        final ProgressBar progressBar1 = new ProgressBar(MainActivity.this, null, R.id.progress_circular);
        progressBar.setVisibility(View.VISIBLE);
        new Thread(new Runnable() {
            public void run() {
                try {
                    progressBar.setVisibility(View.VISIBLE);
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
               progressBar.setVisibility(View.GONE);
            }
        }).start();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.getData:
                presenter.attachView(view);
                if (!Utils.isNetworkAvailable(this)) {
                    Utils.showDialog(this, "Network Error", "No Internet Access Found", new DialogInterface.OnClickListener() {
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

                presenter.getData();
                recyclerView();

                break;
        }
    }
}
