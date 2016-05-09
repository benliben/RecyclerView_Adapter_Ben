package com.example.benben.recyclerview_adapter.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.benben.rcyclerviewlibrary.recyclerview.OnItemClickListener;

import com.example.benben.recyclerview_adapter.R;
import com.example.benben.recyclerview_adapter.bean.ChatModel;
import com.example.benben.recyclerview_adapter.ui.adapter.ChatAdapterForRv;

/**
 * Created by benben on 2016/5/6.
 * 多个item用recyclerView
 */

public class MultiItemRvActivity extends AppCompatActivity
{
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ChatAdapterForRv adapter = new ChatAdapterForRv(this, ChatModel.MOCK_DATAS);
        adapter.setOnItemClickListener(new OnItemClickListener<ChatModel>()
        {
            @Override
            public void onItemClick(ViewGroup parent, View view, ChatModel o, int position)
            {
                Toast.makeText(MultiItemRvActivity.this, "Click:" + position + " => " + o.getContent(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, ChatModel o, int position)
            {
                Toast.makeText(MultiItemRvActivity.this, "LongClick:" + position + " => " + o.getContent(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mRecyclerView.setAdapter(adapter);
    }


}
