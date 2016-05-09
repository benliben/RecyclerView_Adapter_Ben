package com.example.benben.rcyclerviewlibrary.abslistview;

/**
 * Created by benben on 2016/5/6.
 */
public interface MultiItemTypeSupport<T> {
    int getLayoutId(int position, T t);

    int getViewTypeCount();

    int getItemViewType(int position, T t);
}
