package com.zawzaw.hellopadc.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.zawzaw.hellopadc.R;
import com.zawzaw.hellopadc.data.vos.NewsVO;
import com.zawzaw.hellopadc.delegates.NewsDelegate;
import com.zawzaw.hellopadc.module.GlideApp;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private NewsDelegate mNewsDelegate;

    private NewsVO mNews;

    @BindView(R.id.tv_news_brief) TextView tvNewsBrief;
    @BindView(R.id.iv_news_header) ImageView ivNewsHeaderImage;

    public NewsViewHolder(View itemView, NewsDelegate newsDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mNewsDelegate = newsDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewsDelegate.onTapNews();
            }
        });
    }

    public void setNewsData(NewsVO news) {
        mNews = news;

        tvNewsBrief.setText(news.getBrief());

        if (!news.getImages().isEmpty()) {
            GlideApp.with(ivNewsHeaderImage.getContext())
                    .load(news.getImages().get(0))
                    .into(ivNewsHeaderImage);
        } else {
            ivNewsHeaderImage.setVisibility(View.GONE);
        }

    }
}
