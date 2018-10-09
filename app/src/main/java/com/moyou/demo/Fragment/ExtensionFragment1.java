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

public class ExtensionFragment1 extends Fragment implements View.OnClickListener {
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
                R.layout.extension_content1, null);
        ll_member_i_promoted = (LinearLayout) view_main.findViewById(R.id.ll_member_i_promoted);
        ll_member_i_promoted.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_member_i_promoted:
                startActivity(new Intent(context, MemberIPromotedActivity.class));
                break;
            default:
                break;
        }
    }
}
