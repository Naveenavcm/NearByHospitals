package com.example.helpinghands_is;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OxygenActivityMain extends AppCompatActivity {

    Button oxygenbutton, listbutton , listviewbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen_main);
        oxygenbutton = findViewById(R.id.oxygen);
        oxygenbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), ShowOxygen.class);
            startActivity(intent);
        });
           listbutton= findViewById(R.id.list);
        listbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), RouteActivity.class);
            startActivity(intent);
        });

        listviewbutton= findViewById(R.id.listview);
        listviewbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), ListDisplay.class);
            startActivity(intent);
        });
    }
}
