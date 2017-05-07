package com.soldiersoul.wutu.society.frags;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.society.SocietyIntegralDetailAct;
import com.soldiersoul.wutu.society.bean.SocietyIntegral;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * 社团任务界面
 */
public class SocietyIntegralFragment extends Fragment {

    @BindView (R.id.rvSocietyIntegral) RecyclerView rvSocietyIntegral;
    private List<SocietyIntegral> dataList;
    private SocietyIntegralAdapter adapter;

    public SocietyIntegralFragment () {
    }

    /**
     * 社团照片封面Adapter
     */
    public class SocietyIntegralAdapter extends BaseQuickAdapter<SocietyIntegral> {

        public SocietyIntegralAdapter () {
            //这里设置数据
            //            super (R.layout.society_integral_item, DataUtils.getSocietyIntegralInfo (getContext ()));
            super (R.layout.society_integral_item, dataList);
        }

        @Override
        protected void convert (BaseViewHolder baseViewHolder, final SocietyIntegral societyIntegral) {
            baseViewHolder.setText (R.id.tv_integralname, societyIntegral.getIntegralName ())
                          //                          .setText (R.id.tv_integralcontent, societyIntegral
                          // .getIntegralContent ())
                          .setText (R.id.tv_integralreward, "奖励 : " + societyIntegral.getIntegralReward ())
                          .setText (R.id.tv_deadline, "截至 ：" + societyIntegral.getDeadline ());

            baseViewHolder.getView (R.id.cvIntegral).setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View v) {
                    //跳转到任务详情界面
                    Intent intent = new Intent (getActivity (), SocietyIntegralDetailAct.class);
                    intent.putExtra ("SocietyIntegral",societyIntegral);
                    startActivity (intent);
                }
            });
        }
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 初始化数据
        if (dataList == null) {
            dataList = new ArrayList<> ();
            BmobQuery<SocietyIntegral> query = new BmobQuery<> ();
            Log.d ("Bmob", "社团ID:" + BmobUser.getCurrentUser (UserBean.class).getSociety ().getObjectId ().trim ());
            query.addWhereEqualTo ("societyBean",
                                   BmobUser.getCurrentUser (UserBean.class).getSociety ().getObjectId ().trim ());
            query.findObjects (new FindListener<SocietyIntegral> () {
                @Override
                public void done (List<SocietyIntegral> list, BmobException e) {
                    if (e == null) {
                        Log.d ("Bmob", "社团任务list====" + list.size ());
                        dataList = list;
                        adapter = new SocietyIntegralAdapter ();
                        // TODO: 2017/4/24 跳转到详情
                        adapter.setEmptyView (
                                View.inflate (getActivity (), R.layout.societyintegral_empty_layout, null));
                        rvSocietyIntegral.setLayoutManager (new LinearLayoutManager (getActivity ()));
                        rvSocietyIntegral.setAdapter (adapter);

                    } else {
                        Log.d ("Bmob", "读取社团任务失败:" + e.getMessage ());
                    }
                }
            });
        }

        //        adapter = new SocietyIntegralAdapter ();
        return inflater.inflate (R.layout.fragment_society_integral, container, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);


    }
}
