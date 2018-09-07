package com.zawzaw.padcmyanmar.adapters;

import java.util.ArrayList;
import java.util.List;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.zawzaw.padcmyanmar.data.vos.NewsVO;
import com.zawzaw.padcmyanmar.viewholders.BaseNewsViewHolder;
import com.zawzaw.padcmyanmar.viewholders.BaseViewHolder;

/**
 * Created by zawzaw on 12/07/2018.
 */

public abstract class BaseRecyclerAdapter<VH extends BaseViewHolder<D>, D> extends RecyclerView.Adapter<VH> {

    protected List<D> mData;

    public BaseRecyclerAdapter() {
        super();
        mData = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bindData(mData.get(position));
    }

    public void setNewsList(List<D> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    public void appendNewsList(List<D> data) {
        mData.addAll(data);
        notifyDataSetChanged();
    }


}
