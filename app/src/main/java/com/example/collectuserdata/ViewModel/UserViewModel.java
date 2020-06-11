package com.example.collectuserdata.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.collectuserdata.Repository.UserRepository;
import com.example.collectuserdata.pojo.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository ;
    private LiveData<List<User>> allUser ;
    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUser = repository.getAllUsers();
    }

    public void insert(User user) {
        repository.insertUser(user);
    }
    public LiveData<List<User>> getAllUsers() {
        return allUser;
    }

}
