package com.moyou.demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;

/**
 * 默友配对
 * Created by shun8 on 2018/6/27.
 */

public class MoyouPairActivity extends BaseActivity implements View.OnClickListener {
    ImageView iv_back;
    LinearLayout ll_moyou_pair;
    private float downX;    //按下时 的X坐标
    private float downY;    //按下时 的Y坐标

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moyou_pair);

        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        ll_moyou_pair = (LinearLayout) findViewById(R.id.ll_moyou_pair);
        iv_back.setOnClickListener(this);
    }

    /**
     * 触屏事件
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String action = "";
        //在触发时回去到起始坐标
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                //将按下时的坐标存储
                downX = x;
                downY = y;
//                Log.e("Tag", "=======按下时X：" + x);
//                Log.e("Tag", "=======按下时Y：" + y);
                break;
            case MotionEvent.ACTION_UP:
//                Log.e("Tag", "=======抬起时X：" + x);
//                Log.e("Tag", "=======抬起时Y：" + y);

                //获取到距离差
                float dx = x - downX;
                float dy = y - downY;
                //防止是按下也判断
//                Log.e("Tag", "========X轴距离差：" + dx);
//                Log.e("Tag", "========Y轴距离差：" + dy);
                if (Math.abs(dx) > 30 || Math.abs(dy) > 30) {
                    //通过距离差判断方向
                    int orientation = getOrientation(dx, dy);
                    switch (orientation) {
                        case 'r':
                            action = "右";
                            startActivity(new Intent(this, MakeFriendsSettingActivity.class));
                            overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
                            break;
                        case 'l':
                            action = "左";
                            startActivity(new Intent(this, FriendsChatActivity.class));
                            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                            break;
                        case 't':
                            action = "上";
                            break;
                        case 'b':
                            action = "下";
                            break;
                    }
                    Toast.makeText(MoyouPairActivity.this, "向" + action + "滑动", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 根据距离差判断 滑动方向
     *
     * @param dx X轴的距离差
     * @param dy Y轴的距离差
     * @return 滑动的方向
     */
    private int getOrientation(float dx, float dy) {

        if (Math.abs(dx) > Math.abs(dy)) {
            //X轴移动
            return dx > 0 ? 'r' : 'l';
        } else {
            //Y轴移动
            return dy > 0 ? 'b' : 't';
        }
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
