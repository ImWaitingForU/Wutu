package com.soldiersoul.wutu.military;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class CityContentActivity extends BaseActivity {

    @BindView (R.id.city_detail_img) ImageView city_detail_img;
    @BindView (R.id.city_detail_title) TextView city_detail_title;
    @BindView (R.id.city_detail_content) TextView city_detail_content;
    @BindView (R.id.city_detail_sourceandtime) TextView city_detail_sourceandtime;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        ButterKnife.bind (this);

        //TODO:插入数据
        Intent intent = getIntent ();
        Bundle bundle = intent.getExtras ();
        String actTitle = bundle.getString ("actTitle");
        setHomeButtonStaff (actTitle);
        String title = bundle.getString ("newsTitle");
        String content = bundle.getString ("newsContent");
        String date = bundle.getString ("newsDate");
        String imgUrl = bundle.getString ("newsImg");


        city_detail_title.setText (title);
        city_detail_content.setText (content);
        city_detail_sourceandtime.setText (date);
        if (imgUrl == null || imgUrl.equals ("")) {
            city_detail_img.setVisibility (View.GONE);
        }else{
            Picasso.with (this).load (imgUrl).into (city_detail_img);
        }
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_city_content;
    }
}
