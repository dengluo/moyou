package com.moyou.demo.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;

public class EditInfoActivity extends BaseActivity implements View.OnClickListener, View.OnKeyListener {
    ImageView iv_back;
    Context context;
    TextView tv_personinfo_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo);
        context = EditInfoActivity.this;
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_personinfo_name = (TextView) findViewById(R.id.tv_personinfo_name);
        iv_back.setOnClickListener(this);
        tv_personinfo_name.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_personinfo_name:
                startActivity(new Intent(this, MemberCenterActivity.class));
                break;
        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }
}
