package com.zawzaw.hellopadc.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zawzaw.hellopadc.R;
import com.zawzaw.hellopadc.data.vos.NewsVO;
import com.zawzaw.hellopadc.delegates.NewsDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private NewsDelegate mNewsDelegate;

    private NewsVO mNews;

    @BindView(R.id.tv_news_brief) TextView tvNewsBrief;

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
    }
}
