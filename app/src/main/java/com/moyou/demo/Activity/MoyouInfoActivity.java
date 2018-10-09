package com.moyou.demo.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

public class MoyouInfoActivity extends BaseActivity implements View.OnClickListener, View.OnKeyListener {
    ImageView iv_back;
    Context context;
    private FlyBanner mBannerLocal;//加载本地图片

    private FlyBanner mBannerNet;//加载网络图片

    private String[] mImagesUrl = {
            "http://img4.imgtn.bdimg.com/it/u=2430963138,1300578556&fm=23&gp=0.jpg",
            "http://img1.imgtn.bdimg.com/it/u=2755648979,3568014048&fm=23&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2272739960,4287902102&fm=23&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=1078051055,1310741362&fm=23&gp=0.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moyouinfo);
        context = MoyouInfoActivity.this;

        initLocalBanner();
//        initNetBanner();

        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
    }

    /**
     * 加载本地图片
     */
    private void initLocalBanner() {
        mBannerLocal = (FlyBanner) findViewById(R.id.banner_1);

        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.moyou_banner1);
        images.add(R.mipmap.moyou_banner2);
        images.add(R.mipmap.moyou_banner3);
        images.add(R.mipmap.moyou_banner4);
        mBannerLocal.setImages(images);
//        mBannerLocal.setPoinstPosition(FlyBanner.RIGHT);

        mBannerLocal.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                toast("点击了第"+position+"张图片");
            }
        });
    }

    /**
     * 加载网页图片
     */
    private void initNetBanner() {
        mBannerNet = (FlyBanner) findViewById(R.id.banner_1);

        List<String> imgesUrl = new ArrayList<>();
        for (int i = 0; i < mImagesUrl.length; i++) {
            imgesUrl.add(mImagesUrl[i]);
        }
        mBannerNet.setImagesUrl(imgesUrl);

        mBannerNet.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                toast("点击了第" + position + "张图片");
            }
        });
    }

    private void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }
}
