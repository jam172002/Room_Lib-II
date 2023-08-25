package com.example.roomlib_ii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.roomlib_ii.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bind;
    Entity entity;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        entity = new Entity("Mohammad", "Jamshaid", "15" );

        db = DBHelper.getDB(this);
        db.dao().insert(entity);
    }
}