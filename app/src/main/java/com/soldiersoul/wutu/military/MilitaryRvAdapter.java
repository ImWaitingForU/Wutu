package com.soldiersoul.wutu.military;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soldiersoul.wutu.beans.MilitaryNewsBean;

import java.util.List;

/**
 * Created by wxj on 2017/1/11.
 * 军事新闻RecyclerViewAdapter
 */

public class MilitaryRvAdapter extends BaseQuickAdapter<MilitaryNewsBean> {


    public MilitaryRvAdapter(int layoutResId, List<MilitaryNewsBean> data) {
        super(layoutResId, data);
    }

    public MilitaryRvAdapter(List<MilitaryNewsBean> data) {
        super(data);
    }

    public MilitaryRvAdapter(View contentView, List<MilitaryNewsBean> data) {
        super(contentView, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MilitaryNewsBean militaryNewsBean) {

    }
}
