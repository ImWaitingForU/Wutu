package com.soldiersoul.wutu.military;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

import butterknife.BindView;

public class CityContentActivity extends AppCompatActivity {

    @BindView(R.id.city_detail_img)
    ImageView city_detail_img;
    @BindView(R.id.city_detail_title)
    TextView city_detail_title;
    @BindView(R.id.city_detail_content)
    TextView city_detail_content;
    @BindView(R.id.city_detail_sourceandtime)
    TextView city_detail_sourceandtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_content);

        //TODO:插入数据
    }
}
