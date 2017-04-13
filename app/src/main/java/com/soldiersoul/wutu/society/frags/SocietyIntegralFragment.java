package com.soldiersoul.wutu.society.frags;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.bean.SocietyBean;
import com.soldiersoul.wutu.society.bean.SocietyIntegralBean;
import com.soldiersoul.wutu.utils.DataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 社团积分界面(合并任务)
 */
public class SocietyIntegralFragment extends Fragment {

    @BindView (R.id.rvSocietyIntegral) RecyclerView rvSocietyIntegral;
    //private ArrayList<SocietyIntegralBean> dataList = new ArrayList<>();
    private SocietyIntegralAdapter adapter;

    private SocietyBean society;

    public SocietyIntegralFragment () {
    }

    public SocietyIntegralFragment (SocietyBean society) {
        this.society = society;
    }

    /**
     * 社团照片封面Adapter
     */
    public class SocietyIntegralAdapter extends BaseQuickAdapter<SocietyIntegralBean> {


        public SocietyIntegralAdapter () {
            //这里设置数据
            super (R.layout.society_integral_item, DataUtils.getSocietyIntegralInfo (getContext ()));
        }

        @Override
        protected void convert (BaseViewHolder baseViewHolder, SocietyIntegralBean societyIntegralBean) {
            baseViewHolder.setText (R.id.tv_integralname, societyIntegralBean.getIntegralName ())
                          .setText (R.id.tv_integralcontent, societyIntegralBean.getIntegralContent ())
                          .setText (R.id.tv_integralreward, societyIntegralBean.getIntegralReward ())
                          .setText (R.id.tv_deadline, societyIntegralBean.getDeadline ());
        }
    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        adapter = new SocietyIntegralAdapter ();
        return inflater.inflate (R.layout.fragment_society_integral, container, false);
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);

        adapter.setEmptyView (View.inflate (getActivity (), R.layout.societyalbum_empty_layout, null));
        rvSocietyIntegral.setLayoutManager (new LinearLayoutManager (getActivity ()));
        rvSocietyIntegral.setAdapter (adapter);

    }
}
