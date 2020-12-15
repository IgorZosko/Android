package com.example.techrepair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TechDetails extends AppCompatActivity {
    TextView techName;
    TextView techModel;
    TextView techDescribe;
    TextView techPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_details);

        techName = findViewById(R.id.name);
        techModel = findViewById(R.id.model);
        techDescribe = findViewById(R.id.describe);
        techPrice = findViewById(R.id.priсe);
    }


    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}