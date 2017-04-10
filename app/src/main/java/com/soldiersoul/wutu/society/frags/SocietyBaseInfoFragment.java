package com.soldiersoul.wutu.society.frags;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.LocationActivity;
import com.soldiersoul.wutu.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 社团基本信息界面
 */
public class SocietyBaseInfoFragment extends Fragment {

    @BindView (R.id.ivSocietyLogo) ImageView ivSocietyLogo;
    @BindView (R.id.tvSocietyName) TextView tvSocietyName;
    @BindView (R.id.tvSocietyIntroduction) TextView tvSocietyIntro;
    @BindView (R.id.tvChairmanName) TextView tvChairmanName;
    @BindView (R.id.tvSocietyPhone) TextView tvSocietyPhone;
    @BindView (R.id.tvSocietyLocation) TextView tvSocietyLocation;
    @BindView (R.id.tvSocietyMemberCount) TextView tvSocietyMemberCount;
    @BindView (R.id.tvLocation) TextView tvLocation;
    @BindView (R.id.lvSocietyMembers) ListView lvSocietyMembers;

    private RequestQueue requestQueue;
    private ToastUtil toastUtil;

    public SocietyBaseInfoFragment () {
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        requestQueue = Volley.newRequestQueue (getActivity ());
        toastUtil = new ToastUtil (getActivity ());
        return inflater.inflate (R.layout.fragment_society_baseinfo, container, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
        initData ();
    }

    /**
     * 跳转到定位界面
     */
    @OnClick (R.id.llLocate)
    void gotoLocation () {
        startActivity (new Intent (getActivity (), LocationActivity.class));
    }

    /**
     * 跳转到拨打社团电话界面
     */
    @OnClick (R.id.ivCall)
    void gotoCall () {
        Intent intent = new Intent (Intent.ACTION_DIAL, Uri.parse ("tel:" + tvSocietyPhone.getText ().toString ()));
        startActivity (intent);
    }

    /**
     * 获取数据
     */
    private void initData () {

        // TODO: 2017/4/10 社团成员列表
        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>> ();
//        lvSocietyMembers.setAdapter (
//                new SimpleAdapter (getActivity (), listems, android.R.layout.simple_list_item_1, new String[] {"item"},
//                                   new int[] {android.R.id.text1}));
    }
}
