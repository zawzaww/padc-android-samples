package com.zawzaw.padcmyanmar.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zawzaw.padcmyanmar.data.vos.NewsVO;

/**
 * Created by zawzaw on 03/07/2018.
 */

public abstract class BaseNewsViewHolder extends RecyclerView.ViewHolder {

    public BaseNewsViewHolder(View itemView) {
        super(itemView);
    }

    public void bindData(NewsVO news) {

    }

}
