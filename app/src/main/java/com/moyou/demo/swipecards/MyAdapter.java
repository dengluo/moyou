package com.moyou.demo.swipecards;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.moyou.demo.R;
import com.moyou.demo.Activity.MoyouInfoActivity;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 作者：宋鑫  2017/1/29 09:57
 * 邮箱：songxinnianshao@yeah.com
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<SwoprBean> list;
    private Context cxt;

    public MyAdapter(List<SwoprBean> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        cxt = parent.getContext();
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        SwoprBean bean = list.get(position);
        holder.index.setText(bean.getIndex() + "/" + list.size());
        holder.meimv.setText(bean.getName());
        Glide.with(cxt).load(bean.getPath()).into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), MoyouInfoActivity.class));
            }
        });
        holder.xihuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(cxt,"喜欢"+(position+1)+"号佳丽",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView meimv, index;
        private Button xihuan;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.myimg);
            meimv = (TextView) itemView.findViewById(R.id.meinv);
            index = (TextView) itemView.findViewById(R.id.index);
            xihuan = (Button) itemView.findViewById(R.id.xihuan);
        }
    }
}
