package com.zawzaw.padcmyanmar.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.zawzaw.padcmyanmar.R;
import com.zawzaw.padcmyanmar.data.models.NewsModel;
import com.zawzaw.padcmyanmar.data.vos.NewsVO;
import com.zawzaw.padcmyanmar.viewpods.EmptyViewPod;

public class NewsDetailsActivity extends BaseActivity {

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetails;

    @BindView(R.id.vp_empty_details)
    EmptyViewPod vpEmptyView;

    @BindView(R.id.coordinatorlayout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this, this);

        String newsId = getIntent().getStringExtra("newsId");
        Log.d("NewsDetailActiviy", "newsId : " + newsId);

        NewsVO news = NewsModel.getObjInstance().getNewsById(newsId);

        if (news != null) {
            bindData(news);
        } else {
            vpEmptyView.setVisibility(View.VISIBLE);
            coordinatorLayout.setVisibility(View.GONE);
        }

        vpEmptyView.setEmptyData("http://tiny.cc/mww2uy", getString(R.string.empty_msgsage_details));

    }

    private void bindData(NewsVO news) {
        tvNewsDetails.setText(news.getDetails());
    }

}
