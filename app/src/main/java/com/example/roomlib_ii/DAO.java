package com.example.roomlib_ii;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    void insert(Entity entity);

    @Query("select * from My_Table")
    List<Entity> getData();

    @Query("delete from My_Table where id = :uid")
    void deleteById(int uid);

    @Update
    void update(Entity entity);
}
