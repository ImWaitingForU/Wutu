package com.soldiersoul.wutu.society.frags;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

import java.util.List;
import java.util.Map;

/**
 * Created by wxj on 2017/4/10.
 */

public class SocietyBaseInfoListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Map<String, Object>> data;

    public SocietyBaseInfoListAdapter(Context context, List data) {
        this.mContext = context;
        this.data = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {

            holder = new ViewHolder();

            convertView = mInflater.inflate(R.layout.infoitem, null);
            holder.memberPhoto = (ImageView) convertView.findViewById(R.id.iv_memberphoto);
            holder.memberName = (TextView) convertView.findViewById(R.id.tv_membername);
            holder.memberPhone = (TextView) convertView.findViewById(R.id.tv_memberphone);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }


        holder.memberPhoto.setBackgroundResource(R.mipmap.ic_launcher);
        holder.memberName.setText((String) data.get(position).get("name"));
        holder.memberPhone.setText((String) data.get(position).get("phone"));


        return convertView;
    }

    class ViewHolder {
        private ImageView memberPhoto;
        private TextView memberName;
        private TextView memberPhone;
    }
}
