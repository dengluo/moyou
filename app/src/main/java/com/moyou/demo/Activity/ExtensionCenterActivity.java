package com.moyou.demo.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.moyou.demo.Adapter.ExtensionFragmentPagerAdapter;
import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;
import com.moyou.demo.util.NetworkUtil;

/**
 * 推广中心
 * Created by danny on 2018/6/8.
 */

public class ExtensionCenterActivity extends BaseActivity implements View.OnClickListener {
    ImageView iv_menu;
    ImageView iv_back;
    ViewPager vpager;
    RadioGroup rg_tab_bar;
    RadioButton rb_pro1;
    RadioButton rb_pro2;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    private Context context;
    private ExtensionFragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension_center);

        initView();
        context = this;
        if (!NetworkUtil.isNetworkAvailable(context)) {
            Toast.makeText(context, "网络连接异常!", Toast.LENGTH_SHORT).show();
        }
        iv_back.setOnClickListener(this);
        iv_menu.setOnClickListener(this);
    }

    protected void initView() {
        iv_menu = (ImageView) findViewById(R.id.iv_menu);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        vpager = (ViewPager) findViewById(R.id.extensionsPager);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_pro1 = (RadioButton) findViewById(R.id.rb_pro1);
        rb_pro2 = (RadioButton) findViewById(R.id.rb_pro2);

        rb_pro2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
        rb_pro1.setBackgroundResource(0);
        rb_pro1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
        rb_pro2.setBackgroundResource(0);

        mAdapter = new ExtensionFragmentPagerAdapter(this.getSupportFragmentManager());
        rb_pro1.setChecked(true);
        rg_tab_bar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_pro1:
                        vpager.setCurrentItem(PAGE_ONE);
                        rb_pro1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_pro2.setBackgroundResource(0);
                        break;
                    case R.id.rb_pro2:
                        vpager.setCurrentItem(PAGE_TWO);
                        rb_pro2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_pro1.setBackgroundResource(0);
                        break;
                }
            }
        });

        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
                if (state == 2) {
                    switch (vpager.getCurrentItem()) {
                        case PAGE_ONE:
                            rb_pro1.setChecked(true);
                            rb_pro1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                            rb_pro2.setBackgroundResource(0);
                            break;
                        case PAGE_TWO:
                            rb_pro2.setChecked(true);
                            rb_pro2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                            rb_pro1.setBackgroundResource(0);
                            break;
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_menu:

                break;
        }
    }
}
