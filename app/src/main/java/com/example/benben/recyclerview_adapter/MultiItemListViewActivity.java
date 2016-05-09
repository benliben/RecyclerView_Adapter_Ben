package com.example.benben.recyclerview_adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.benben.recyclerview_adapter.adapter.ChatAdapter;
import com.example.benben.recyclerview_adapter.bean.ChatMessage;


public class MultiItemListViewActivity extends AppCompatActivity
{

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.id_listview_list);
        mListView.setDivider(null);
        mListView.setAdapter(new ChatAdapter(this, ChatMessage.MOCK_DATAS));

    }

}
