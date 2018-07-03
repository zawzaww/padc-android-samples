package com.zawzaw.padcmyanmar.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.zawzaw.padcmyanmar.R;
import com.zawzaw.padcmyanmar.data.vos.NewsVO;
import com.zawzaw.padcmyanmar.utils.GlideApp;

/**
 * Created by zawzaw on 03/07/2018.
 */

public class NewsBriefViewHolder extends BaseNewsViewHolder {

    private NewsVO mNews;

    @BindView(R.id.tv_newspub_title)
    TextView tvPubTitle;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBrief;

    @BindView(R.id.iv_news_heroimage)
    ImageView ivHeroImage;

    public NewsBriefViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(NewsVO news) {
        mNews = news;

        // Publication title
        tvPubTitle.setText(news.getPublication().getTitle());

        // News brief
        tvNewsBrief.setText(news.getBrief());

        // News hero image/header image
        if (!news.getImages().isEmpty()) {
            GlideApp.with(ivHeroImage.getContext())
                    .load(news.getImages().get(0))
                    .placeholder(R.drawable.placeholder_img_black)
                    .error(R.drawable.error_image)
                    .into(ivHeroImage);
        } else {
            ivHeroImage.setVisibility(View.GONE);
        }
    }
}
