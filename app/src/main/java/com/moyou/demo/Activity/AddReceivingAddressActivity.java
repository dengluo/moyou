package com.moyou.demo.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;

/**
 * Created by danny on 2018/11/1.
 * ---新增收货地址---
 */

public class AddReceivingAddressActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_confirm_receiving_address;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_receiving_address);
//        setStatusBar();
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_confirm_receiving_address = findViewById(R.id.tv_confirm_receiving_address);
        iv_back.setOnClickListener(this);
        tv_confirm_receiving_address.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_confirm_receiving_address:
                finish();
                break;
        }
    }
}