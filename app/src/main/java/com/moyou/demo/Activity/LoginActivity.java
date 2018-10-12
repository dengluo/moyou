package com.moyou.demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.moyou.demo.R;
import com.moyou.demo.clazz.DemoCache;
import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nimlib.sdk.AbortableFuture;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.LoginInfo;

//@Route(path = "/Login/LoginActivity")
public class LoginActivity extends AppCompatActivity implements View.OnClickListener , View.OnKeyListener{

    private EditText zh;
    private EditText mm;
    private ImageView but;
    private AbortableFuture<LoginInfo> loginRequest;
//    private static final String LOGINACTIVITY = "/Login/LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
//        ARouter.getInstance().build(LOGINACTIVITY).navigation();
    }

    private void initView() {
        zh = (EditText) findViewById(R.id.zh);
        mm = (EditText) findViewById(R.id.mm);
        but = (ImageView) findViewById(R.id.but);

        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String account = zh.getText().toString().toLowerCase();
        final String token = mm.getText().toString();
       if (v.getId()==R.id.but){
           loginRequest = NimUIKit.login(new LoginInfo(account, token), new RequestCallback<LoginInfo>() {
               @Override
               public void onSuccess(LoginInfo loginInfo) {
                   DemoCache.setAccount(account);
                   Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
//                   startActivity(new Intent(LoginActivity.this, MessageActivity.class));
                   startActivity(new Intent(LoginActivity.this, FlingCardsActivity2.class));
                   finish();
               }

               @Override
               public void onFailed(int i) {
                   Toast.makeText(LoginActivity.this, "登陆失败" + i, Toast.LENGTH_SHORT).show();
               }

               @Override
               public void onException(Throwable throwable) {
                   Toast.makeText(LoginActivity.this, "登陆错误", Toast.LENGTH_SHORT).show();
               }
           });
       }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }


}
