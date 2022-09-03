package com.lifeline.lifelineApp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    String[] arr = {"Rajesh", "Aruna", "Sonalika", "Ramu"};
    TextView welcomeBack, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        welcomeBack = findViewById(R.id.welcomeBack);
//        Get user's name from database and put in below
        //welcomeBack.setText("Welcome ");

        CustomAdapter ad = new CustomAdapter(arr);
        RecyclerView alerts_list = findViewById(R.id.alerts_list);
        alerts_list.setLayoutManager(new LinearLayoutManager(this));
        alerts_list.setAdapter(ad);

        Button patientStatus = findViewById(R.id.patientStatus);
        patientStatus.setOnClickListener(v -> {
            Intent goToPatientsList = new Intent(MainActivity.this, patientListActivity.class);
            startActivity(goToPatientsList);
        });

        CustomAdapter bc = new CustomAdapter(arr);
        bc.removeWarningSign();
        RecyclerView recent_list = findViewById(R.id.recent_list);
        recent_list.setLayoutManager(new LinearLayoutManager(this));
        recent_list.setAdapter(bc);
    }
}