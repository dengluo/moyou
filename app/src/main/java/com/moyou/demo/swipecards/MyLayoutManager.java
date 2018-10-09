package com.moyou.demo.swipecards;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * 自定义布局管理器
 * 作者：宋鑫  2017/1/29 11:04
 * 邮箱：songxinnianshao@yeah.com
 * childView 的宽高、摆放
 * measureChildren()/layoutchildren
 */

public class MyLayoutManager extends RecyclerView.LayoutManager {
    /**
     * 生成LayoutParams
     * 这个方法不用操心   它是一个抽象方法
     * 因为我们要自定义布局所以直接返回RecyclerView的LayoutParams就可以了
     */
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    /**
     * 摆放子控件的方法
     */
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        //摆放里面的子控件
        /**
         * Recycler 的核心源码：Recyler类  RecyclerViewPool
         * ViewHolder的重用、缓冲--Scrap（废弃）、detach（解除绑定）、attach（绑定）
         */
        //1.在布局之前，讲所有的子View先detach掉，放入到Scrap缓存中
        detachAndScrapAttachedViews(recycler);
        //得到条目的数量
        int itemcount = getItemCount();
        if (itemcount < 1) {
            return;
        }
        //找到最后一个不需要完全重叠的item的位置：这个地方我需要好好的解释一下
        // 现在RecyclerView的条目是10个，但是第十个的下标为9。RecyclerView的条目顺序是这样的，最底层的下标为0，最顶层的下标为9 所以我们如果我们要找最后一个不重叠的也就是说从上面往下数
        //的第三个，   这个第三个从下往上数的下标是7     但是呢我们现在的小标为6 为什么呢  因为下标为9的不需要操作啊   所以我们就把6完全重叠     7和8进行缩放，9不缩放   还不明白的话
        // 请继续阅读代码
        int bottomPosition;
        if (itemcount < CardConfig.MAX_SHOW_COUNT) {
            bottomPosition = 0;
        } else {
            bottomPosition = itemcount - CardConfig.MAX_SHOW_COUNT;
        }
        for (int position = bottomPosition; position < itemcount; position++) {

            //从缓存池里面取出一个item
            View view = recycler.getViewForPosition(position);
            //将View加入到RecyclerView中
            addView(view);
            measureChildWithMargins(view, 0, 0);
            //空白区域   因为每一个条目的外面会有一个装饰，所以我们需要把装饰的距离计算出来并减掉
            int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);//屏幕的宽度减去使用的宽度就是横向所有空白区的宽度
            int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);//屏幕的高度减去使用的高度就是纵向所有空白区的高度
            layoutDecorated(view, widthSpace / 2,//左
                    heightSpace / 2,//上
                    widthSpace / 2 + getDecoratedMeasuredWidth(view),//右
                    heightSpace / 2 + getDecoratedMeasuredHeight(view));//下
            //找到最上面的3个图层     层叠效果
            /**
             * 这里是从最下面往上数的但是呢 我们有需要只让两个进行缩放  itemcount是8  比如当前是0就进不去第二个if
             *
             */
            int level = itemcount - position - 1;
            if (level > 0) {
                view.setScaleX(1-CardConfig.SCALR_GAP*level);
                if (level <CardConfig.MAX_SHOW_COUNT-1) {
                    //第二个和第三个图层 需要缩放
                    view.setTranslationY(CardConfig.TRANS_Y_GAP*level);
                    view.setScaleY(1-CardConfig.SCALR_GAP*level);
                }else{
                    //这里是从顶层往下面数第四个  就需要完全重叠了
                    Log.d("bbbb", "level:"+level);
                    view.setTranslationY(CardConfig.TRANS_Y_GAP*(level -1));
                    view.setScaleY(1-CardConfig.SCALR_GAP*(level-1));
                }
            }
        }

    }
}
