package com.moyou.demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;

/**
 * 查看大家的手气
 * 收到的红包
 * Created by shun8 on 2018/7/21.
 */

public class RedPacketRecord extends BaseActivity implements View.OnClickListener{
    ImageView iv_back;
    ImageView iv_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redpacket_record);

        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_menu = (ImageView) findViewById(R.id.iv_menu);
        iv_back.setOnClickListener(this);
        iv_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_menu:
                startActivity(new Intent(this,WalletActivity2.class));
                break;
        }
    }
}
