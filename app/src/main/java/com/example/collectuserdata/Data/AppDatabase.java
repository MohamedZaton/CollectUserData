package com.example.collectuserdata.Data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.collectuserdata.pojo.User;

@Database(entities = {User.class},version = 1)
public abstract class AppDatabase  extends RoomDatabase {
    private  static  AppDatabase instance ;

    public abstract UserDao userDao();
    public static synchronized AppDatabase getInstance(Context context) {
        if(instance == null)
        {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "user_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }



    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
