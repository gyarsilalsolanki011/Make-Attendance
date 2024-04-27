package com.gyarsilalsolanki011.make_attendance.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.activities.adapter.RecyclerAttendanceViewAdapter;
import com.gyarsilalsolanki011.make_attendance.activities.modal.AttendanceViewModal;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityAttendanceViewBinding;

import java.util.ArrayList;
import java.util.Objects;

public class AttendanceViewActivity extends AppCompatActivity {
    ArrayList<AttendanceViewModal> arrayListAttendance;
    private ActivityAttendanceViewBinding binding;
    private final FirebaseFirestore database = FirebaseFirestore.getInstance();
    private  final FirebaseAuth Auth = FirebaseAuth.getInstance();
    RecyclerAttendanceViewAdapter adapter;
    String userid;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityAttendanceViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setOnRecyclerView();

        TextView classAttended1, classConducted1;
        binding.MachineLearning.setText(SubjectType.MachineLearning.toString());
        classAttended1 = findViewById(R.id.classes_attended1);
        classConducted1 = findViewById(R.id.classes_conducted1);

        setDataOnAttendanceViewActivity(SubjectType.MachineLearning.toString(), classAttended1, classConducted1);


        TextView  classAttended2, classConducted2;
        binding.ImageProcessing.setText(SubjectType.ImageProcessing.toString());
        classAttended2 = findViewById(R.id.classes_attended2);
        classConducted2 = findViewById(R.id.classes_conducted2);

        setDataOnAttendanceViewActivity(SubjectType.ImageProcessing.toString(), classAttended2, classConducted2);


        TextView  classAttended3, classConducted3;
        binding.MobileComputing.setText(SubjectType.MobileComputing.toString());
        classAttended3 = findViewById(R.id.classes_attended3);
        classConducted3 = findViewById(R.id.classes_conducted3);

        setDataOnAttendanceViewActivity(SubjectType.MobileComputing.toString(), classAttended3, classConducted3);


        TextView  classAttended4, classConducted4;
        binding.ComputerNetworking.setText(SubjectType.ComputerNetworking.toString());
        classAttended4 = findViewById(R.id.classes_attended4);
        classConducted4 = findViewById(R.id.classes_conducted4);

        setDataOnAttendanceViewActivity(SubjectType.ComputerNetworking.toString(), classAttended4, classConducted4);


        TextView  classAttended5, classConducted5;
        binding.SoftwareEngineering.setText(SubjectType.SoftwareEngineering.toString());
        classAttended5 = findViewById(R.id.classes_attended5);
        classConducted5 = findViewById(R.id.classes_conducted5);

        setDataOnAttendanceViewActivity(SubjectType.SoftwareEngineering.toString(), classAttended5, classConducted5);
    }


    private void setDataOnAttendanceViewActivity(String collection, TextView classAttended, TextView classConducted) {
        userid = Objects.requireNonNull(Auth.getCurrentUser()).getUid();
        DocumentReference documentReference = database.collection(collection).document(userid);
        documentReference.addSnapshotListener(this, (value, error) -> {
            if (error != null){
                Log.e("Firebase database error", Objects.requireNonNull(error.getMessage()));
                return;
            }

            assert value != null;
            classConducted.setText("  8");
            classAttended.setText("  4");

        });
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