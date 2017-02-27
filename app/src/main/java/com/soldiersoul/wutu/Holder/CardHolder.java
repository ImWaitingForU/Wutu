package com.soldiersoul.wutu.Holder;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.shuyu.common.RecyclerBaseHolder;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Model.CardModel;
import com.soldiersoul.wutu.Model.ImageModel;
import com.soldiersoul.wutu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wxj on 2017/2/27.
 */

public class CardHolder extends RecyclerBaseHolder{

    public final static int ID = R.layout.activity_mad_item;


    @BindView(R.id.ivMadpic)
    ImageView itemImage;
    @BindView(R.id.tvMadTitle)
    TextView itemTitle;
    @BindView(R.id.tvMadContent)
    TextView itemContent;

    public CardHolder(Context context, View v) {
        super(context, v);
    }


    @Override
    public void createView(View v) {
        ButterKnife.bind(this, v);
    }

    @Override
    public void onBind(RecyclerBaseModel model, int position) {
        CardModel cardModel = (CardModel) model;
        itemImage.setImageResource(cardModel.getImg1());
        itemTitle.setText(cardModel.getTv1());
        itemContent.setText(cardModel.getTv2());
    }

    @Override
    public AnimatorSet getAnimator(View view) {
        AnimatorSet animatorSet = new AnimatorSet();


//        Animator animatorSx = ObjectAnimator.ofFloat(view, "scaleX", 0.8f, 1f);
//        animatorSx.setDuration(1000);
//        animatorSx.setInterpolator(new OvershootInterpolator(.5f));

        Animator animatorSy = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1f);
        animatorSy.setDuration(1000);
        animatorSy.setInterpolator(new OvershootInterpolator(.5f));

        animatorSet.playTogether(animatorSy);
        return animatorSet;
    }

    /**
     * dip转为PX
     */
    public static int dip2px(Context context, float dipValue) {
        float fontScale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * fontScale + 0.5f);
    }
}
