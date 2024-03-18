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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.gyarsilalsolanki011.make_attendance.modals.DataModal;

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

        studentLoginBtn = findViewById(R.id.student_login_btn);
        facultyLoginBtn = findViewById(R.id.faculty_login_btn);

        studentLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iStudentLogin = new Intent(MainActivity.this,LoginActivity.class);
                iStudentLogin.putExtra("whoLogin",1);
                startActivity(iStudentLogin);

            }
        });



        facultyLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iFacultyLogin = new Intent(MainActivity.this, LoginActivity.class);
                iFacultyLogin.putExtra("whoLogin",2);
                startActivity(iFacultyLogin);
            }
        });

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

    }
}