package com.zawzaw.padcmyanmar.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.bumptech.glide.request.RequestOptions;
import com.zawzaw.padcmyanmar.R;
import com.zawzaw.padcmyanmar.data.vos.NewsVO;
import com.zawzaw.padcmyanmar.delegates.NewsDelegate;
import com.zawzaw.padcmyanmar.utils.GlideApp;

public class NewsViewHolder extends BaseNewsViewHolder {

    private NewsDelegate mNewsDelegate;
    private NewsVO mNews;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBrief;

    @BindView(R.id.iv_news_header)
    ImageView ivNewsHeaderImage;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    public NewsViewHolder(View itemView, NewsDelegate newsDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        mNewsDelegate = newsDelegate;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewsDelegate.onTapNews(mNews);
            }
        });
    }

    @Override
    public void bindData(NewsVO news) {
        mNews = news;

        // News header image.
        if (!news.getImages().isEmpty()) {
            GlideApp.with(ivNewsHeaderImage.getContext())
                    .load(news.getImages().get(0))
                    .placeholder(R.drawable.placeholder_img_black)
                    .error(R.drawable.error_image)
                    .into(ivNewsHeaderImage);
        } else {
            ivNewsHeaderImage.setVisibility(View.GONE);
        }

        // Publication logo.
        GlideApp.with(ivPublicationLogo.getContext())
                .load(news.getPublication().getLogo())
                .apply(RequestOptions
                        // Change to circle image icon design.
                        .circleCropTransform()
                        .placeholder(R.drawable.placeholder_img_black)
                        .error(R.drawable.error_image))
                .into(ivPublicationLogo);

        // News brief.
        tvNewsBrief.setText(news.getBrief());

        // Publication title.
        tvPublicationTitle.setText(news.getPublication().getTitle());

        // Posted at date.
        tvPostedDate.setText(tvPostedDate.getContext().getResources()
                .getString(R.string.format_posted_date, news.getPostedDate()));
    }
}
