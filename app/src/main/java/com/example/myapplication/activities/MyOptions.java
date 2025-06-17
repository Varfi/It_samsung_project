package com.example.myapplication.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Cards.OptionCards;
import com.example.myapplication.PowerConnectionReceiver;
import com.example.myapplication.R;
import com.example.myapplication.data.Options;
import com.example.myapplication.models.OptionsObject;

import java.util.ArrayList;
import java.util.List;

public class MyOptions extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.my_options);

        ImageButton BackImB = findViewById(R.id.BackImBMO);
        BackImB.setOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recycler_view_options);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Options options = (Options) getApplicationContext();
        List<OptionsObject> optionsList = options.getGlobalList();
        if (optionsList == null) {
            optionsList = new ArrayList<>();
        }

        OptionCards adapter = new OptionCards(optionsList);
        recyclerView.setAdapter(adapter);

        PowerConnectionReceiver receiver = new PowerConnectionReceiver();
        receiver.registerReceiver(this);
    }
}