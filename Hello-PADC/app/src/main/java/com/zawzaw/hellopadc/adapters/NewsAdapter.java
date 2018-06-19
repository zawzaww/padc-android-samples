package com.zawzaw.hellopadc.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zawzaw.hellopadc.R;
import com.zawzaw.hellopadc.data.vos.NewsVO;
import com.zawzaw.hellopadc.delegates.NewsDelegate;
import com.zawzaw.hellopadc.viewholders.NewsViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private NewsDelegate mNewsDelegate;

    private List<NewsVO> mNewsList;

    public NewsAdapter(NewsDelegate newsDelegate) {
        mNewsDelegate = newsDelegate;
        mNewsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_news, parent, false);
        return new NewsViewHolder(view, mNewsDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.setNewsData(mNewsList.get(position));

    }


    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void setNewsList(List<NewsVO> mNewsList) {
        this.mNewsList = mNewsList;
        notifyDataSetChanged();
    }

}
