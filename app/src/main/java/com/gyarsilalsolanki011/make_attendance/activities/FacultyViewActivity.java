package com.gyarsilalsolanki011.make_attendance.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.activities.modal.AttendanceModal;
import com.gyarsilalsolanki011.make_attendance.activities.adapter.RecyclerAttendaceAdapter;

import java.util.ArrayList;

public class FacultyViewActivity extends AppCompatActivity{
    ArrayList<AttendanceModal> arrAttends = new ArrayList<>();
    RecyclerAttendaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_faculty_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerAttendance);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //pre data
        arrAttends.add(new AttendanceModal("Shyam", 1,1));
        arrAttends.add(new AttendanceModal("Ram Kumar", 1,1));
        arrAttends.add(new AttendanceModal("Tiger", 1,1));
        arrAttends.add(new AttendanceModal("Karan", 1,1));
        arrAttends.add(new AttendanceModal("Shyam", 1,1));
        arrAttends.add(new AttendanceModal("Ram Kumar", 1,1));
        arrAttends.add(new AttendanceModal("Tiger", 1,1));
        arrAttends.add(new AttendanceModal("Karan", 1,1));

        adapter = new RecyclerAttendaceAdapter(this,arrAttends);
        recyclerView.setAdapter(adapter);
    }
}