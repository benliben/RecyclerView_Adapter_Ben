package com.example.benben.recyclerview_adapter.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.benben.rcyclerviewlibrary.R;
import com.example.benben.recyclerview_adapter.bean.WaterModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benben on 2016/5/10.
 */
public  class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.ViewHolder> {


        private List<Integer> mHeights;

        private OnItemClickListener mListener;

        private List<WaterModel> mModel;

        public WaterFallAdapter(List<WaterModel> mModel) {
            this.mModel = mModel;
            getRandomHeight(this.mModel);
        }

        /**
         * 产生随机的Item的高度
         */
    private void getRandomHeight(List<WaterModel> mModel) {
        mHeights = new ArrayList<>();
        for (int i = 0; i < mModel.size(); i++) {
            mHeights.add((int) (200 + Math.random() * 200));
        }
    }

    /**创建viewHolder*/
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder view= null;
        if (view == null) {
            view = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_water, parent));
        }
        return view;
    }

    /**绑定viewHolder*/
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ViewGroup.LayoutParams params=holder.itemView.getLayoutParams();//得到item的LayoutParams布局参数
        params.height = mHeights.get(position);//把随机的高度赋值给Item布局
        holder.itemView.setLayoutParams(params);//把params设置给item布局

        /**为控件绑定数据*/

        holder.mText.setText(mModel.get(position).getName());

        /**设置监听*/
        if (mListener != null) {//如果设置了监听那么他就不为空 然后回调相应的方法
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();//得到当前点击item的位置pos
                    mListener.ItemClickListener(holder.itemView,pos);//把事情交给实现的接口来处理
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();//得到当前点击的item的位置
                    mListener.ItemLongClickListener(holder.itemView, pos);//把事情交给实现的接口来处理
                    return true;
                }
            });

        }
    }

    /**获取Item的数量*/
    @Override
    public int getItemCount() {
        return mModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mText;
        public ViewHolder(View itemView) {
            super(itemView);
            mText = (TextView) itemView.findViewById(R.id.water_item);


        }
    }


    public interface  OnItemClickListener{
        void ItemClickListener(View view, int position);

        void ItemLongClickListener(View view, int position);
    }
    public void setOnClickListener(OnItemClickListener listener){

        this.mListener = listener;

    }
}
