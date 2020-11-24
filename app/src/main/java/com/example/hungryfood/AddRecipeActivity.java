package com.example.hungryfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class AddRecipeActivity extends AppCompatActivity {
    Spinner spin_category;
    EditText et_recipe_name,et_recipe_description;
    Button btn_add_recipe;
    ProgressDialog loadingBar;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);


        getSupportActionBar().setTitle("Add Recipe");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = FirebaseFirestore.getInstance();


        loadingBar = new ProgressDialog(AddRecipeActivity.this);

        et_recipe_name=(EditText) findViewById(R.id.et_recipe_name);
        et_recipe_description=(EditText) findViewById(R.id.et_recipe_description);
        spin_category=(Spinner)findViewById(R.id.spin_category);

        btn_add_recipe=(Button)findViewById(R.id.btn_add_recipe);

        btn_add_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Createrecipeprocess();

            }
        });
    }
    private void Createrecipeprocess() {

        String name = et_recipe_name.getText().toString();
        String desc = et_recipe_description.getText().toString();
        String category = spin_category.getSelectedItem().toString();

        if (TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Please write your recipe name...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(desc))
        {
            Toast.makeText(this, "Please write Description...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(category))
        {
            Toast.makeText(this, "Please Select Category...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Please Wait");
            loadingBar.setMessage("Please wait,  while we are adding recipe details.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            addrecipe(name, desc,category);
        }
    }

    private void addrecipe(final String name, final String desc,String category) {

        HashMap<String, Object> recipedata = new HashMap<>();
        recipedata.put("name", name);
        recipedata.put("description", desc);
        recipedata.put("category", category);

        db.collection("Recipies")
                .add(recipedata)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(AddRecipeActivity.this, "Recipe Added Succussfully.", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();

                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        loadingBar.dismiss();
                        Toast.makeText(AddRecipeActivity.this, "Network Error: Please try again after some time...", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}