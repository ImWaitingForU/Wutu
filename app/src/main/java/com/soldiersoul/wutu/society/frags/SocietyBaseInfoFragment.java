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

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.society.bean.SocietyBean;
import com.soldiersoul.wutu.utils.ToastUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

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
    //	@BindView(R.id.tvLocation)
    //	TextView tvLocation;
    @BindView (R.id.lvSocietyMembers) ListView lvSocietyMembers;
    @BindView (R.id.tvSocietyQQ) TextView tvSocietyQQ;

    private SocietyBean society;
    private ToastUtil toastUtil;

    public SocietyBaseInfoFragment () {
    }

    public SocietyBaseInfoFragment (SocietyBean society) {
        this.society = society;
    }

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        society = BmobUser.getCurrentUser (UserBean.class).getSociety ();
        toastUtil = new ToastUtil (getActivity ());
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate (R.layout.fragment_society_baseinfo, container, false);
        return v;
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);

        if (society == null) {
            return;
        }

        initMemberData ();

        tvSocietyName.setText (society.getName ());
        tvSocietyIntro.setText (society.getIntroduce ());
        Picasso.with (getActivity ()).load (society.getAvatar ()).into (ivSocietyLogo);
        tvChairmanName.setText (society.getCaptailName ());
        tvSocietyLocation.setText (society.getLocation ());
        tvSocietyPhone.setText (society.getSocietyPhone ());
        tvSocietyQQ.setText (society.getSocietyQQ ());
    }

    /**
     * 跳转到定位界面
     */
    //	@OnClick(R.id.llLocate)
    //	void gotoLocation() {
    //		startActivity(new Intent(getActivity(), LocationActivity.class));
    //	}

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
    private void initMemberData () {
        BmobQuery<UserBean> query = new BmobQuery<> ();
        SocietyBean societyBean = new SocietyBean ();
        UserBean user = BmobUser.getCurrentUser (UserBean.class);
        societyBean.setObjectId (user.getSociety ().getObjectId ());
        query.addWhereEqualTo ("society", new BmobPointer (societyBean));
        query.findObjects (new FindListener<UserBean> () {
            @Override
            public void done (List<UserBean> list, BmobException e) {
                if (e == null) {
                    lvSocietyMembers.setAdapter (new SocietyBaseInfoListAdapter (getContext (), list));
                } else {
                    toastUtil.toastShort ("查询失败");
                }
            }
        });
    }
}