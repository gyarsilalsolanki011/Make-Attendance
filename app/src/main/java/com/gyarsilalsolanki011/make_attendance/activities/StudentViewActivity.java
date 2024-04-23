package com.gyarsilalsolanki011.make_attendance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.gyarsilalsolanki011.make_attendance.auth.FirebaseAuthRepository;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityStudentViewBinding;

public class StudentViewActivity extends AppCompatActivity {
    private ActivityStudentViewBinding binding;
    private final FirebaseAuthRepository  auth = new FirebaseAuthRepository();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityStudentViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnAttendanceView.setOnClickListener(
                v -> {}
        );


        binding.btnNotificationView.setOnClickListener(
                v -> Toast.makeText(StudentViewActivity.this, "Notification Integrated Soon..", Toast.LENGTH_SHORT).show()
        );

        binding.logoutButton.setOnClickListener(
                v -> {
                    auth.logout();
                    Intent intent = new Intent(StudentViewActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
        );


    }
}