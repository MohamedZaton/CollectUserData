package com.example.collectuserdata.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.collectuserdata.Data.AppDatabase;
import com.example.collectuserdata.Data.UserDao;
import com.example.collectuserdata.pojo.User;

import java.util.List;

public class UserRepository {
    private UserDao userDao ;
    private LiveData<List<User>> allUsers ;

    public UserRepository(Application application) {
        // create db
        AppDatabase db = AppDatabase.getInstance(application) ;
        //auto user Dao
        userDao = db.userDao();
        // get all users
        allUsers = userDao.getAllUsers() ;

    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }


    /** using AsycTask cuz Room don't accept to make any process on main thread it will be crash  **/

    public void  insertUser(User user)
    {
        new InsertAsycTask(userDao).execute(user);
    }

    private static  class InsertAsycTask extends AsyncTask<User,Void,Void> {
        private UserDao userDao ;

        public InsertAsycTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
        return null;

        }
    }

}


