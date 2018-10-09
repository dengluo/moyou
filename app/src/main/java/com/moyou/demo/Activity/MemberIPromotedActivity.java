package com.moyou.demo.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.moyou.demo.R;
import com.moyou.demo.Adapter.ExtensionFragmentPagerAdapter;
import com.moyou.demo.Adapter.MemberIpromotedPagerAdapter;
import com.moyou.demo.base.BaseActivity;

/**
 * 我推广的会员
 * Created by Danny on 2018/7/4.
 */

public class MemberIPromotedActivity extends BaseActivity implements View.OnClickListener{
    ImageView iv_back;
    RadioGroup rg_tab_promote_bar;
    RadioButton rb_promote_pair1, rb_promote_pair2, rb_promote_pair3;
    ViewPager promotePager;
    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    private Context context;
    private MemberIpromotedPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_promoted);

        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        promotePager = (ViewPager) findViewById(R.id.promotePager);
        rg_tab_promote_bar = (RadioGroup) findViewById(R.id.rg_tab_promote_bar);
        rb_promote_pair1 = (RadioButton) findViewById(R.id.rb_promote_pair1);
        rb_promote_pair2 = (RadioButton) findViewById(R.id.rb_promote_pair2);
        rb_promote_pair3 = (RadioButton) findViewById(R.id.rb_promote_pair3);

        rb_promote_pair1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
        rb_promote_pair2.setBackgroundResource(0);
        rb_promote_pair3.setBackgroundResource(0);
//        rb_promote_pair2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
//        rb_promote_pair1.setBackgroundResource(0);
//        rb_promote_pair3.setBackgroundResource(0);
//        rb_promote_pair3.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
//        rb_promote_pair2.setBackgroundResource(0);
//        rb_promote_pair1.setBackgroundResource(0);
        mAdapter = new MemberIpromotedPagerAdapter(this.getSupportFragmentManager());
        iv_back.setOnClickListener(this);

        rg_tab_promote_bar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_promote_pair1:
                        promotePager.setCurrentItem(PAGE_ONE);
                        rb_promote_pair1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_promote_pair2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_promote_pair3.setBackgroundResource(0);
                        break;
                    case R.id.rb_promote_pair2:
                        promotePager.setCurrentItem(PAGE_TWO);
                        rb_promote_pair1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_promote_pair3.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_promote_pair2.setBackgroundResource(0);
                        break;
                    case R.id.rb_promote_pair3:
                        promotePager.setCurrentItem(PAGE_THREE);
                        rb_promote_pair3.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_promote_pair2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_promote_pair1.setBackgroundResource(0);
                        break;
                }
            }
        });

        promotePager.setAdapter(mAdapter);
        promotePager.setCurrentItem(0);
        promotePager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                    switch (promotePager.getCurrentItem()) {
                        case PAGE_ONE:
                            rb_promote_pair1.setChecked(true);
                            rb_promote_pair1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                            rb_promote_pair2.setBackgroundResource(0);
                            rb_promote_pair3.setBackgroundResource(0);
                            break;
                        case PAGE_TWO:
                            rb_promote_pair2.setChecked(true);
                            rb_promote_pair2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                            rb_promote_pair1.setBackgroundResource(0);
                            rb_promote_pair3.setBackgroundResource(0);
                            break;
                        case PAGE_THREE:
                            rb_promote_pair3.setChecked(true);
                            rb_promote_pair3.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                            rb_promote_pair2.setBackgroundResource(0);
                            rb_promote_pair1.setBackgroundResource(0);
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
        }
    }
}
