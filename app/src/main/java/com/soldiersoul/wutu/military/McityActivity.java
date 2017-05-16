package com.soldiersoul.wutu.military;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.itemDecoration.IndexStickyViewDecoration;
import com.soldiersoul.wutu.utils.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import cn.ittiger.indexlist.IndexStickyView;
import cn.ittiger.indexlist.listener.OnItemClickListener;
import cn.ittiger.indexlist.listener.OnItemLongClickListener;

public class McityActivity extends BaseActivity implements OnItemClickListener<CityEntity>,
        OnItemLongClickListener<CityEntity> {

    @BindView(R.id.indexStickyView) IndexStickyView mIndexStickyView;
    CityAdapter mAdapter;
    private Context mContext;
    //城市列表
    private List<CityEntity> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setHomeButtonStaff ("选择省市");

        mIndexStickyView.addItemDecoration(new IndexStickyViewDecoration (this));
        mAdapter = new CityAdapter(initCitys());
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemLongClickListener(this);
        mIndexStickyView.setAdapter(mAdapter);
    }

    @Override
    public int getContentViewId () {
        return R.layout.activity_mcity;
    }

    @Override
    public void onItemClick(View childView, int position, CityEntity item) {
        //省份政策详情展示
        Intent intent = new Intent(this,CityContentActivity.class);
        intent.putExtra ("actTitle",item.getCityName ());
        intent.putExtra ("isCity",true);
        startActivity (intent);
    }

    @Override
    public void onItemLongClick(View childView, int position, CityEntity item) {
        Toast.makeText(mContext, "长按：" + item.getCityName() + ",位置：" + position, Toast.LENGTH_SHORT).show();
    }

    List<CityEntity> initCitys() {
        list = new ArrayList<>();
        // 初始化城市列表数据
        List<String> contactStrings = Arrays.asList(getResources().getStringArray(R.array.city_array));
        for (int i = 0; i < contactStrings.size(); i++) {
            CityEntity cityEntity = new CityEntity(contactStrings.get(i));
            list.add(cityEntity);
        }
        return list;
    }
}
