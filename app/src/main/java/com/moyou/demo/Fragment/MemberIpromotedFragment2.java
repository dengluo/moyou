package com.moyou.demo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.moyou.demo.R;
import com.moyou.demo.Activity.MemberIPromotedActivity;

/**
 * Created by Administrator on 2018/6/8.
 */

public class MemberIpromotedFragment2 extends Fragment implements View.OnClickListener {
    private View view_main;
    private Context context;
    private LinearLayout ll_member_i_promoted;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        context = this.getActivity();
        initView();
        return view_main;
    }

    private void initView() {
        view_main = LayoutInflater.from(getActivity()).inflate(
                R.layout.memberipromoted_content2, null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
        }
    }
}
