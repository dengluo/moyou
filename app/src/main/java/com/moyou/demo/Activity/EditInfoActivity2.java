package com.moyou.demo.Activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.moyou.demo.R;
import com.moyou.demo.base.BaseActivity;
import com.moyou.demo.bean.JsonBean;
import com.moyou.demo.util.GetJsonDataUtil;
import com.moyou.demo.view.MyActionDialog;
import com.google.gson.Gson;
import com.swifty.dragsquareimage.DraggablePresenter;
import com.swifty.dragsquareimage.DraggablePresenterImpl;
import com.swifty.dragsquareimage.DraggableSquareView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditInfoActivity2 extends AppCompatActivity implements View.OnClickListener {
    private DraggablePresenter draggablePresent;

    private TextView mSex;
    private TextView mNick;
    private TextView mHeight;
    private TextView mWeight;
    private TextView mBirth;
    private TextView mArea;

    private List<LinearLayout> editBars;
    private int mYear;
    private int mMonth;
    private int mDay;
    private List<Integer> heightData;
    private List<Integer> weightData;
    private List<String> sexData;

    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo2);
//        getSupportActionBar().hide();
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},900);
        }

        DraggableSquareView dragSquare = (DraggableSquareView) findViewById(R.id.drag_square);
        draggablePresent = new DraggablePresenterImpl(this, dragSquare);
        draggablePresent.setCustomActionDialog(new MyActionDialog(this));

        editBars = new ArrayList<>();

        mSex = (TextView) findViewById(R.id.edit_sex);
        mNick = (TextView) findViewById(R.id.edit_nick);
        mHeight = (TextView) findViewById(R.id.edit_height);
        mWeight = (TextView) findViewById(R.id.edit_weight);
        mBirth = (TextView) findViewById(R.id.edit_birth);
        mArea = (TextView) findViewById(R.id.edit_area);
        findViewById(R.id.close).setOnClickListener(this);
        findViewById(R.id.buy_vip).setOnClickListener(this);
        findViewById(R.id.buy_vip_ic).setOnClickListener(this);

        LinearLayout ll;
        ll = (LinearLayout) findViewById(R.id.sex_bar);
        setListener(ll);
        ll = (LinearLayout) findViewById(R.id.name_bar);
        setListener(ll);
        ll = (LinearLayout) findViewById(R.id.height_bar);
        setListener(ll);
        ll = (LinearLayout) findViewById(R.id.weight_bar);
        setListener(ll);
        ll = (LinearLayout) findViewById(R.id.date_bar);
        setListener(ll);
        ll = (LinearLayout) findViewById(R.id.area_bar);
        setListener(ll);

        initJsonData();
    }

    private void setListener(LinearLayout ll) {
        ll.setOnClickListener(this);
        editBars.add(ll);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        draggablePresent.onActivityResult(requestCode, resultCode, result);
    }

    /**
     * 根据Uri获取图片文件的绝对路径
     */
    public String getAbsolutePath(final Uri uri) {
        if (null == uri) {
            return null;
        }

        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = getContentResolver().query(uri,
                    new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close:
                finish();
                break;
            case R.id.buy_vip:
            case R.id.buy_vip_ic:
//                Toast.makeText(this, "购买VIP页面跳转", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MemberCenterActivity.class));
                break;
            case R.id.sex_bar:
                highlight(editBars.get(0));
                choiceSex();
                break;
            case R.id.name_bar:
                highlight(editBars.get(1));
                edit(mNick);
                break;
            case R.id.height_bar:
                highlight(editBars.get(2));
                editHeight();
                break;
            case R.id.weight_bar:
                highlight(editBars.get(3));
                editWeight();
                break;
            case R.id.date_bar:
                highlight(editBars.get(4));
                choiceDate();
                break;
            case R.id.area_bar:
                highlight(editBars.get(5));
                choiceArea();
                break;
        }
    }

    private void choiceArea() {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx =options2Items.get(options1).get(options2) + " " + options3Items.get(options1).get(options2).get(options3);
                mArea.setText(tx);
            }
        })
                .setTitleText("城市选择")
                .setCancelColor(0xFFFF4081)
                .setSubmitColor(0xFFFF4081)
                .setTextColorCenter(0xFFFF4081)
                .build();
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void highlight(LinearLayout layout) {
        for (LinearLayout l:editBars) {
            l.setBackgroundColor(0xffffffff);
        }
        layout.setBackgroundColor(0xFFDFE1E1);
    }

    private void editWeight() {
        weightData = new ArrayList<>();
        for (int i = 5; i < 95; i++){
            weightData.add(i);
        }
        OptionsPickerView picker = new OptionsPickerBuilder(this,new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = weightData.get(options1) + "kg";
                mWeight.setText(tx);
            }
        })
                .setTitleText("请选择您的体重")
                .setCancelColor(0xFFFF4081)
                .setSubmitColor(0xFFFF4081)
                .setLabels("kg","","")
                .setTextColorCenter(0xFFFF4081)
                .setContentTextSize(30)
                .setSelectOptions(weightData.size()/2)
                .build();
        picker.setPicker(weightData);
        picker.show();
    }

    private void editHeight() {
        heightData = new ArrayList<>();
        for (int i = 50; i < 270; i++){
            heightData.add(i);
        }
        OptionsPickerView picker = new OptionsPickerBuilder(this,new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String tx = heightData.get(options1) + "cm";
                mHeight.setText(tx);
            }
        })
                .setTitleText("请选择您的身高")
                .setCancelColor(0xFFFF4081)
                .setSubmitColor(0xFFFF4081)
                .setContentTextSize(30)
                .setLabels("cm","","")
                .setTextColorCenter(0xFFFF4081)
                .setSelectOptions(heightData.size()/2)
                .build();
        picker.setPicker(heightData);
        picker.show();
    }

    private void choiceDate() {
        Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                String days;
                if (mMonth + 1 < 10) {
                    if (mDay < 10) {
                        days = String.valueOf(mYear) + "-" + "0" + (mMonth + 1) + "-" + "0" + mDay;
                    } else {
                        days = String.valueOf(mYear) + "-" + "0" + (mMonth + 1) + "-" + mDay;
                    }
                } else {
                    if (mDay < 10) {
                        days = String.valueOf(mYear) + "-" + (mMonth + 1) + "-" + "0" + mDay;
                    } else {
                        days = String.valueOf(mYear) + "-" + (mMonth + 1) + "-" + mDay;
                    }
                }
                mBirth.setText(days);
            }
        };
        new DatePickerDialog(this, onDateSetListener, mYear, mMonth, mDay).show();
    }

    private void edit(final TextView textView) {
        View view = LayoutInflater.from(this).inflate(R.layout.edit_dialog,null);
        final AlertDialog dialog = new AlertDialog.Builder(this).setView(view).setCancelable(false).show();
        final EditText editText = (EditText) view.findViewById(R.id.edit);
        editText.setText(textView.getText());
        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        view.findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                if (s.equals("") || s.equals("null"))
                    Toast.makeText(EditInfoActivity2.this, "昵称不能为空", Toast.LENGTH_SHORT).show();
                else {
                    dialog.cancel();
                    textView.setText(s);
                }
            }
        });
    }

    private void choiceSex() {
        sexData = new ArrayList<>();
        sexData.add("男");
        sexData.add("女");
        OptionsPickerView picker = new OptionsPickerBuilder(this,new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                mSex.setText(sexData.get(options1));
            }
        })
                .setTitleText("请选择您的性别")
                .setCancelColor(0xFFC62D7D)
                .setSubmitColor(0xFFC62D7D)
                .setContentTextSize(30)
                .setTextColorCenter(0xFFC62D7D)
                .build();
        picker.setPicker(sexData);
        picker.show();
    }

    private void initJsonData() { //解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this, "moyou_province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市
                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {
                    City_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }
            options2Items.add(CityList);
            options3Items.add(Province_AreaList);
        }
    }

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }
}
