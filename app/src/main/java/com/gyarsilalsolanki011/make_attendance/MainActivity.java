package com.gyarsilalsolanki011.make_attendance;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button studentLoginBtn, facultyLoginBtn;
        LoginActivity obj = new LoginActivity();

        studentLoginBtn = findViewById(R.id.student_login_btn);
        facultyLoginBtn = findViewById(R.id.faculty_login_btn);

        studentLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iStudent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(iStudent);
                obj.StudentLogin();

            }
        });


        facultyLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iFaculty = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(iFaculty);
                obj.FacultyLogin();

            }
        });

    }
}