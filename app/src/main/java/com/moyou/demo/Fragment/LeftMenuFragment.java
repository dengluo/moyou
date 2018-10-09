package com.moyou.demo.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.moyou.demo.R;
import com.moyou.demo.Activity.EditInfoActivity;


/**
 * Created by Danny on 17/1/5.
 */

public class LeftMenuFragment extends Fragment implements View.OnClickListener{
    private RelativeLayout person_layout;
    Context context;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.main_menu,null);
        context =getContext();
        person_layout = (RelativeLayout)view.findViewById(R.id.person_layout);
        person_layout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.person_layout:
                startActivity(new Intent(context, EditInfoActivity.class));
                break;
        }
    }
}
