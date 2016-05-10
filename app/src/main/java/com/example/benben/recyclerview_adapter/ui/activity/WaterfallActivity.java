package com.example.benben.recyclerview_adapter.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.benben.rcyclerviewlibrary.ViewHolder;
import com.example.benben.rcyclerviewlibrary.recyclerview.CommonAdapter;
import com.example.benben.recyclerview_adapter.R;
import com.example.benben.recyclerview_adapter.bean.WaterModel;
import com.example.benben.recyclerview_adapter.ui.adapter.WaterFallAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by benben on 2016/5/9.
 */
public class WaterfallActivity extends BaseActivity {
    @InjectView(R.id.waterfall_content)
    RecyclerView mContent;
    private WaterFallAdapter mAdapter;
    private List<WaterModel> mModel=new ArrayList<>();

    private List<String> mDates = new ArrayList<>();

    public static void startWaterfallActivity(Activity activity) {
        Intent intent = new Intent(activity, WaterfallActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall);
        ButterKnife.inject(this);
        initView();
        initDates();
    }

    private void initDates() {
        for (int i = 0; i < 100; i++) {
            WaterModel model = new WaterModel();
            model.setName(i + "");
            mModel.add(model);
        }
        mAdapter = new WaterFallAdapter(mModel);
        mContent.setAdapter(mAdapter);
    }

    private void initView() {

        mContent.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }


}
