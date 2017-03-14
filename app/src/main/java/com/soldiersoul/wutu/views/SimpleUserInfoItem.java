package com.soldiersoul.wutu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

public class SimpleUserInfoItem extends RelativeLayout {

    private TextView tvItemName;
    private TextView tvUserData;

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
