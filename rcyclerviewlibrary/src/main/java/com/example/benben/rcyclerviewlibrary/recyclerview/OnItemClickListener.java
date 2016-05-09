package com.example.benben.rcyclerviewlibrary.recyclerview;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by benben on 2016/5/6.
 */
public interface  OnItemClickListener <T>
{
    void onItemClick(ViewGroup parent, View view, T t, int position);
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}
