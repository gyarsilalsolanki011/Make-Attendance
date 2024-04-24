package com.gyarsilalsolanki011.make_attendance.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.gyarsilalsolanki011.make_attendance.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.studentLoginBtn.setOnClickListener(v -> {

            Intent iStudentLogin = new Intent(MainActivity.this,LoginActivity.class);
            iStudentLogin.putExtra("whoLogin",true);
            startActivity(iStudentLogin);
            finish();
        });



        binding.facultyLoginBtn.setOnClickListener(v -> {

            Intent iFacultyLogin = new Intent(MainActivity.this, LoginActivity.class);
            iFacultyLogin.putExtra("whoLogin",false);
            startActivity(iFacultyLogin);
            finish();
        });

    }
}