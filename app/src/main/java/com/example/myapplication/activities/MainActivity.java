package com.example.myapplication.activities;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MyDeviceAdminReceiver;
import com.example.myapplication.PowerConnectionReceiver;
import com.example.myapplication.R;
import com.example.myapplication.models.OptionsObject;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ENABLE_ADMIN = 1;
    private DevicePolicyManager devicePolicyManager;
    private ComponentName adminComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PowerConnectionReceiver receiver = new PowerConnectionReceiver();
        receiver.registerReceiver(this);

        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        adminComponent = new ComponentName(this, MyDeviceAdminReceiver.class);

        // Проверяем, есть ли права администратора
        if (!devicePolicyManager.isAdminActive(adminComponent)) {
            requestAdminRights(); // Если нет — запрашиваем
        } else {
            // Если есть — продолжаем работу
            Toast.makeText(this, "Права администратора уже активны", Toast.LENGTH_SHORT).show();
        }
    }

    private void requestAdminRights() {
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminComponent);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "Это приложение требует прав администратора для управления вибрацией и звуком.");
        startActivityForResult(intent, REQUEST_CODE_ENABLE_ADMIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ENABLE_ADMIN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Права администратора получены!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Права администратора не предоставлены!", Toast.LENGTH_SHORT).show();
                // Можно закрыть приложение или ограничить функционал
                finish();
            }
        }


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