package com.soldiersoul.wutu.military;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.CityPolicyBean;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.squareup.picasso.Picasso;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * 展示各个省市地区的具体征兵政策,在新闻详情/政策详情/军事宣传详情界面通用
 */
public class CityContentActivity extends BaseActivity {

    @BindView (R.id.city_detail_img) ImageView city_detail_img;
    @BindView (R.id.city_detail_title) TextView city_detail_title;
    @BindView (R.id.city_detail_content) TextView city_detail_content;
    @BindView (R.id.city_detail_sourceandtime) TextView city_detail_sourceandtime;
    @BindView (R.id.layout) LinearLayout layout;
    @BindView (R.id.city_loading_view) AVLoadingIndicatorView loadingView;

    private CityPolicyBean cityPolicyBean;
    private String cityName;

    private Handler mHander = new Handler () {
        @Override
        public void handleMessage (Message msg) {
            if (msg.what == 0x133) {
                loadingView.setVisibility (View.GONE);
                layout.setVisibility (View.VISIBLE);
                inputData (cityPolicyBean.getTitle (), cityPolicyBean.getContent (),
                           "来源:" + cityPolicyBean.getResource () + " " + cityPolicyBean.getTime (), null);
            }
        }
    };

    private void inputData (String title, String content, String date, String imgUrl) {
        city_detail_title.setText (title);
        city_detail_content.setText (content);
        city_detail_sourceandtime.setText (date);
        if (imgUrl == null || imgUrl.equals ("")) {
            city_detail_img.setVisibility (View.GONE);
        } else {
            Picasso.with (this).load (imgUrl).into (city_detail_img);
        }
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        ButterKnife.bind (this);

        loadingView.show ();

        Intent intent = getIntent ();
        Bundle bundle = intent.getExtras ();
        String actTitle = bundle.getString ("actTitle");

        /*
        * 先判断是不是城市具体政策
        * 是城市就在当前页面根据actTitle加载数据。
        * 否则直接从getIntent显示
        * */
        setHomeButtonStaff (actTitle);
        if (intent.getBooleanExtra ("isCity", false)) {
            cityName = actTitle;
            loadData ();
        } else {
            layout.setVisibility (View.VISIBLE);
            loadingView.setVisibility (View.GONE);
            String title = bundle.getString ("newsTitle");
            String content = bundle.getString ("newsContent");
            String date = bundle.getString ("newsDate");
            String imgUrl = bundle.getString ("newsImg");

            inputData (title, content, date, imgUrl);
        }
    }

    /**
     * 加载数据,根据城市名称查找相应政策
     */
    private void loadData () {
        BmobQuery<CityPolicyBean> query = new BmobQuery<> ();
        query.addWhereEqualTo ("cityName", cityName);
        Log.d ("chan", "查询的cityName ====" + cityName);
        query.findObjects (new FindListener<CityPolicyBean> () {
            @Override
            public void done (List<CityPolicyBean> list, BmobException e) {
                if (e == null) {
                    cityPolicyBean = list.get (0);
                    mHander.sendMessage (mHander.obtainMessage (0x133));
                    Log.d ("Bmob", "City Policy: 查询成功");
                } else {
                    mToastUtil.toastShort ("加载数据失败~");
                    Log.d ("Bmob", "City Policy: 查询失败" + e.getMessage ());
                }
            }
        });
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_city_content;
    }
}
