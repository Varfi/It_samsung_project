package com.example.myapplication.activities;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MyDeviceAdminReceiver;
import com.example.myapplication.R;
import com.example.myapplication.models.OptionsObject;

public class MainActivity extends AppCompatActivity {

    OptionsObject setContext = new OptionsObject(this);
    public void requestAdminRights(Activity activity) {
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
                new ComponentName(activity, MyDeviceAdminReceiver.class));
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "Для изменения системных настроек звука и вибрации");
        activity.startActivityForResult(intent, REQUEST_CODE_ENABLE_ADMIN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button BMy_Options = findViewById(R.id.MyOptions);
        BMy_Options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyOptions.class);
                startActivity(intent);
            }
        });

        Button BNew_Option = findViewById(R.id.NewOption);
        BNew_Option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewOption.class);
                startActivity(intent);
            }
        });

        Button BSettings = findViewById(R.id.Settings);
        BSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });
    }
}