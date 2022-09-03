package com.lifeline.lifelineApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class patientListActivity extends AppCompatActivity {

    String[] arr = {"Rajesh", "Aruna", "Sonalika", "Ramu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        CustomAdapter ad = new CustomAdapter(arr);
        ad.setSizeBig();
        ad.removeWarningSign();
        RecyclerView patientList = findViewById(R.id.patientList);
        patientList.setLayoutManager(new LinearLayoutManager(this));
        patientList.setAdapter(ad);
    }
}