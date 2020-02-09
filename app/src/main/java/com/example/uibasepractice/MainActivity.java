package com.example.uibasepractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> mMsgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        final RecyclerView recyclerView = findViewById(R.id.msg_recycler_view);
        final EditText editText = findViewById(R.id.edit_input_text);
        Button SentButton = findViewById(R.id.btn_send);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        final MsgAdapter msgAdapter = new MsgAdapter(mMsgList);
        recyclerView.setAdapter(msgAdapter);

        SentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Content = editText.getText().toString();
                if (!"".equals(Content)) {// 不能是 空内容
                    Msg msg = new Msg(Content, Msg.TYPE_SENT);
                    mMsgList.add(msg);

                    msgAdapter.notifyItemInserted(mMsgList.size() - 1);//通知Item插入一天数据
                    //刷新ListView中的显示
                    recyclerView.scrollToPosition(mMsgList.size() - 1); // 滚动到当前位置达到刷新效果

                    editText.setText("");

                }
            }
        });


    }

    private void initMsgs() {
        Msg msg1 = new Msg("靓仔", Msg.TYPE_RECEEIVED);
        mMsgList.add(msg1);
        Msg msg2 = new Msg("周大哥，怎么了", Msg.TYPE_SENT);
        mMsgList.add(msg2);
        Msg msg3 = new Msg("靓仔，我看你骨骼惊奇,是块偷电瓶的料，偷电瓶么咯，我教你你哦", Msg.TYPE_RECEEIVED);
        mMsgList.add(msg3);
    }
}
