package com.example.apiapplication.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.apiapplication.Application.MyApplication;
import com.example.apiapplication.Model.Post;
import com.example.apiapplication.Repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {
    public int count;
    public List<Post> posts= new ArrayList<>();

    PostRepository postRepository= new PostRepository(MyApplication.getContext());

     public void callMethod(MyViewModel myViewModel) {
        postRepository.getDataMethod(myViewModel);

    }
}
