package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class BatteryLevelReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = level / (float)scale;
        if(batteryPct<=0.2){
            Log.i("BatteryLevelReceiver","电量不足");
        }
        else{
            Log.i("BatteryLevelReceiver","电量充足");
        }
    }
}