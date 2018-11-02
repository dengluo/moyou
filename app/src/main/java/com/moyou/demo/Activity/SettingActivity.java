package com.moyou.demo.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;

/**
 * Created by danny on 2018/11/1.
 * ---首页左侧滑设置---
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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
            case R.id.tv_confirm_receiving_address:
                finish();
                break;
        }
    }
}