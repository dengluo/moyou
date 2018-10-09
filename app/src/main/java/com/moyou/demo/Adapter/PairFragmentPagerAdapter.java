package com.moyou.demo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.moyou.demo.Fragment.PairFragment1;
import com.moyou.demo.Fragment.PairFragment2;
import com.moyou.demo.Fragment.PairFragment3;
import com.moyou.demo.MainActivity2;

/**
 * Created by Danny on 2018/6/8
 */
public class PairFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 3;
    private PairFragment1 fragment1 = null;
    private PairFragment2 fragment2 = null;
    private PairFragment3 fragment3 = null;


    public PairFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment1 = new PairFragment1();
        fragment2 = new PairFragment2();
        fragment3 = new PairFragment3();
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
            case MainActivity2.PAGE_ONE:
                fragment = fragment1;
                break;
            case MainActivity2.PAGE_TWO:
                fragment = fragment2;
                break;
            case MainActivity2.PAGE_THREE:
                fragment = fragment3;
                break;
        }
        return fragment;
    }


}

