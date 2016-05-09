package com.example.benben.recyclerview_adapter.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.benben.rcyclerviewlibrary.recyclerview.OnItemClickListener;
import com.example.benben.recyclerview_adapter.R;
import com.example.benben.recyclerview_adapter.bean.ChatMessage;
import com.example.benben.recyclerview_adapter.ui.adapter.ChatAdapterForRv;

/**
 * Created by benben on 2016/5/9.
 */
public class ListViewActivity extends BaseActivity {
    public static void startListViewActvity(Activity activity) {
        Intent intent = new Intent(activity, ListViewActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    private RecyclerView mContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
    }

    private void initView() {
        mContent = (RecyclerView) findViewById(R.id.list_content);
        mContent.setLayoutManager(new LinearLayoutManager(this));
        ChatAdapterForRv mAdapter = new ChatAdapterForRv(this, ChatMessage.MOCK_DATAS);
        mAdapter.setOnItemClickListener(new OnItemClickListener<ChatMessage>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, ChatMessage chatMessage, int position) {
                Toast.makeText(ListViewActivity.this, "Click" + position + "=>" + chatMessage.getContent(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, ChatMessage chatMessage, int position) {
                Toast.makeText(ListViewActivity.this, "再按我就删除" + position + "=>" + chatMessage.getContent(), Toast.LENGTH_SHORT).show();
                return false;
            }

        });
        mContent.setAdapter(mAdapter);
    }
}
