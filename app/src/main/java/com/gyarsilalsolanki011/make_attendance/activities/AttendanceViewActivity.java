package com.gyarsilalsolanki011.make_attendance.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.gyarsilalsolanki011.make_attendance.activities.modal.AttendanceViewModal;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityAttendanceViewBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class AttendanceViewActivity extends AppCompatActivity {
    ArrayList<AttendanceViewModal> arrayListAttendance;
    public ArrayList<SubjectType> subjectList;
    private ActivityAttendanceViewBinding binding;
    private final FirebaseFirestore database = FirebaseFirestore.getInstance();
    private  final FirebaseAuth Auth = FirebaseAuth.getInstance();

    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityAttendanceViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        subjectList.add(SubjectType.Mathematics);
        subjectList.add(SubjectType.ImageProcessing);

    }
}