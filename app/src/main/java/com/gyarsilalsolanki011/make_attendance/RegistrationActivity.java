package com.gyarsilalsolanki011.make_attendance;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.gyarsilalsolanki011.make_attendance.databinding.ActivityRegistrationBinding;

import java.util.ArrayList;
import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {
    ArrayList<String> arrDataList = new ArrayList<>();
    ActivityRegistrationBinding binding;
    private Boolean whoReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrDataList.add(Objects.requireNonNull(binding.editTextEmail.getText()).toString());
        arrDataList.add(Objects.requireNonNull(binding.editTextName.getText()).toString());
        arrDataList.add(Objects.requireNonNull(binding.editTextSubject.getText()).toString());
        arrDataList.add(Objects.requireNonNull(binding.editTextBranch.getText()).toString());
        arrDataList.add(Objects.requireNonNull(binding.editTextSemester.getText()).toString());

        whoReg = getIntent().getBooleanExtra("whoReg",true);

        if (whoReg) {
            binding.rollNo.setHint("Roll Number");
        }
        else {
            binding.rollNo.setHint("Subject");
        }

        binding.buttonRegister.setOnClickListener(
                v -> Register()
        );
    }

    private void Register() {
        if (whoReg) {
            Intent iStudentView = new Intent(RegistrationActivity.this, StudentViewActivity.class);
            startActivity(iStudentView);
        }
        else {
            Intent iFacultyView = new Intent(RegistrationActivity.this, FacultyViewActivity.class);
            startActivity(iFacultyView);
        }
    }

}