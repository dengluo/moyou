package com.moyou.demo.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;

/**
 * 好友聊天信息
 * Created by shun8 on 2018/6/29.
 */

public class FriendsChatActivity extends BaseActivity implements View.OnClickListener{
    ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_chat);

        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
