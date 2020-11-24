package com.example.hungryfood;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AllNonVegRecipiesActivity extends AppCompatActivity {
    ListView list_view;
    List<GetRecipePojo> getRecipePojos;
    ProgressDialog progressDialog;
    ViewAllRecipiesAdapter viewAllRecipiesAdapter;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipies);


        getSupportActionBar().setTitle("Non Veg Recipies");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = FirebaseFirestore.getInstance();


        getRecipePojos= new ArrayList<>();

        list_view=(ListView)findViewById(R.id.list_view);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait data is being Loaded");
        progressDialog.show();
        GetRecipeDetails();
       /* Query query = FirebaseDatabase.getInstance().getReference("Recipe Name");
        query.addListenerForSingleValueEvent(valueEventListener);*/
    }

    public void GetRecipeDetails() {
        db.collection("Recipies").whereEqualTo("category","Non_Veg")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                GetRecipePojo homeDataPojo = document.toObject(GetRecipePojo.class);
                                getRecipePojos.add(homeDataPojo);
                            }
                            viewAllRecipiesAdapter = new ViewAllRecipiesAdapter(getRecipePojos, AllNonVegRecipiesActivity.this);
                            list_view.setAdapter(viewAllRecipiesAdapter);

                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
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