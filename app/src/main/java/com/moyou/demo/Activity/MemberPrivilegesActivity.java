package com.moyou.demo.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;

/**
 * 会员特权弹窗
 * Created by Danny on 2018/7/4
 */

public class MemberPrivilegesActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_member_privileges);

        initView();
    }

    private void initView() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
