package com.moyou.demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;

/**
 * Created by gaolei on 16/12/29.
 * 转出到银行卡/零钱提现
 */

public class PocketMoneyActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocket_money);
//        setStatusBar();
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