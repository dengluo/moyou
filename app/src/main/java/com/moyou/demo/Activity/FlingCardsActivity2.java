package com.moyou.demo.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.moyou.demo.R;
import com.moyou.demo.Adapter.PairFragmentPagerAdapter;
import com.moyou.demo.base.BaseActivity;
import com.moyou.demo.flingswipe.SwipeFlingAdapterView;
import com.moyou.demo.swipecards.CardAdapter;
import com.moyou.demo.swipecards.CardConfig;
import com.moyou.demo.swipecards.CardMode;
import com.moyou.demo.swipecards.MyAdapter;
import com.moyou.demo.swipecards.MyLayoutManager;
import com.moyou.demo.swipecards.RecyclerCallback;
import com.moyou.demo.swipecards.SwoprBean;

import java.util.ArrayList;
import java.util.List;

public class FlingCardsActivity2 extends BaseActivity implements View.OnClickListener{

    private ImageView iv_back,iv_title_heart,iv_index_person;
    private DrawerLayout drawerLayout;
    View rightSlidView;
    ViewPager vpager;
    RadioGroup rg_tab_pair_bar;
    RadioButton rb_pair1, rb_pair2, rb_pair3;
    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    private PairFragmentPagerAdapter mAdapter;


    private RecyclerView rv;
    private int[] imgs = {
            R.mipmap.swipecard1,
            R.mipmap.swipecard2,
            R.mipmap.swipecard3,
            R.mipmap.swipecard4,
            R.mipmap.swipecard5,
            R.mipmap.swipecard6,
            R.mipmap.swipecard7,
            R.mipmap.swipecard8,
            R.mipmap.swipecard9,
            R.mipmap.swipecard10,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fling_cards2);
        mAdapter = new PairFragmentPagerAdapter(this.getSupportFragmentManager());
        rv = (RecyclerView) findViewById(R.id.rv);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_index_person = (ImageView) findViewById(R.id.iv_index_person);
        iv_title_heart = (ImageView) findViewById(R.id.iv_title_heart);
        iv_title_heart.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_index_person.setOnClickListener(this);
        rg_tab_pair_bar = (RadioGroup) findViewById(R.id.rg_tab_pair_bar);
        rb_pair1 = (RadioButton) findViewById(R.id.rb_pair1);
        rb_pair2 = (RadioButton) findViewById(R.id.rb_pair2);
        rb_pair3 = (RadioButton) findViewById(R.id.rb_pair3);

        rb_pair3.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
        rb_pair2.setBackgroundResource(0);
        rb_pair1.setBackgroundResource(0);
        rb_pair2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
        rb_pair3.setBackgroundResource(0);
        rb_pair1.setBackgroundResource(0);
        rb_pair1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
        rb_pair2.setBackgroundResource(0);
        rb_pair3.setBackgroundResource(0);
        vpager = (ViewPager) findViewById(R.id.pairPager);
        drawerLayout = (DrawerLayout) super.findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
//        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//侧滑栏关闭手势滑动

        rb_pair1.setChecked(true);
        rg_tab_pair_bar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_pair1:
                        vpager.setCurrentItem(PAGE_ONE);
                        rb_pair1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_pair2.setBackgroundResource(0);
                        rb_pair3.setBackgroundResource(0);
                        break;
                    case R.id.rb_pair2:
                        vpager.setCurrentItem(PAGE_TWO);
                        rb_pair2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_pair1.setBackgroundResource(0);
                        rb_pair3.setBackgroundResource(0);
                        break;
                    case R.id.rb_pair3:
                        vpager.setCurrentItem(PAGE_THREE);
                        rb_pair3.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                        rb_pair1.setBackgroundResource(0);
                        rb_pair2.setBackgroundResource(0);
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
                            rb_pair1.setChecked(true);
                            rb_pair1.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                            rb_pair2.setBackgroundResource(0);
                            rb_pair3.setBackgroundResource(0);
                            break;
                        case PAGE_TWO:
                            rb_pair2.setChecked(true);
                            rb_pair2.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                            rb_pair3.setBackgroundResource(0);
                            rb_pair1.setBackgroundResource(0);
                            break;
                        case PAGE_THREE:
                            rb_pair3.setChecked(true);
                            rb_pair3.setBackgroundResource(R.drawable.base_tabpager_indicator_selected);
                            rb_pair2.setBackgroundResource(0);
                            rb_pair1.setBackgroundResource(0);
                            break;
                    }
                }
            }
        });
        rv.setLayoutManager(new MyLayoutManager());
        List<SwoprBean> list = new ArrayList<>();

        for (int i = 0; i < imgs.length; i++) {
            SwoprBean bean = new SwoprBean();
            bean.setPath(imgs[i]);
            bean.setName("美女"+(i+1));
            bean.setIndex(i+1);
            list.add(bean);
        }
        MyAdapter adapter = new MyAdapter(list);
        rv.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new RecyclerCallback(rv,adapter,list);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(rv);
        CardConfig.initConfig(this);
    }
    public void openRightSliding() {
        if (drawerLayout.isDrawerOpen(Gravity.END)) {
            drawerLayout.closeDrawer(Gravity.END);
        } else {
            drawerLayout.openDrawer(Gravity.END);
        }
    }

    public void gotoMemberCenter(View view) {
        startActivity(new Intent(this, MemberCenterActivity.class));
    }

    public void gotoCodeUnlock(View view) {
        startActivity(new Intent(this, CodeUnlockActivity.class));
    }

    public void gotoEditInfo(View view) {
        startActivity(new Intent(this, EditInfoActivity2.class));
    }

    public void gotoExtensionCentre(View view) {
        startActivity(new Intent(this, ExtensionCenterActivity.class));
    }

    public void gotoWallet(View view) {
        startActivity(new Intent(this, WalletActivity.class));
    }

    public void gotoNavigation(View view) {
//        startActivity(new Intent(this, NavigationActivity.class));
        startActivity(new Intent(this, WalletActivity.class));
    }

    public void openLeftSliding() {
//        leftSlidView.setVisibility(View.VISIBLE);
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            drawerLayout.openDrawer(Gravity.START);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_index_person:
                openLeftSliding();
                break;
            case R.id.iv_title_heart:
                openRightSliding();
                break;
        }

    }
}
