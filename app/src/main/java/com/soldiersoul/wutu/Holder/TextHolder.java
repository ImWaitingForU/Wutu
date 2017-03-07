package com.soldiersoul.wutu.Holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.shuyu.common.RecyclerBaseHolder;
import com.shuyu.common.model.RecyclerBaseModel;
import com.soldiersoul.wutu.Model.TextModel;
import com.soldiersoul.wutu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shuyu on 2016/11/23.
 */

public class TextHolder extends RecyclerBaseHolder {

    public final static int ID = R.layout.text_item;
    @BindView(R.id.item_text)
    TextView itemText;

    public TextHolder(Context context, View v) {
        super(context, v);
    }

    @Override
    public void createView(View v) {
        ButterKnife.bind(this, v);
    }

    @Override
    public void onBind(RecyclerBaseModel model, int position) {
        TextModel textModel = (TextModel) (model);
        itemText.setText(textModel.getText());
    }
}
