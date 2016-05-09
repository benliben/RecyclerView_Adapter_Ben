package com.example.benben.rcyclerviewlibrary.recyclerview;

/**
 * Created by benben on 2016/5/6.
 */
public interface MultiItemTypeSupport<T>
{
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}
