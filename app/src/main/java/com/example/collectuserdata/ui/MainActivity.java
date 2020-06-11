package com.example.collectuserdata.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.collectuserdata.R;
import com.example.collectuserdata.ViewModel.UserViewModel;
import com.example.collectuserdata.pojo.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //todo 1 you must watch part 5 code flow

        // connect between vModel and View



    }
}
