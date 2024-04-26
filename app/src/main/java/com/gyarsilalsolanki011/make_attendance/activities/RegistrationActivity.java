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
import com.gyarsilalsolanki011.make_attendance.database.FirebaseUserRepository;
import com.gyarsilalsolanki011.make_attendance.database.modal.User;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityRegistrationBinding;

import java.util.ArrayList;
import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {
    private  ActivityRegistrationBinding binding;
    private Boolean whoReg;
    private final FirebaseAuthRepository auth = new FirebaseAuthRepository();
    private final FirebaseUserRepository user = new FirebaseUserRepository();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        whoReg = getIntent().getBooleanExtra("whoReg",true);

        binding.thenLogin.setOnClickListener(
                v -> {
                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
        );

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
        String fullName = Objects.requireNonNull(binding.editTextName.getText()).toString().trim();
        String branch = Objects.requireNonNull(binding.editTextBranch.getText()).toString().trim();
        String password = Objects.requireNonNull(binding.editTextPassword.getText()).toString().trim();
        String passwordConfirm = Objects.requireNonNull(binding.editTextPasswordConfirm.getText()).toString().trim();
        String sub_or_roll = Objects.requireNonNull(binding.editTextSubject.getText()).toString().trim();

        if (TextUtils.isEmpty(email)) {
            Snackbar.make(binding.getRoot(), "Email is required", Snackbar.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(fullName)) {
            Snackbar.make(binding.getRoot(), "Name is required", Snackbar.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Snackbar.make(binding.getRoot(), "Password is required", Snackbar.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(branch)){
            Snackbar.make(binding.getRoot(), "Branch is required", Snackbar.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(sub_or_roll)) {
            Snackbar.make(binding.getRoot(), "Roll Number is required", Snackbar.LENGTH_SHORT).show();
        } else {
                if (password.equals(passwordConfirm)) {
                    binding.progressIndicator.setVisibility(View.VISIBLE);
                    binding.buttonRegister.setVisibility(View.GONE);
                    Task<AuthResult> task = auth.register(email, password);
                    task.addOnSuccessListener(
                            result -> {
                                if (whoReg) {
                                    user.setStudentData(User.student(email, fullName, sub_or_roll, branch));
                                    user.setAttendanceData(User.Attendance(fullName, 0,0,0),SubjectType.MachineLearning.toString());
                                    user.setAttendanceData(User.Attendance(fullName, 0,0,0),SubjectType.ImageProcessing.toString());
                                    user.setAttendanceData(User.Attendance(fullName, 0,0,0),SubjectType.ComputerNetworking.toString());
                                    user.setAttendanceData(User.Attendance(fullName, 0,0,0),SubjectType.MobileComputing.toString());
                                    user.setAttendanceData(User.Attendance(fullName, 0,0,0),SubjectType.SoftwareEngineering.toString());
                                    Intent iStudentView = new Intent(RegistrationActivity.this, LoginActivity.class);
                                    startActivity(iStudentView);
                                }
                                else {
                                    user.setFacultyData(User.faculty(email, fullName, sub_or_roll, branch));
                                    Intent iFacultyView = new Intent(RegistrationActivity.this, LoginActivity.class);
                                    iFacultyView.putExtra("whoLogin",false);
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