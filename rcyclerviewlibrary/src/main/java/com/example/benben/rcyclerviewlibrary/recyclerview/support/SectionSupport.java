package com.example.benben.rcyclerviewlibrary.recyclerview.support;

/**
 * Created by benben on 2016/5/6.
 */
public interface SectionSupport<T>
{
    public int sectionHeaderLayoutId();

    public int sectionTitleTextViewId();

    public String getTitle(T t);
}
