package com.moyou.demo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.moyou.demo.Fragment.ExtensionFragment1;
import com.moyou.demo.Fragment.ExtensionFragment2;
import com.moyou.demo.Fragment.MemberIpromotedFragment1;
import com.moyou.demo.Fragment.MemberIpromotedFragment2;
import com.moyou.demo.Fragment.MemberIpromotedFragment3;
import com.moyou.demo.Activity.ExtensionCenterActivity;
import com.moyou.demo.Activity.MemberIPromotedActivity;

/**
 * Created by Danny on 2018/6/8
 */
public class MemberIpromotedPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 3;
    private MemberIpromotedFragment1 fragment1 = null;
    private MemberIpromotedFragment2 fragment2 = null;
    private MemberIpromotedFragment3 fragment3 = null;


    public MemberIpromotedPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new MemberIpromotedFragment1();
        fragment2 = new MemberIpromotedFragment2();
        fragment3 = new MemberIpromotedFragment3();
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
            case MemberIPromotedActivity.PAGE_ONE:
                fragment = fragment1;
                break;
            case MemberIPromotedActivity.PAGE_TWO:
                fragment = fragment2;
                break;
            case MemberIPromotedActivity.PAGE_THREE:
                fragment = fragment3;
                break;
        }
        return fragment;
    }


}

