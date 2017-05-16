package com.soldiersoul.wutu.Holder;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;


import com.shuyu.common.RecyclerBaseHolder;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Model.ImageModel;
import com.soldiersoul.wutu.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wxj on 2017/02/27.
 */

public class ImageHolder extends RecyclerBaseHolder {

    public final static int ID = R.layout.image_item;

    @BindView (R.id.ivNewsPic) ImageView itemImage;
    @BindView (R.id.tvNewsTitle) TextView newsTitle;
    @BindView (R.id.tvNewsContent) TextView newsContent;
    @BindView (R.id.tvNewsTime) TextView newsTime;

    public ImageHolder (Context context, View v) {
        super (context, v);
    }


    @Override
    public void createView (View v) {
        ButterKnife.bind (this, v);
    }

    @Override
    public void onBind (RecyclerBaseModel model, int position) {
        ImageModel imageModel = (ImageModel) model;
        Picasso.with (context).load (imageModel.getImgUrl ()).into (itemImage);
        newsTitle.setText (imageModel.getNewsTitle ());
        newsContent.setText ("");
        String time = imageModel.getNewsTime ();
        newsTime.setText (time.substring (time.lastIndexOf (";") + 1, time.length ()));
    }

    @Override
    public AnimatorSet getAnimator (View view) {
        AnimatorSet animatorSet = new AnimatorSet ();
        Animator animator = ObjectAnimator.ofFloat (view, "translationY", dip2px (context, 80), 0);
        animator.setDuration (500);
        animator.setInterpolator (new OvershootInterpolator (.5f));

        Animator animatorSx = ObjectAnimator.ofFloat (view, "scaleX", 0.5f, 1f);
        animator.setDuration (500);
        animator.setInterpolator (new OvershootInterpolator (.5f));

        Animator animatorSy = ObjectAnimator.ofFloat (view, "scaleY", 0.5f, 1f);
        animator.setDuration (500);
        animator.setInterpolator (new OvershootInterpolator (.5f));

        animatorSet.playTogether (animator, animatorSx, animatorSy);
        return animatorSet;
    }

    /**
     * dip转为PX
     */
    public static int dip2px (Context context, float dipValue) {
        float fontScale = context.getResources ().getDisplayMetrics ().density;
        return (int) (dipValue * fontScale + 0.5f);
    }

}
