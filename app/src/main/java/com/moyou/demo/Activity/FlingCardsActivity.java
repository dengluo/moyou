package com.moyou.demo.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.moyou.demo.Adapter.PairFragmentPagerAdapter;
import com.moyou.demo.base.BaseActivity;
import com.moyou.demo.flingswipe.SwipeFlingAdapterView;
import com.moyou.demo.swipecards.CardAdapter;
import com.moyou.demo.swipecards.CardMode;

import java.util.ArrayList;
import java.util.List;
import com.moyou.demo.R;

public class FlingCardsActivity extends BaseActivity implements View.OnClickListener{
    private ArrayList<CardMode> al;
    private CardAdapter adapter;
    private int i;
    private SwipeFlingAdapterView flingContainer;
    private List<List<String>> list = new ArrayList<>();
    private ImageView left, right,iv_title_heart;
    private ImageView iv_back;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fling_cards);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        left = (ImageView) findViewById(R.id.left);
        right = (ImageView) findViewById(R.id.right);
        rightSlidView = super.findViewById(R.id.right_sliding);
        mAdapter = new PairFragmentPagerAdapter(this.getSupportFragmentManager());
        rightSlidView.setOnClickListener(this);
        iv_title_heart = (ImageView) findViewById(R.id.iv_title_heart);
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
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//侧滑栏关闭手势滑动
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right();
            }
        });
        iv_title_heart.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_title_heart.setOnClickListener(this);

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


        al = new ArrayList<>();

        for (int i = 0; i < imageUrls.length; i++) {
            List<String> s = new ArrayList<>();
            s.add(imageUrls[i]);
            list.add(s);
        }
        List<String> yi;
        al.add(new CardMode("Fern", 21, list.get(0)));
        al.add(new CardMode("Alice", 21, list.get(1)));
        al.add(new CardMode("Bunny", 18, list.get(2)));
        al.add(new CardMode("Estelle", 21, list.get(3)));
        al.add(new CardMode("Jasmine", 21, list.get(4)));
        al.add(new CardMode("Iris", 21, list.get(5)));
        al.add(new CardMode("Emily", 21, list.get(6)));
        al.add(new CardMode("Betty", 21, list.get(7)));

        adapter = new CardAdapter(this, al);
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        flingContainer.setAdapter(adapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                al.remove(0);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onLeftCardExit(Object dataObject) {
                makeToast(FlingCardsActivity.this, "不喜欢");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(FlingCardsActivity.this, "喜欢");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                al.add(new CardMode("循环测试", 18, list.get(itemsInAdapter % imageUrls.length - 1)));
                adapter.notifyDataSetChanged();
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                try {
                    View view = flingContainer.getSelectedView();
                    view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                    view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
//                makeToast(FlingCardsActivity.this, "点击图片");
//                startActivity(new Intent(FlingCardsActivity.this, MakeFriendsSettingActivity.class));
            }
        });

    }

    static void makeToast(Context ctx, String s) {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }

    public void closeRightSliding() {
        rightSlidView.setVisibility(View.GONE);
    }


    public void right() {
        flingContainer.getTopCardListener().selectRight();
    }

    public void left() {
        flingContainer.getTopCardListener().selectLeft();
    }

    public final String[] imageUrls = new String[]{
            "http://img.my.csdn.net/uploads/201309/01/1378037235_3453.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037235_9280.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037234_3539.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037234_6318.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037194_2965.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037193_1687.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037193_1286.jpg"};

    public void openRightSliding() {
        if (drawerLayout.isDrawerOpen(Gravity.END)) {
            drawerLayout.closeDrawer(Gravity.END);
        } else {
            drawerLayout.openDrawer(Gravity.END);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_title_heart:
                openRightSliding();
                break;
        }
    }
}
