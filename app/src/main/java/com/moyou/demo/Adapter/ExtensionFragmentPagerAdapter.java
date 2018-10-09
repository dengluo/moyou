package com.moyou.demo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.moyou.demo.Activity.ExtensionCenterActivity;
import com.moyou.demo.Fragment.ExtensionFragment1;
import com.moyou.demo.Fragment.ExtensionFragment2;

/**
 * Created by Danny on 2018/6/8
 */
public class ExtensionFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 2;
    private ExtensionFragment1 fragment1 = null;
    private ExtensionFragment2 fragment2 = null;


    public ExtensionFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new ExtensionFragment1();
        fragment2 = new ExtensionFragment2();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case ExtensionCenterActivity.PAGE_ONE:
                fragment = fragment1;
                break;
            case ExtensionCenterActivity.PAGE_TWO:
                fragment = fragment2;
                break;
        }
        return fragment;
    }


}

