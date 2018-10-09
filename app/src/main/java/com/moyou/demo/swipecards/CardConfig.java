package com.moyou.demo.swipecards;

import android.content.Context;
import android.util.TypedValue;

/**
 * 工具类
 * 作者：宋鑫  2017/1/29 11:18
 * 邮箱：songxinnianshao@yeah.com
 */

public class CardConfig {
    //屏幕上最多显示几个item
    public static  int MAX_SHOW_COUNT;
    //每一集Scale相差0.05f，translation相差7dp左右
    public static float SCALR_GAP;
    public static int TRANS_Y_GAP;
    public static void initConfig(Context cxt){
        MAX_SHOW_COUNT = 4;
        SCALR_GAP = 0.05F;
        TRANS_Y_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,15,cxt.getResources().getDisplayMetrics());
    }
}