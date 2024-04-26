package com.gyarsilalsolanki011.make_attendance.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.activities.adapter.RecyclerAttendanceViewAdapter;
import com.gyarsilalsolanki011.make_attendance.activities.modal.AttendanceViewModal;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityAttendanceViewBinding;

import java.util.ArrayList;

public class AttendanceViewActivity extends AppCompatActivity {
    ArrayList<AttendanceViewModal> arrayListAttendance;
    private ActivityAttendanceViewBinding binding;
    private final FirebaseFirestore database = FirebaseFirestore.getInstance();
    private  final FirebaseAuth Auth = FirebaseAuth.getInstance();
    RecyclerAttendanceViewAdapter adapter;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityAttendanceViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setOnRecyclerView();

    }

    public void setOnRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recyclerViewAttendance);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayListAttendance.add(new AttendanceViewModal("Maths",1,1));
        arrayListAttendance.add(new AttendanceViewModal("Maths",1,1));
        arrayListAttendance.add(new AttendanceViewModal("Maths",1,1));
        arrayListAttendance.add(new AttendanceViewModal("Maths",1,1));
        arrayListAttendance.add(new AttendanceViewModal("Maths",1,1));
        arrayListAttendance.add(new AttendanceViewModal("Maths",1,1));

        adapter = new RecyclerAttendanceViewAdapter(this, arrayListAttendance);
        recyclerView.setAdapter(adapter);
    }

}