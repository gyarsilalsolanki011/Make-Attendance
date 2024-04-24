package com.gyarsilalsolanki011.make_attendance.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.activities.modal.AttendanceModal;
import com.gyarsilalsolanki011.make_attendance.activities.adapter.RecyclerAttendaceAdapter;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityFacultyViewBinding;

import java.util.ArrayList;
import java.util.Objects;

public class FacultyViewActivity extends AppCompatActivity{
    ArrayList<AttendanceModal> arrAttends = new ArrayList<>();
    RecyclerAttendaceAdapter adapter;
    private final FirebaseFirestore database = FirebaseFirestore.getInstance();
    private  final FirebaseAuth auth = FirebaseAuth.getInstance();
    private ActivityFacultyViewBinding binding;
    ProgressDialog progressDialog;
    String whichSubject, userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityFacultyViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Fetching Data....");
        progressDialog.show();

        userid = Objects.requireNonNull(auth.getCurrentUser()).getUid();
        DocumentReference documentReference = database.collection("faculties").document(userid);
        documentReference.addSnapshotListener(this, (value, error) -> {
            if (error != null){
                Log.e("Firebase database error", Objects.requireNonNull(error.getMessage()));
                return;
            }

            assert value != null;
            whichSubject = value.getString("subject");
            binding.facultyNameSet.setText(value.getString("fullName"));
            binding.subjectSet.setText(whichSubject);

        });

        RecyclerView recyclerView = findViewById(R.id.recyclerAttendance);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAttendaceAdapter(this,arrAttends);
        recyclerView.setAdapter(adapter);

        eventChangeAddedListener();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void eventChangeAddedListener() {

        database.collection("mathematics").orderBy("fullName", Query.Direction.ASCENDING)
                .addSnapshotListener(this, (value, error) -> {

                    if (error != null) {

                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Log.e("Database Error", Objects.requireNonNull(error.getMessage()));
                        return;
                    }

                    assert value != null;
                    for (DocumentChange dc : value.getDocumentChanges()) {

                        arrAttends.add(dc.getDocument().toObject(AttendanceModal.class));

                    }

                    adapter.notifyDataSetChanged();
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                });
    }
}