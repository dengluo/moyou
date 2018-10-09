package com.moyou.demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.moyou.demo.R;
import com.moyou.demo.alipay.PayDemoActivity;
import com.moyou.demo.base.BaseActivity;

/**
 * Created by danny on 2018/6/15.
 * 会员中心
 */

public class MemberCenterActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv_back, iv_member_privileges;
    private RelativeLayout rl_vip_member, rl_vendors_member, rl_product_member, rl_weixin_pay, rl_ali_pay, rl_balance_payment;
    private ImageView iv_vip_member, iv_vendors_member, iv_product_member, iv_weixin_pay, iv_ali_pay, iv_balance_payment;
    private TextView tv_confirm_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_center);

        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_member_privileges = (ImageView) findViewById(R.id.iv_member_privileges);
        rl_vip_member = (RelativeLayout) findViewById(R.id.rl_vip_member);
        rl_vendors_member = (RelativeLayout) findViewById(R.id.rl_vendors_member);
        rl_product_member = (RelativeLayout) findViewById(R.id.rl_product_member);
        rl_weixin_pay = (RelativeLayout) findViewById(R.id.rl_weixin_pay);
        rl_ali_pay = (RelativeLayout) findViewById(R.id.rl_ali_pay);
        rl_balance_payment = (RelativeLayout) findViewById(R.id.rl_balance_payment);
        tv_confirm_payment = (TextView) findViewById(R.id.tv_confirm_payment);

        iv_vip_member = (ImageView) findViewById(R.id.iv_vip_member);
        iv_vendors_member = (ImageView) findViewById(R.id.iv_vendors_member);
        iv_product_member = (ImageView) findViewById(R.id.iv_product_member);
        iv_weixin_pay = (ImageView) findViewById(R.id.iv_weixin_pay);
        iv_ali_pay = (ImageView) findViewById(R.id.iv_ali_pay);
        iv_balance_payment = (ImageView) findViewById(R.id.iv_balance_payment);

        rl_vip_member.setOnClickListener(this);
        rl_vendors_member.setOnClickListener(this);
        rl_product_member.setOnClickListener(this);
        rl_weixin_pay.setOnClickListener(this);
        rl_ali_pay.setOnClickListener(this);
        rl_balance_payment.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_member_privileges.setOnClickListener(this);
        tv_confirm_payment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_confirm_payment:
                startActivity(new Intent(this, PayDemoActivity.class));
                break;
            case R.id.iv_member_privileges:
                startActivity(new Intent(this, MemberPrivilegesActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
            case R.id.rl_vip_member:
                iv_vip_member.setImageResource(R.mipmap.check_unselect);
                iv_vendors_member.setImageResource(R.mipmap.check_null);
                iv_product_member.setImageResource(R.mipmap.check_null);
                break;
            case R.id.rl_vendors_member:
                iv_vip_member.setImageResource(R.mipmap.check_null);
                iv_vendors_member.setImageResource(R.mipmap.check_unselect);
                iv_product_member.setImageResource(R.mipmap.check_null);
                break;
            case R.id.rl_product_member:
                iv_vip_member.setImageResource(R.mipmap.check_null);
                iv_vendors_member.setImageResource(R.mipmap.check_null);
                iv_product_member.setImageResource(R.mipmap.check_unselect);
                break;

            case R.id.rl_weixin_pay:
                iv_weixin_pay.setImageResource(R.mipmap.check_select);
                iv_ali_pay.setImageResource(R.mipmap.check_null);
                iv_balance_payment.setImageResource(R.mipmap.check_null);
                break;
            case R.id.rl_ali_pay:
                iv_weixin_pay.setImageResource(R.mipmap.check_null);
                iv_ali_pay.setImageResource(R.mipmap.check_select);
                iv_balance_payment.setImageResource(R.mipmap.check_null);
                break;
            case R.id.rl_balance_payment:
                iv_weixin_pay.setImageResource(R.mipmap.check_null);
                iv_ali_pay.setImageResource(R.mipmap.check_null);
                iv_balance_payment.setImageResource(R.mipmap.check_select);
                break;
        }
    }
}
