package com.example.roomlib_ii;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "My_Table")
public class Entity {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo
    String fName;

    @ColumnInfo
    String lName;

    @ColumnInfo
    String grade;

    public Entity(int id, String fName, String lName, String grade) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.grade = grade;
    }

    @Ignore

    public Entity(String fName, String lName, String grade) {
        this.fName = fName;
        this.lName = lName;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
