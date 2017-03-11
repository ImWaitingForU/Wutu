package com.soldiersoul.wutu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

public class SimpleUserInfoItem extends RelativeLayout {

    private TextView tvItemName;
    private EditText etUserData;

    public SimpleUserInfoItem (Context context) {
        super (context);
    }

    public SimpleUserInfoItem (Context context, AttributeSet attrs) {
        super (context, attrs);
        View view = View.inflate (context, R.layout.userinfo_item_layout, null);
        addView (view);

        tvItemName = (TextView) view.findViewById (R.id.tvItemName);
        etUserData = (EditText) view.findViewById (R.id.etUserData);

    }

    public void setItemName (String itemName) {
        if (tvItemName != null) {
            tvItemName.setText (itemName);
        }
    }

    public void setUserData (String userData) {
        if (etUserData != null) {
            etUserData.setText (userData);
        }
    }

}
