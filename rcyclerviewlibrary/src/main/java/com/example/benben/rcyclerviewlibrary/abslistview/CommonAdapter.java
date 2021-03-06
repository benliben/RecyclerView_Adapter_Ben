package com.example.benben.rcyclerviewlibrary.abslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.benben.rcyclerviewlibrary.ViewHolder;

import java.util.List;

/**
 * Created by benben on 2016/5/6.
 * 普通的adapter
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private int layoutId;

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        this.mContext = context;
        mInflater=LayoutInflater.from(context);
        this.mDatas = datas;
        this.layoutId = layoutId;
    }



    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, layoutId, position);
        convert(holder, (T) getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T t);
}
