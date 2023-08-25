package com.example.roomlib_ii;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class DBHelper extends RoomDatabase {
    public static DBHelper instance;
    public static final String DB_Name = "DB";

    public static DBHelper getDB(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, DBHelper.class, DB_Name)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    public abstract DAO dao();
}
