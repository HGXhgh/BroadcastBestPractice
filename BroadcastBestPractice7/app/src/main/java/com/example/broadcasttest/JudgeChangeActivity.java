package com.example.broadcasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class JudgeChangeActivity extends AppCompatActivity {
    private PowerConnectionReceiver powerConnectionReceiver;
    private BatteryLevelReceiver batteryLevelReceiver;
    private NetworkChangeReceiver networkChangeReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judgechange);
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        powerConnectionReceiver = new PowerConnectionReceiver();
        batteryLevelReceiver = new BatteryLevelReceiver();
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(powerConnectionReceiver, filter);
        registerReceiver(batteryLevelReceiver,filter);
        registerReceiver(networkChangeReceiver,intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(powerConnectionReceiver);
        unregisterReceiver(batteryLevelReceiver);
    }
}