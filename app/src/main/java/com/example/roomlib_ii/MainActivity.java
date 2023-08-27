package com.example.roomlib_ii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.roomlib_ii.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bind;
    Entity entity;
    DBHelper db;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.fltAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Add.class));
            }
        });

        db = DBHelper.getDB(this);
        List<Entity> ent = db.dao().getData();

        for(int i = 0; i < ent.size(); i++){
            Log.d("Data: ", " ID: " + ent.get(i).getId()
                    + " FirstName: " + ent.get(i).getfName()
                    + " LastName: " + ent.get(i).getlName()
                    + " Grade: " + ent.get(i).getGrade() );
        }

        bind.reV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, ent);
        bind.reV.setAdapter(adapter);
    }


}