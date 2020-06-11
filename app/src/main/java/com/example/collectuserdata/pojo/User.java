package com.example.collectuserdata.pojo;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User  {

    @PrimaryKey(autoGenerate = true)
    public  int id ;
    @ColumnInfo(name = "name")
    public String name ;
    @ColumnInfo(name = "job_title")
    public String jobTitle ;
    @ColumnInfo(name = "gender")
    public String gender ;
    @ColumnInfo(name = "age")
    public  int age ;
 @ColumnInfo(name = "image_code")
    public  int imageCode ;

    public User(String name, String jobTitle, String gender, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
