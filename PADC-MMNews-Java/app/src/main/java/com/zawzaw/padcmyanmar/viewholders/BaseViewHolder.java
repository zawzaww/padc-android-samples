package com.zawzaw.padcmyanmar.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zawzaw on 12/07/2018.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected T mData;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(T data);

}
