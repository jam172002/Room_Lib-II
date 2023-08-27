package com.example.roomlib_ii;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Entity.class, exportSchema = false, version = 1 )
public abstract class DBHelper extends RoomDatabase {
    public static DBHelper instance;
    public static final String DB_Name = "DB";

    public static DBHelper getDB(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, DBHelper.class, DB_Name)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract DAO dao();
}
