package com.gyarsilalsolanki011.make_attendance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.gyarsilalsolanki011.make_attendance.auth.FirebaseAuthRepository;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityRegistrationBinding;

import java.util.ArrayList;
import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {
    ArrayList<String> arrDataList = new ArrayList<>();
    private  ActivityRegistrationBinding binding;
    private Boolean whoReg;
    private FirebaseAuthRepository auth = new FirebaseAuthRepository();
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

        whoReg = getIntent().getBooleanExtra("whoReg",true);

        if (whoReg) {
            binding.rollNo.setHint("Roll Number");
        }
        else {
            binding.rollNo.setHint("Subject");
        }

        binding.buttonRegister.setOnClickListener(
                v -> CreateUser()
        );
    }

    private void CreateUser() {
        String email = Objects.requireNonNull(binding.editTextEmail.getText()).toString().trim();
        String Name = Objects.requireNonNull(binding.editTextName.getText()).toString().trim();
        String password = Objects.requireNonNull(binding.editTextPassword.getText()).toString().trim();
        String passwordConfirm = Objects.requireNonNull(binding.editTextPasswordConfirm.getText()).toString().trim();

        if (TextUtils.isEmpty(email)) {
            Snackbar.make(binding.getRoot(), "Email is required", Snackbar.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(Name)) {
            Snackbar.make(binding.getRoot(), "Name is required", Snackbar.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Snackbar.make(binding.getRoot(), "Password is required", Snackbar.LENGTH_SHORT).show();
        } else {
            if (password.equals(passwordConfirm)) {
                binding.progressIndicator.setVisibility(View.VISIBLE);
                binding.buttonRegister.setVisibility(View.VISIBLE);
                Task<AuthResult> task = auth.register(email, password);
                task.addOnSuccessListener(
                        result -> {
                            if (whoReg) {
                                Intent iStudentView = new Intent(RegistrationActivity.this, StudentViewActivity.class);
                                startActivity(iStudentView);
                            }
                            else {
                                Intent iFacultyView = new Intent(RegistrationActivity.this, FacultyViewActivity.class);
                                startActivity(iFacultyView);
                            }
                        });

                task.addOnFailureListener(
                        error ->{
                            binding.progressIndicator.setVisibility(View.GONE);
                            binding.buttonRegister.setVisibility(View.VISIBLE);
                            Snackbar.make(binding.getRoot(), Objects.requireNonNull(error.getMessage()), Snackbar.LENGTH_SHORT).show();
                        });
            }else {
                Snackbar.make(binding.getRoot(), "Confirm password did not match", Snackbar.LENGTH_SHORT).show();
            }
        }

    }

}