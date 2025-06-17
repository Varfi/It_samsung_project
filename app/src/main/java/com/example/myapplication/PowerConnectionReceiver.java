package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.Toast;

import com.example.myapplication.data.Options;
import com.example.myapplication.models.OptionsObject;

import java.util.List;

public class PowerConnectionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Options list = (Options) context.getApplicationContext();



        if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
            for (OptionsObject obj : list.getGlobalList()) {
                if (obj.isChecked() && obj.getServes().equals("ConnectingPower")) {
                    obj.CallFunction(obj.getFunction());
                }
            }
        } else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)) {
            for (OptionsObject obj : list.getGlobalList()) {
                if (obj.isChecked() && obj.getServes().equals("PowerOff")) {
                    obj.CallFunction(obj.getFunction());
                }
            }
        }
    }

    // Метод для регистрации BroadcastReceiver
    public void registerReceiver(Context context) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        context.registerReceiver(this, filter);
    }

    // Метод для отмены регистрации BroadcastReceiver
    public void unregisterReceiver(Context context) {
        try {
            context.unregisterReceiver(this);
        } catch (IllegalArgumentException e) {
            // Receiver was not registered
        }
    }
}
