package com.soldiersoul.wutu.Holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.shuyu.common.RecyclerBaseHolder;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Model.MutilModel;
import com.soldiersoul.wutu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rose on 2017/5/15.
 * <p>
 * 军事政策福利holder
 */

public class PolicyHolder extends RecyclerBaseHolder {

    public final static int ID = R.layout.policy_item;
    @BindView (R.id.tvPolicyTitle) TextView title;
    @BindView (R.id.tvPolicyContent) TextView content;
    @BindView (R.id.tvPolicyResource) TextView resource;

    public PolicyHolder (Context context, View v) {
        super (context, v);
    }

    @Override
    public void createView (View view) {
        ButterKnife.bind (this, view);
    }

    @Override
    public void onBind (RecyclerBaseModel recyclerBaseModel, int i) {
        MutilModel model = (MutilModel) recyclerBaseModel;
        title.setText (model.getTitle ());
        content.setText (model.getContent ());
        resource.setText ("来源:" + model.getResource ());
    }
}
