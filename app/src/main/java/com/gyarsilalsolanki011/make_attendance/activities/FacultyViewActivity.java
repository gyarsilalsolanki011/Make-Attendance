package com.gyarsilalsolanki011.make_attendance.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.activities.adapter.RecyclerAttendanceAdapter;
import com.gyarsilalsolanki011.make_attendance.activities.modal.AttendanceModal;
import com.gyarsilalsolanki011.make_attendance.auth.FirebaseAuthRepository;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityFacultyViewBinding;

import java.util.ArrayList;
import java.util.Objects;

public class FacultyViewActivity extends AppCompatActivity{
    ArrayList<AttendanceModal> arrAttends = new ArrayList<>();
    RecyclerAttendanceAdapter adapter;
    private final FirebaseAuthRepository auth = new FirebaseAuthRepository();
    private final FirebaseFirestore database = FirebaseFirestore.getInstance();
    private  final FirebaseAuth Auth = FirebaseAuth.getInstance();
    private ActivityFacultyViewBinding binding;
    ProgressDialog progressDialog;
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityFacultyViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.logoutButton.setOnClickListener(
                v -> {
                    auth.logout();
                    Intent intent = new Intent(FacultyViewActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
        );

        openProgressDialog();

        setDataOnActivityFacultyLayout();

        RecyclerView recyclerView = findViewById(R.id.recyclerAttendance);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrAttends.add(new AttendanceModal("Vijen Jatav", 0, 0,0));
        arrAttends.add(new AttendanceModal("Rajesh varkhade", 0, 0,0));
        arrAttends.add(new AttendanceModal("Gyarsilal Solanki", 0, 0,0));
        arrAttends.add(new AttendanceModal("Suresh Chouhan", 0, 0,0));
        arrAttends.add(new AttendanceModal("Mohan More", 0, 0,0));
        arrAttends.add(new AttendanceModal("Shyam More", 0, 0,0));
        arrAttends.add(new AttendanceModal("Suresh Raina", 0, 0,0));
        arrAttends.add(new AttendanceModal("Mohan Yadav", 0, 0,0));
        arrAttends.add(new AttendanceModal("Abhishek Porel", 0, 0,0));

        //setDataOnRecyclerViewLayout();

        adapter = new RecyclerAttendanceAdapter(this,arrAttends);
        recyclerView.setAdapter(adapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void setDataOnRecyclerViewLayout() {

        database.collection("Students")
                .orderBy("fullName", Query.Direction.ASCENDING)
                .addSnapshotListener((value, error) -> {
                    if (error != null){
                        if (progressDialog.isShowing()) progressDialog.dismiss();
                        Log.e("Firebase database error1", Objects.requireNonNull(error.getMessage()));
                        return;
                    }

                    assert value != null;
                    for (DocumentChange dc : value.getDocumentChanges()) {
                        if (dc.getType() == DocumentChange.Type.ADDED){

                            AttendanceModal modal = dc.getDocument().toObject(AttendanceModal.class);
                            arrAttends.add(modal);

                        }

                        adapter.notifyDataSetChanged();
                        if (progressDialog.isShowing()) progressDialog.dismiss();
                    }

                });
    }

    private void setDataOnActivityFacultyLayout() {

        userid = Objects.requireNonNull(Auth.getCurrentUser()).getUid();
        DocumentReference documentReference = database.collection("Faculties").document(userid);
        documentReference.addSnapshotListener(this, (value, error) -> {
            if (error != null){
                if (progressDialog.isShowing()) progressDialog.dismiss();
                Log.e("Firebase database error", Objects.requireNonNull(error.getMessage()));
                return;
            }

            assert value != null;
            binding.facultyNameSet.setText(value.getString("fullName"));
            binding.subjectSet.setText(value.getString("subject"));
            if (progressDialog.isShowing()) progressDialog.dismiss();

        });
    }

    private void openProgressDialog() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Fetching Data....");
        progressDialog.show();

    }
}