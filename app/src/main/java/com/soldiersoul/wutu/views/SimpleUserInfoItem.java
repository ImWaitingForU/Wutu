package com.soldiersoul.wutu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

public class SimpleUserInfoItem extends RelativeLayout {

    private TextView tvItemName;
    private TextView tvUserData;
    private ImageView ivRight;

    public SimpleUserInfoItem (Context context) {
        super (context);
    }

    public SimpleUserInfoItem (Context context, AttributeSet attrs) {
        super (context, attrs);
        View view = View.inflate (context, R.layout.userinfo_item_layout, null);
        addView (view);

        setBackgroundResource (R.drawable.white_btn_selector);

        tvItemName = (TextView) view.findViewById (R.id.tvItemName);
        tvUserData = (TextView) view.findViewById (R.id.tvUserData);
        ivRight = (ImageView) view.findViewById (R.id.ivRight);
    }

    /**
     * 当显示其他用户信息时，让其变为不可点击，隐藏箭头
     */
    public void setOtherUserUI(){
        ivRight.setVisibility (INVISIBLE);
    }

    public void setItemName (String itemName) {
        if (tvItemName != null) {
            tvItemName.setText (itemName);
        }
    }

    public void setUserData (String userData) {
        if (tvUserData != null) {
            tvUserData.setText (userData);
        }
    }

}
