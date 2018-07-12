package com.zawzaw.padcmyanmar.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zawzaw.padcmyanmar.R;
import com.zawzaw.padcmyanmar.data.vos.NewsVO;
import com.zawzaw.padcmyanmar.delegates.NewsDelegate;
import com.zawzaw.padcmyanmar.viewholders.BaseNewsViewHolder;
import com.zawzaw.padcmyanmar.viewholders.NewsBriefViewHolder;
import com.zawzaw.padcmyanmar.viewholders.NewsViewHolder;

public class NewsAdapter extends BaseRecyclerAdapter<BaseNewsViewHolder, NewsVO> {

    private static final int VT_NEWS_COMPLETE = 1000;
    private static final int VT_NEWS_BRIEF = 2000;

    private NewsDelegate mNewsDelegate;

    public NewsAdapter(NewsDelegate newsDelegate) {
        super();
        mNewsDelegate = newsDelegate;
    }

    @NonNull
    @Override
    public BaseNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (viewType == VT_NEWS_COMPLETE) {
            View view = layoutInflater.inflate(R.layout.view_holder_news,
                    parent, false);
            return new NewsViewHolder(view, mNewsDelegate);
        } else {
            View view = layoutInflater.inflate(R.layout.view_holder_news_brief,
                    parent, false);
            return new NewsBriefViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VT_NEWS_COMPLETE;
        } else
            return VT_NEWS_BRIEF;
    }

}
