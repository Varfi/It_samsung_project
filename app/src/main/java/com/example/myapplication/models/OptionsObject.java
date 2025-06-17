package com.example.myapplication.models;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;

import com.example.myapplication.MyDeviceAdminReceiver;

public class OptionsObject {
    Context context;
    String name;
    String serves;
    String actionFunction;
    Boolean isOn = Boolean.TRUE;
    Integer Power = 0;

    public OptionsObject(Context context) {
        this.context = context;
    }
    public OptionsObject(String name, String serves, String actionFunction, Boolean isOn){
        this.name = name;
        this.serves = serves;
        this.actionFunction = actionFunction;
        this.isOn = isOn;
    }


    public boolean isChecked() {
        return isOn;
    }

    public void setChecked(boolean checked) {
        isOn = checked;
    }

    public String getName() {
        return name;
    }

    public String getServes() {
        return serves;
    }

    public String getFunction() {
        return actionFunction;
    }




    public void CallFunction(){
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName adminComponent = new ComponentName(context, MyDeviceAdminReceiver.class);
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        switch (actionFunction){
            case "VibrationOn":
                devicePolicyManager.setGlobalSetting(adminComponent, Settings.Global.MODE_RINGER, String.valueOf(AudioManager.RINGER_MODE_VIBRATE));
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                break;
            case "VolumeOff":
                devicePolicyManager.setGlobalSetting(adminComponent, Settings.Global.MODE_RINGER, String.valueOf(AudioManager.RINGER_MODE_SILENT));
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                break;
            case "VolumeOn":
                devicePolicyManager.setGlobalSetting(adminComponent, Settings.Global.MODE_RINGER, String.valueOf(AudioManager.RINGER_MODE_NORMAL));
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                break;
        }
    }

}
