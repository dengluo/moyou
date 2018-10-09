package com.moyou.demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.moyou.demo.R;
import com.moyou.demo.Adapter.ChargeAmountAdapter;
import com.moyou.demo.Adapter.ChargeAmountDividerDecoration;
import com.moyou.demo.base.BaseActivity;
import com.moyou.demo.util.Utils;

/**
 * Created by gaolei on 16/12/29.
 * 收到的红包---我的钱包---
 */

public class WalletActivity2 extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back;
    private LinearLayout ll_pocket_money;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet2);
//        setStatusBar();
        iv_back = (ImageView) findViewById(R.id.iv_back);
        ll_pocket_money = (LinearLayout) findViewById(R.id.ll_pocket_money);
        iv_back.setOnClickListener(this);
        ll_pocket_money.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_pocket_money:
                startActivity(new Intent(this,PocketMoneyActivity.class));
                break;
        }
    }
}