package com.example.benben.recyclerview_adapter.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.benben.rcyclerviewlibrary.ViewHolder;
import com.example.benben.rcyclerviewlibrary.recyclerview.CommonAdapter;
import com.example.benben.recyclerview_adapter.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by tangjunjie on 2016/5/9.
 */
public class GridViewActivity extends BaseActivity {

    @InjectView(R.id.grid_content)
    RecyclerView mContent;
    private List<String> mDates;

    public static void startGridViewActivity(Activity activity) {
        Intent intent = new Intent(activity, GridViewActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        ButterKnife.inject(this);
        initDate();
        initView();
    }

    private void initDate() {
        mDates = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDates.add(i + "");
        }
    }

    private void initView() {
        mContent.setLayoutManager(new GridLayoutManager(GridViewActivity.this,3));

        mContent.setAdapter(new CommonAdapter<String>(this,R.layout.item_grid,mDates) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.grid_item, s);
            }
        });
    }

}
