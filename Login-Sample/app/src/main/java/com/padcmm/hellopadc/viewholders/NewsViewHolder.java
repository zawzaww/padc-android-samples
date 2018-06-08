package com.padcmm.hellopadc.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.padcmm.hellopadc.delegates.NewsDelegate;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private NewsDelegate mNewsDelegate;

    public NewsViewHolder(View itemView, NewsDelegate newsDelegate) {
        super(itemView);
        mNewsDelegate = newsDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewsDelegate.onTapNews();
            }
        });

    }

}
