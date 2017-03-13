package com.soldiersoul.wutu.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.util.Log;

/**
 * Created by chan on 2017/3/13.
 */

public class NetworkBroadcastReceiver extends BroadcastReceiver {

    public NetEvent event;

    @Override
    public void onReceive (Context context, Intent intent) {
        if (intent.getAction ().equals (ConnectivityManager.CONNECTIVITY_ACTION) ||
                intent.getAction ().equals (WifiManager.NETWORK_STATE_CHANGED_ACTION) ||
                intent.getAction ().equals (WifiManager.WIFI_STATE_CHANGED_ACTION)) {
            event.onNetChange (NetStateUtils.isNetworkConnected (context));
            Log.d ("NetworkBroadcast", "onReceive: 监听到网络变化--------------");
        }
    }

    public void setNetEvent (NetEvent event) {
        this.event = event;
    }

    public interface NetEvent {
        void onNetChange (boolean isConnected);
    }

}
