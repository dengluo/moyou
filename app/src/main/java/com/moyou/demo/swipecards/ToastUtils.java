package com.moyou.demo.swipecards;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * 作者：宋鑫  2017/1/29 19:38
 * 邮箱：songxinnianshao@yeah.com
 */
public class ToastUtils {

    public static Toast mToast;

    public static void ToastSuccess(Context context, String content) {
        if (mToast == null) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        }

        mToast.makeText(context, content, Toast.LENGTH_LONG);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) mToast.getView();
        ImageView imageCodeProject = new ImageView(context);
        //imageCodeProject.setImageResource(R.drawable.success);
        toastView.addView(imageCodeProject, 0);
        mToast.show();
    }

    public static void ToastFailed(Context context, String content) {
        if (mToast == null) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        }
        mToast.makeText(context, content, Toast.LENGTH_LONG);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) mToast.getView();
        ImageView imageCodeProject = new ImageView(context);
        //imageCodeProject.setImageResource(R.drawable.fialed);
        toastView.addView(imageCodeProject, 0);
        mToast.show();
    }

    public static void ToastNormal(Context context, String content, int Res) {
        Toast toast = Toast.makeText(context, content, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastView = (LinearLayout) toast.getView();
        ImageView imageCodeProject = new ImageView(context);
        imageCodeProject.setImageResource(Res);
        toastView.addView(imageCodeProject, 0);
        toast.show();
    }


    /**
     * 显示吐司
     * @param message
     */
    public static void showToast(final Context context, final String message) {
        if (mToast == null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    /**
     * 显示吐司
     * @param context
     * @param messageResId
     */
    public static void showToast(final Context context, final int messageResId) {
        if (mToast == null) {
            mToast = Toast.makeText(context, messageResId, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(messageResId);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }


}
