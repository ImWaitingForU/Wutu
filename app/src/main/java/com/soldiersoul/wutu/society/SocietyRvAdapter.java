package com.soldiersoul.wutu.society;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Chan on 2017/1/8 0008.
 * <p>
 * 社团界面RecyclerAdapter
 */

public class SocietyRvAdapter extends BaseQuickAdapter<SocietyBean> {
    public SocietyRvAdapter (int layoutResId, List<SocietyBean> data) {
        super (layoutResId, data);
    }

    @Override
    protected void convert (BaseViewHolder baseViewHolder, SocietyBean societyBean) {

    }
}
