package com.soldiersoul.wutu.more;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by chan on 2017/2/14.
 */

public class AvatarBehavior extends CoordinatorLayout.Behavior {

	public AvatarBehavior() {
	}

	public AvatarBehavior(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
		return dependency instanceof ImageView;
	}

	@Override
	public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

		ViewCompat.offsetTopAndBottom(dependency, dependency.getTop() - child.getTop());

		ViewCompat.setScaleX(dependency, child.getScaleX() - dependency.getScaleX());
		ViewCompat.setScaleY(dependency, child.getScaleY() - dependency.getScaleY());

		return true;
	}
}
