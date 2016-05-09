package com.example.benben.recyclerview_adapter.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.example.benben.recyclerview_adapter.R;

/**
 * Created by tangjunjie on 2016/5/9.
 */
public class GridViewActivity extends BaseActivity {
    public static void startGridViewActivity(Activity activity) {
        Intent intent = new Intent(activity, GridViewActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }
}
