package com.example.benben.recyclerview_adapter.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.benben.rcyclerviewlibrary.ViewHolder;
import com.example.benben.rcyclerviewlibrary.abslistview.CommonAdapter;
import com.example.benben.recyclerview_adapter.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> mDatas = new ArrayList<>(Arrays.asList("MultiItem ListView",
            "RecyclerView",
            "MultiItem RecyclerView", "RecyclerViewWithHeader", "New", "ListView"
            , "GridView", "瀑布流"));
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = ((ListView) findViewById(R.id.id_listview_list));
        mListView.setAdapter(new CommonAdapter<String>(this, mDatas, R.layout.item_list) {
            @Override
            public void convert(ViewHolder holder, String o) {
                holder.setText(R.id.id_item_list_title, o);
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                    default:
                        intent = new Intent(MainActivity.this, MultiItemListViewActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, MultiItemRvActivity.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, RvWidthHeaderActivity.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, NewActivity.class);
                        break;
                    case 5:
                        ListViewActivity.startListViewActvity(MainActivity.this);
                        break;
                    case 6:
                        GridViewActivity.startGridViewActivity(MainActivity.this);
                        break;
                    case 7:
                        WaterfallActivity.startWaterfallActivity(MainActivity.this);
                        break;


                }
                if (intent != null)
                    startActivity(intent);
            }
        });
    }


}
