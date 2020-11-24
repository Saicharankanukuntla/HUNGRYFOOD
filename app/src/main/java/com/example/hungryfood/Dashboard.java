package com.example.hungryfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    ImageView btn_veg,btn_non_veg;
    Button btn_add_recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        btn_add_recipe=(Button) findViewById(R.id.btn_add_recipe);
        btn_veg=(ImageView) findViewById(R.id.btn_veg);
        btn_non_veg=(ImageView) findViewById(R.id.btn_non_veg);

        btn_add_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, AddRecipeActivity.class);
                startActivity(intent);
            }
        });

        btn_veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, AllVegRecipiesActivity.class);
                startActivity(intent);
            }
        });

        btn_non_veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, AllNonVegRecipiesActivity.class);
                startActivity(intent);
            }
        });
    }
}

