package com.moyou.demo.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.moyou.demo.R;
import com.moyou.demo.session.SessionHelper;
import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;

/**
 * Created by Administrator on 2018/6/8.
 */

public class PairFragment1 extends Fragment implements View.OnClickListener{
    private View view_main;
    private Context context;
    private RelativeLayout rl_paircontent1,rl_paircontent2,rl_paircontent3,rl_paircontent4;

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
                R.layout.pair_content1, null);
        rl_paircontent1 = (RelativeLayout)view_main.findViewById(R.id.rl_paircontent1);
        rl_paircontent1.setOnClickListener(this);
        rl_paircontent2 = (RelativeLayout)view_main.findViewById(R.id.rl_paircontent2);
        rl_paircontent2.setOnClickListener(this);
        rl_paircontent3 = (RelativeLayout)view_main.findViewById(R.id.rl_paircontent3);
        rl_paircontent3.setOnClickListener(this);
        rl_paircontent4 = (RelativeLayout)view_main.findViewById(R.id.rl_paircontent4);
        rl_paircontent4.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_paircontent1:
                NimUIKit.startChatting(context, "Fern", SessionTypeEnum.P2P, null,null);
//                SessionHelper.startP2PSession(getActivity(), "Fern");
                break;
            case R.id.rl_paircontent2:
                NimUIKit.startChatting(context, "Alice", SessionTypeEnum.P2P, null,null);
                break;
            case R.id.rl_paircontent3:
                NimUIKit.startChatting(context, "Bunny", SessionTypeEnum.P2P, null,null);
                break;
            case R.id.rl_paircontent4:
                NimUIKit.startChatting(context, "test", SessionTypeEnum.P2P, null,null);
                break;
            default:
                break;
        }
    }
}
