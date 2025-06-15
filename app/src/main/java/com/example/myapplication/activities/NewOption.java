package com.example.myapplication.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.data.Options;
import com.example.myapplication.models.OptionsObject;

public class NewOption extends AppCompatActivity {

    private String server;
    private String function;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.new_option);

        ImageButton BackImB = findViewById(R.id.BackImBNO);
        BackImB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayout LLActionChange = findViewById(R.id.ActionsChange);
        LinearLayout LLTriggerChange = findViewById(R.id.TriggersChange);

        TextView ChangeText = findViewById(R.id.TextTrOrAct);

        LinearLayout LLPower = findViewById(R.id.LLPower);

        // _________________________________________________________________________________________

        Button PowerB = findViewById(R.id.PowerB);
        PowerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LLPower.getVisibility() == View.VISIBLE){LLPower.setVisibility(View.GONE);}
                else{LLPower.setVisibility(View.VISIBLE);}
            }
        });

        LinearLayout LLTime = findViewById(R.id.LLTime);

        Button TimeB = findViewById(R.id.TimeB);
        TimeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LLTime.getVisibility() == View.VISIBLE){LLTime.setVisibility(View.GONE);}
                else{LLTime.setVisibility(View.VISIBLE);}
            }
        });

        LinearLayout LLValue = findViewById(R.id.LLValume);

        Button VolumeB = findViewById(R.id.VolumeB);
        VolumeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LLValue.getVisibility() == View.VISIBLE){LLValue.setVisibility(View.GONE);}
                else{LLValue.setVisibility(View.VISIBLE);}
            }
        });

        //__________________________________________________________________________________________



        Button ConnectingPowerB = findViewById(R.id.ConnectingPowerB);
        ConnectingPowerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server = "ConnectingPower";
                LLActionChange.setVisibility(View.VISIBLE);
                LLTriggerChange.setVisibility(View.GONE);
                ChangeText.setText("Выберите действие");
            }
        });

        Button PowerOffB = findViewById(R.id.PowerOffB);
        PowerOffB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server = "PowerOff";
                LLActionChange.setVisibility(View.VISIBLE);
                LLTriggerChange.setVisibility(View.GONE);
                ChangeText.setText("Выберите действие");
            }
        });

        Button PressingPowerB = findViewById(R.id.PressingPowerB);
        PressingPowerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server = "PressingPower";
                LLActionChange.setVisibility(View.VISIBLE);
                LLTriggerChange.setVisibility(View.GONE);
                ChangeText.setText("Выберите действие");
            }
        });

        Button BatteryChargeLevel = findViewById(R.id.ChargeLavelB);
        BatteryChargeLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server = "BatteryChargeLevel";
                LLActionChange.setVisibility(View.VISIBLE);
                LLTriggerChange.setVisibility(View.GONE);
                ChangeText.setText("Выберите действие");
            }
        });

        Button DayOfWeekB = findViewById(R.id.DayOfWeek);
        DayOfWeekB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server = "DayOfWeek";
                LLActionChange.setVisibility(View.VISIBLE);
                LLTriggerChange.setVisibility(View.GONE);
                ChangeText.setText("Выберите действие");
            }
        });

        Button DayOfMonthB = findViewById(R.id.DayOfMonth);
        DayOfMonthB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server = "DayOfMonth";
                LLActionChange.setVisibility(View.VISIBLE);
                LLTriggerChange.setVisibility(View.GONE);
                ChangeText.setText("Выберите действие");
            }
        });

        //__________________________________________________________________________________________



        Button VolumeOffB = findViewById(R.id.VolumeOffB);
        VolumeOffB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function = "VolumeOffB";

                AlertDialog.Builder builder = new AlertDialog.Builder(NewOption.this);
                builder.setTitle("Введите название опции");
                final EditText input = new EditText(NewOption.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        name = input.getText().toString();
                        Toast.makeText(NewOption.this, "Опция сохранена: " + name, Toast.LENGTH_SHORT).show();
                        Options OO = (Options) getApplicationContext();
                        OptionsObject newOptionsObject = new OptionsObject(name, server, function, Boolean.TRUE);
                        OO.addToGlobalList(newOptionsObject);
                        finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        Button VibrationOnB = findViewById(R.id.VibrationOnB);
        VibrationOnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function = "VibrationOnB";

                AlertDialog.Builder builder = new AlertDialog.Builder(NewOption.this);
                builder.setTitle("Введите название опции");
                final EditText input = new EditText(NewOption.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        name = input.getText().toString();
                        Toast.makeText(NewOption.this, "Опция сохранена: " + name, Toast.LENGTH_SHORT).show();
                        Options OO = (Options) getApplicationContext();
                        OptionsObject newOptionsObject = new OptionsObject(name, server, function, Boolean.TRUE);
                        OO.addToGlobalList(newOptionsObject);
                        finish();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}