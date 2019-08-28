package com.example.mvpapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpapplication.R;
import com.example.mvpapplication.model.Post;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Post> postList;
    public ListViewAdapter(Context context, List<Post> postList){
        mContext=context;
        this.postList=postList;

        if(this.postList ==null){
            this.postList= new ArrayList<>();
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.card_layout,parent,false);

        return new ListViewAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            final Post post= postList.get(position);

            if( holder instanceof ListViewHolder){
                final ListViewHolder listViewHolder=(ListViewHolder) holder;

                listViewHolder.id.setText("id:"+Integer.toString(post.getId()));
                listViewHolder.userId.setText("UserID:"+Integer.toString(post.getUserId()));
                listViewHolder.title.setText(post.getTitle());
                listViewHolder.body.setText(post.getBody());

            }

    }



    @Override
    public int getItemCount() {
        return this.postList.size();
    }

    private class ListViewHolder extends RecyclerView.ViewHolder {
        TextView id,userId,title,body;

        public ListViewHolder(View view) {
            super(view);
            id=view.findViewById(R.id.b_id);
            userId=view.findViewById(R.id.b_userId);
            title=view.findViewById(R.id.b_title);
            body=view.findViewById(R.id.b_body);
        }
    }
}
