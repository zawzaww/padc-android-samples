package com.zawzaw.padcmyanmar.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zawzaw.padcmyanmar.R;
import com.zawzaw.padcmyanmar.utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zawzaw on 27/06/2018.
 */

public class EmptyViewPod extends RelativeLayout {

    @BindView(R.id.iv_empty_image) ImageView ivEmptyImage;
    @BindView(R.id.tv_empty_text) TextView tvEmptyText;

    public EmptyViewPod(Context context) {
        super(context);

    }

    public EmptyViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public EmptyViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);

    }

    public void setEmptyData(String emptyImgUrl, String emptyMessage) {

        GlideApp.with(getContext())
                .load(emptyImgUrl)
                .into(ivEmptyImage);

        tvEmptyText.setText(emptyMessage);

    }

    public void setEmptyData(int emptyImgResource, String emptyMessage) {

        ivEmptyImage.setImageResource(emptyImgResource);
        tvEmptyText.setText(emptyMessage);

    }

}
