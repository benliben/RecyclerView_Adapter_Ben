package com.example.benben.recyclerview_adapter.ui.adapter;


import android.content.Context;

import com.example.benben.rcyclerviewlibrary.ViewHolder;
import com.example.benben.rcyclerviewlibrary.abslistview.MultiItemCommonAdapter;
import com.example.benben.rcyclerviewlibrary.abslistview.MultiItemTypeSupport;
import com.example.benben.recyclerview_adapter.R;
import com.example.benben.recyclerview_adapter.bean.ChatModel;

import java.util.List;

/**
 * Created by benben on 2016/5/7.
 * 聊天的适配器
 */
public class ChatAdapter extends MultiItemCommonAdapter<ChatModel> {
    public ChatAdapter(Context context, List<ChatModel> datas) {
        super(context, datas, new MultiItemTypeSupport<ChatModel>() {
            @Override
            public int getLayoutId(int position, ChatModel msg) {
                if (msg.isComMeg()) {
                    return R.layout.main_chat_from_msg;
                }
                return R.layout.main_chat_send_msg;
            }

            @Override
            public int getViewTypeCount()
            {
                return 2;
            }
            @Override
            public int getItemViewType(int postion, ChatModel msg)
            {
                if (msg.isComMeg())
                {
                    return ChatModel.RECIEVE_MSG;
                }
                return ChatModel.SEND_MSG;
            }
        });
    }

    @Override
    public void convert(ViewHolder holder, ChatModel chatMessage)
    {

        switch (holder.getLayoutId())
        {
            /**接收的数据*/
            case R.layout.main_chat_from_msg:
                holder.setText(R.id.chat_from_content, chatMessage.getContent());
                holder.setText(R.id.chat_from_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_from_icon, chatMessage.getIcon());
                break;
            /**发送的数据*/
            case R.layout.main_chat_send_msg:
                holder.setText(R.id.chat_send_content, chatMessage.getContent());
                holder.setText(R.id.chat_send_name, chatMessage.getName());
                holder.setImageResource(R.id.chat_send_icon, chatMessage.getIcon());
                break;
        }
    }
}
