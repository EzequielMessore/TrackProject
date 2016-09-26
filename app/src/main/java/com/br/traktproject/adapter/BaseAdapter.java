package com.br.traktproject.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.br.traktproject.helpers.ContextHelper;

import java.util.List;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */

public abstract class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<? extends Parcelable> mList;

    public BaseAdapter(List<? extends Parcelable> list) {
        mList = list;
    }

    public void setList(List<? extends Parcelable> list) {
        if (list != null && !list.isEmpty()) {
            mList = list;
            notifyDataSetChanged();
        }
    }

    protected Context getContext(){
        return ContextHelper.getInstance().getApplicationContext();
    }

    public List<? extends Parcelable> getList() {
        return mList;
    }

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return getList().size();
    }

}
