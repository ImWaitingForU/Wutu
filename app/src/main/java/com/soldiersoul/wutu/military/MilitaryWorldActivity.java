package com.soldiersoul.wutu.military;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.soldiersoul.wutu.R;

public class MilitaryWorldActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_military_world);
    }
}
