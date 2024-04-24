package com.gyarsilalsolanki011.make_attendance.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.auth.FirebaseAuthRepository;
import com.gyarsilalsolanki011.make_attendance.database.UserType;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private final FirebaseAuthRepository auth = new FirebaseAuthRepository();

    protected void  onStart() {
        super.onStart();
        checkLoginStatus();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
    }

    private void checkLoginStatus() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        UserType userType = UserType.valueOf(sharedPreferences.getString("userType", "Student"));
        if (auth.getCurrentUser() != null) {
            Intent intent;
            switch (userType){
                case Faculty:
                    intent = new Intent(SplashActivity.this, FacultyViewActivity.class);
                    break;
                case Student:
                    intent = new Intent(SplashActivity.this, StudentViewActivity.class);
                    break;
                default:
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
            }
            startActivity(intent);
            finish();
        } else {
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }

}