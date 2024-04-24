package com.gyarsilalsolanki011.make_attendance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.gyarsilalsolanki011.make_attendance.auth.FirebaseAuthRepository;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityStudentViewBinding;

import java.util.Objects;

public class StudentViewActivity extends AppCompatActivity {
    private ActivityStudentViewBinding binding;
    private final FirebaseAuthRepository  auth = new FirebaseAuthRepository();
    private final FirebaseFirestore database = FirebaseFirestore.getInstance();
    private  final FirebaseAuth Auth = FirebaseAuth.getInstance();
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityStudentViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userId = Objects.requireNonNull(Auth.getCurrentUser()).getUid();
        DocumentReference documentReference = database.collection("students").document(userId);
        documentReference.addSnapshotListener(this, (value, error) -> {

            if (error != null){
                Log.e("DataBase error", Objects.requireNonNull(error.getMessage()));
                return;
            }

            assert value != null;
            binding.fullNameSet.setText(value.getString("fullName"));
            binding.emailSet.setText(value.getString("email"));
            binding.branchSet.setText(value.getString("branch"));
            binding.rollNoSet.setText(value.getString("rollNumber"));

        });

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