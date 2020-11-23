package com.example.hungryfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    Button tv,camera,computer,mobile,headphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        biryani = findViewById(R.id.btn_biryani);
        veg = findViewById(R.id.btn_veg);
        nonveg  = findViewById(R.id.btn_nonveg);



        biryani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, biryani.class);
                startActivity(intent);
            }
        });

        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, veg.class);
                startActivity(intent);
            }
        });



        nonveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, nonveg.class);
                startActivity(intent);
            }
        });



    }
}

