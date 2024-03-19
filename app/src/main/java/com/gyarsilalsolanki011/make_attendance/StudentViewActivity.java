package com.gyarsilalsolanki011.make_attendance;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentViewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name_set, rollNo_set, branch_set, sem_Set, email_set;
    AppCompatButton btn_attends_view, btn_notify_view;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.imageView);
        name_set = findViewById(R.id.name_set);
        rollNo_set = findViewById(R.id.rollNo_set);
        branch_set = findViewById(R.id.branch_set);
        sem_Set = findViewById(R.id.semester_set);
        email_set = findViewById(R.id.email_set);

        btn_attends_view = findViewById(R.id.btn_attendance_view);
        btn_notify_view = findViewById(R.id.btn_notification_view);

        btn_attends_view.setOnClickListener(v -> {

        });


        btn_notify_view.setOnClickListener(v -> Toast.makeText(StudentViewActivity.this, "Notification Integrated Soon..", Toast.LENGTH_SHORT).show());


    }
}