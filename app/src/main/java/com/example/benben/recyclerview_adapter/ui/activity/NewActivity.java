package com.example.benben.recyclerview_adapter.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.benben.rcyclerviewlibrary.ViewHolder;
import com.example.benben.rcyclerviewlibrary.recyclerview.DividerItemDecoration;
import com.example.benben.rcyclerviewlibrary.recyclerview.OnItemClickListener;
import com.example.benben.rcyclerviewlibrary.recyclerview.support.SectionAdapter;
import com.example.benben.rcyclerviewlibrary.recyclerview.support.SectionSupport;
import com.example.benben.recyclerview_adapter.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benben on 2016/5/7.
 */
public class NewActivity extends AppCompatActivity {
    @InjectView(R.id.id_recyclerview)
    RecyclerView mRecyclerview;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.inject(this);
        initDatas();
        initView();
    }

    private void initView() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        /**
         * 第一个指定header 的布局文件
         * 第二个指定布局文件textView的id
         * 第三个指定显示什么样式的标题（根据adapter的bean）
         */

        SectionSupport<String> stringSectionSupport = new SectionSupport<String>() {
            @Override
            public int sectionHeaderLayoutId() {
                return R.layout.header;
            }

            @Override
            public int sectionTitleTextViewId() {
                return R.id.id_header_title;
            }

            @Override
            public String getTitle(String s) {
                return s.substring(0, 1);
            }
        };

        SectionAdapter<String> adapter = new SectionAdapter<String>(
                this, R.layout.item_list, mDatas, stringSectionSupport) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.id_item_list_title, s);
            }
        };

        adapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, String s, int position) {
                Toast.makeText(NewActivity.this, "Click:" + position + " => " + s, Toast.LENGTH_SHORT).show();

            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, String s, int position) {
                Toast.makeText(NewActivity.this, "再按我就跟你玩消失" + s, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        mRecyclerview.setAdapter(adapter);
    }

    private void initDatas() {
        for (int i = 1; i < 3; i++) {
            mDatas.add("A" + i);
        }
        for (int i = 1; i < 5; i++) {
            mDatas.add("B" + i);
        }
        for (int i = 1; i < 7; i++) {
            mDatas.add("C" + i);
        }
        for (int i = 1; i < 9; i++) {
            mDatas.add("D" + i);
        }
        for (int i = 1; i < 11; i++) {
            mDatas.add("E" + i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**/
        getMenuInflater().inflate(R.menu.menu_rv_width_header, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
