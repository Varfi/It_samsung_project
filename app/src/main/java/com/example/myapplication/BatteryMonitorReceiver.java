package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.myapplication.data.Options;
import com.example.myapplication.models.OptionsObject;

import java.util.List;

public class BatteryMonitorReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) return;
        Options list = new Options();
        List<OptionsObject> arr = list.getGlobalList();
        switch (action) {
            case Intent.ACTION_POWER_CONNECTED:
                for (OptionsObject obj : arr) {
                    if (obj.getServes().equals("ConnectingPower")) {
                        obj.CallFunction();
                    }
                }
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                for (OptionsObject obj : arr) {
                    if (obj.getServes().equals("PowerOff")) {
                        obj.CallFunction();
                    }
                }
                break;
        }
    }
}
