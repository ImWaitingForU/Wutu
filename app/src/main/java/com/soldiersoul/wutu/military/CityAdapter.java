package com.soldiersoul.wutu.military;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soldiersoul.wutu.R;

import java.util.List;

import cn.ittiger.indexlist.adapter.IndexStickyViewAdapter;

/**
 * Created by wxj on 2017/2/1.
 */

public class CityAdapter extends IndexStickyViewAdapter<CityEntity> {

    public CityAdapter(List<CityEntity> originalList) {

        super(originalList);//要展示的数据
    }

    @Override
    public RecyclerView.ViewHolder onCreateIndexViewHolder(ViewGroup parent) {
        //索引视图ViewHolder，如：热门城市  视图
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.indexsticky_item_index, parent, false);
        return new IndexViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup parent) {
        //城市内容视图ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindIndexViewHolder(RecyclerView.ViewHolder holder, int position, String indexName) {
        //给索引视图绑定数据
        IndexViewHolder indexViewHolder = (IndexViewHolder) holder;
        indexViewHolder.mTextView.setText(indexName);
    }

    @Override
    public void onBindContentViewHolder(RecyclerView.ViewHolder holder, int position, CityEntity itemData) {
        //给内容视图绑定数据
        CityViewHolder cityViewHolder = (CityViewHolder) holder;
        cityViewHolder.mTextView.setText(itemData.getCityName());
    }
    class CityViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public CityViewHolder(View itemView) {

            super(itemView);
            mTextView = (TextView) itemView;
        }
    }

    class IndexViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public IndexViewHolder(View itemView) {

            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_index);
        }
    }
}
