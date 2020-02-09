package com.example.uibasepractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.viewHolder> {
    private List<Msg> mMsgList;

    public MsgAdapter(List<Msg> mMsgList) {
        this.mMsgList = mMsgList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.msg_item, viewGroup, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        Msg msg = mMsgList.get(i);
        if (Msg.TYPE_RECEEIVED == msg.getType()) {
            //收到的显示在左边，隐藏 右边布局
            viewHolder.LeftLayout.setVisibility(View.VISIBLE);
            viewHolder.RightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());

        } else if (Msg.TYPE_SENT == msg.getType()) {
            viewHolder.RightLayout.setVisibility(View.VISIBLE);
            viewHolder.LeftLayout.setVisibility(View.GONE);
            viewHolder.rightMsg.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder {
        LinearLayout LeftLayout;
        LinearLayout RightLayout;
        TextView leftMsg;
        TextView rightMsg;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            LeftLayout = itemView.findViewById(R.id.left_layout);
            RightLayout = itemView.findViewById(R.id.right_layout);
            leftMsg = itemView.findViewById(R.id.left_msg);
            rightMsg = itemView.findViewById(R.id.right_msg);
        }
    }
}
