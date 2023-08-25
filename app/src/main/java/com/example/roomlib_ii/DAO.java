package com.example.roomlib_ii;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DAO {

    @Insert
    void insert(Entity entity);

    @Query("select * from My_Table")
    Entity getData();


}
