package com.example.roomlib_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomlib_ii.databinding.ActivityAddBinding;

import java.util.ArrayList;
import java.util.List;

public class Add extends AppCompatActivity {

    DBHelper db;
    List<Entity> data;
    ActivityAddBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName = bind.etFName.getText().toString().trim();
                String LName = bind.etLName.getText().toString().trim();
                String Grade = bind.etGrade.getText().toString().trim();

                Entity data = new Entity(fName, LName, Grade);
                
                db = DBHelper.getDB(getApplicationContext());
                
                db.dao().insert(data);

                Toast.makeText(Add.this, "Data Added Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Add.this, MainActivity.class));
                finish();
                
                
            }
        });
    }
}