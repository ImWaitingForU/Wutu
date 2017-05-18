package com.soldiersoul.wutu.military;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.CityPolicyBean;
import com.soldiersoul.wutu.utils.BaseActivity;
import com.soldiersoul.wutu.utils.SpUtils;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
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

    private String sharedImgUrl;
    private String sharedTitle;

    private SpUtils spUtils;
    private static int newsNo;

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
    public boolean onCreateOptionsMenu (Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater ();
        //如果是政策福利和省市政策则不显示分享
        if (getIntent ().getBooleanExtra ("isShare", false)) {
            inflater.inflate (R.menu.share_menu, menu);
        }
        return super.onCreateOptionsMenu (menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId ()) {
            case R.id.action_share:
                doShare ();
                return true;
            default:
                return super.onOptionsItemSelected (item);
        }
    }

    /**
     * 社会化分享
     */
    private void doShare () {
        UMWeb web = new UMWeb ("http://www.81.cn/jmywyl/2017-05/16/content_7604286.htm");
        web.setTitle (sharedTitle);//标题
        web.setThumb (new UMImage (this, sharedImgUrl));  //缩略图
        web.setDescription ("--- 伍途");

        new ShareAction (this).withMedia (web).setDisplayList (SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                              .setCallback (null).open ();

        //        new ShareAction (this).withText ("aaaa").setDisplayList (SHARE_MEDIA.SINA, SHARE_MEDIA.QQ,
        // SHARE_MEDIA.WEIXIN)
        //                              .setCallback (null).open ();
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult (requestCode, resultCode, data);
        UMShareAPI.get (this).onActivityResult (requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy () {
        //退出时监听，保存浏览记录，下次进去直接加载上次退出的位置
//        SpUtils.putInteger (SpUtils.KEY_LAST_POSITION,newsNo);
        super.onDestroy ();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        ButterKnife.bind (this);

        loadingView.show ();
        spUtils = new SpUtils (this);

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
            sharedTitle = actTitle;
            loadData ();
        } else {
            layout.setVisibility (View.VISIBLE);
            loadingView.setVisibility (View.GONE);
            String title = bundle.getString ("newsTitle");
            String content = bundle.getString ("newsContent");
            String date = bundle.getString ("newsDate");
            String imgUrl = bundle.getString ("newsImg");
            newsNo = bundle.getInt ("newsNo");
            sharedImgUrl = imgUrl;
            sharedTitle = title;
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
