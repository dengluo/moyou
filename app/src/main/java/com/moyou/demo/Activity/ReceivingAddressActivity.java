package com.moyou.demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;

/**
 * Created by danny on 2018/10/31.
 * ---收货地址---
 */

public class ReceivingAddressActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_receiving_address_address;
    private RelativeLayout rl_add_receiving_address;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving_address);
//        setStatusBar();
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_receiving_address_address = findViewById(R.id.tv_receiving_address_address);
        rl_add_receiving_address = findViewById(R.id.rl_add_receiving_address);
        String str="<font color='#3F51B5'>[默认地址]</font>广东省深圳市龙华新区大浪街道华荣路联建科技园七栋二楼A区";
        tv_receiving_address_address.setTextSize(12);
        tv_receiving_address_address.setText(Html.fromHtml(str));
        iv_back.setOnClickListener(this);
        rl_add_receiving_address.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_add_receiving_address:
                startActivity(new Intent(this, AddReceivingAddressActivity.class));
                break;
        }
    }
}