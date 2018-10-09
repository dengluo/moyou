package com.moyou.demo.swipecards;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.moyou.demo.Activity.FlingCardsActivity;
import com.moyou.demo.Activity.FriendsChatActivity;
import com.moyou.demo.Activity.MakeFriendsSettingActivity;

import java.util.List;

/**
 * 作者：宋鑫  2017/1/29 19:38
 * 邮箱：songxinnianshao@yeah.com
 */

public class RecyclerCallback extends ItemTouchHelper.SimpleCallback {

    private List<SwoprBean> dates;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView mRv;

    public RecyclerCallback(RecyclerView rv, RecyclerView.Adapter adapter, List dates) {
        //方向:四个方向分别代表什么意思：Move \ Swiped
        this(0, ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.mRv = rv;
        this.mAdapter = adapter;
        this.dates = dates;
    }

    public RecyclerCallback(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }


    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //滑动完毕----direction:1为UP 2为down  4为left  8为right
        SwoprBean remove = dates.remove(viewHolder.getLayoutPosition());
//        Log.d("aaaaa", "onSwiped: "+);
        switch (direction) {
            case ItemTouchHelper.DOWN:
//                ToastUtils.showToast(mRv.getContext(),"方向：下，滑掉的第"+remove.getIndex()+"个美女");
                ToastUtils.showToast(mRv.getContext(),"不喜欢");
                break;
            case ItemTouchHelper.UP:
                ToastUtils.showToast(mRv.getContext(),"喜欢");
                break;
//            case ItemTouchHelper.LEFT:
////                ToastUtils.showToast(mRv.getContext(),"方向：左，滑掉的第"+remove.getIndex()+"个美女");
//                mRv.getContext().startActivity(new Intent(mRv.getContext(), FriendsChatActivity.class));
//                break;
//            case ItemTouchHelper.RIGHT:
////                ToastUtils.showToast(mRv.getContext(),"方向：右，滑掉的第"+remove.getIndex()+"个美女");
//                mRv.getContext().startActivity(new Intent(mRv.getContext(), MakeFriendsSettingActivity.class));
//                break;
        }
        dates.add(0, remove);
        mAdapter.notifyDataSetChanged();

    }

    public float getThreashold() {
        return mRv.getWidth() * 0.5f;
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        //零界点----跟滑动的比例系数有关系--百分比
        double distance = Math.sqrt(dX * dX + dY * dY);//移动的距离
        double fraction = distance / getThreashold();
        if (fraction > 1) {
            fraction = 1;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = recyclerView.getChildAt(i);
            int level = childCount - i - 1;
            if (level > 0) {
                child.setScaleX((float) (1 - CardConfig.SCALR_GAP * level + fraction * CardConfig.SCALR_GAP));
                if (level < CardConfig.MAX_SHOW_COUNT - 1) {
                    //顶层的3个图层
                    child.setTranslationY((float) (CardConfig.TRANS_Y_GAP * level - fraction * CardConfig.TRANS_Y_GAP));
                    child.setScaleY((float) (1 - CardConfig.SCALR_GAP * level + fraction * CardConfig.SCALR_GAP));
                } else {
                    //下面的图层-- 完全层叠
//                    child.setTranslationY(CardConfig.TRANS_Y_GAP*(level -1));
//                    child.setScaleY(1-CardConfig.SCALR_GAP*(level-1));
                }
            }
        }
    }
}
