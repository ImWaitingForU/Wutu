package com.soldiersoul.wutu.military;

import cn.ittiger.indexlist.entity.BaseEntity;

/**
 * Created by wxj on 2017/2/1.
 * 数据实体类
 */

public class CityEntity implements BaseEntity {
    private String mCityName;

    public CityEntity(String cityName) {

        mCityName = cityName;
    }

    @Override
    public String getIndexField() {

        return mCityName;
    }

    public String getCityName() {

        return mCityName;
    }
}
