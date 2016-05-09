package com.example.benben.recyclerview_adapter.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import com.example.benben.recyclerview_adapter.R;
import com.example.benben.recyclerview_adapter.bean.ChatModel;
import com.example.benben.recyclerview_adapter.ui.adapter.ChatAdapter;

/**
 * Created by benben on 2016/5/6.
 * 多个item用listView
 */

public class MultiItemListViewActivity extends AppCompatActivity
{

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.id_listview_list);
        /**不设置分柜器*/
        mListView.setDivider(null);
        /**设置adapter*/
        mListView.setAdapter(new ChatAdapter(this, ChatModel.MOCK_DATAS));

    }

}
