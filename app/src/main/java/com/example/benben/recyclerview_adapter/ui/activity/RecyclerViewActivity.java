package com.example.benben.recyclerview_adapter.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.example.benben.rcyclerviewlibrary.ViewHolder;
import com.example.benben.rcyclerviewlibrary.recyclerview.CommonAdapter;
import com.example.benben.rcyclerviewlibrary.recyclerview.DividerItemDecoration;
import com.example.benben.recyclerview_adapter.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by benben on 2016/5/6.
 *
 */
public class RecyclerViewActivity extends AppCompatActivity
{

    private RecyclerView mRecyclerView;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initDatas();

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

        /**通过manager来设置为listView*/
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        /**设置listView的方向*/
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));


        /**
         * 找到item的id和数据
         */
        mRecyclerView.setAdapter(new CommonAdapter<String>(this,R.layout.item_list,mDatas) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.id_item_list_title, s);
            }
        });

    }

    /**数据*/
    private void initDatas() {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add((char) i + "");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("lyx", "你点击了home键");
    }
}
