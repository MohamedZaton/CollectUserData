package com.example.collectuserdata.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.collectuserdata.pojo.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAllUsers();
    @Insert
    void insert(User user);
    @Delete
    void delete(User user);
    @Query("DELETE FROM user_table")
    void deleteAllNotes();

}
