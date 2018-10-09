package com.moyou.demo;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 未来属于自己
 * 作者：MLG
 * QQ:2264280742
 * 2018-4-27 9:29
 */


public class MainApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
