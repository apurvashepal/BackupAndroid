package com.example.mvpapplication.Presenter;

import android.view.View;

import com.example.mvpapplication.MainActivity;

public interface Postpresent {
    interface IPostpresent {
        void getData();
    }

    interface IPresenter  {

        void attachView(View view);

        void detachView();

    }
}