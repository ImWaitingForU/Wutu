package com.soldiersoul.wutu.military;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        ButterKnife.bind(this);

        //TODO:插入数据
        Intent intent = getIntent();
        Bundle bundle=intent.getExtras();
        String title = bundle.getString("newsTitle");
        String content = bundle.getString("newsContent");
        String date = bundle.getString("newsDate");

        city_detail_title.setText(title);
        city_detail_content.setText(content);
        city_detail_sourceandtime.setText(date);
    }
}
