package com.gyarsilalsolanki011.make_attendance.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.auth.FirebaseAuthRepository;
import com.gyarsilalsolanki011.make_attendance.databinding.ActivityLoginBinding;

import java.util.Objects;


public class LoginActivity extends AppCompatActivity {
    private Boolean whoLogin;
    private ActivityLoginBinding binding;
    private final FirebaseAuthRepository auth = new FirebaseAuthRepository();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        whoLogin = getIntent().getBooleanExtra("whoLogin",true);

        if (whoLogin){
            binding.txtInput.setText(R.string.login1);
        }
        else {
            binding.txtInput.setText(R.string.login2);
        }


        binding.loginBtn.setOnClickListener(
                v -> Login()
        );

        binding.registerBtn.setOnClickListener(
                v -> Register()
        );
    }

    private void Register() {
        if (whoLogin) {
            Intent iStudentReg = new Intent(LoginActivity.this, RegistrationActivity.class);
            iStudentReg.putExtra("whoReg",true);
            startActivity(iStudentReg);
        }

        else {
            Intent iFacultyReg = new Intent(LoginActivity.this, RegistrationActivity.class);
            iFacultyReg.putExtra("whoReg",false);
            startActivity(iFacultyReg);
        }
    }

    private void Login() {
        String email = Objects.requireNonNull(binding.editTextEmail.getText()).toString().trim();
        String password = Objects.requireNonNull(binding.editTextPassword.getText()).toString().trim();

        if (TextUtils.isEmpty(email)){
            Snackbar.make(binding.getRoot(),"Email is required", Snackbar.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(password)) {
            Snackbar.make(binding.getRoot(), "Password is required", Snackbar.LENGTH_SHORT).show();
        }else {
            binding.progressIndicator.setVisibility(View.VISIBLE);
            binding.loginBtn.setVisibility(View.GONE);

            Task<AuthResult> task = auth.login(email, password);
            task.addOnSuccessListener(authResult -> {
                checkUser();
                binding.progressIndicator.setVisibility(View.GONE);
                binding.loginBtn.setVisibility(View.VISIBLE);
            });
            task.addOnFailureListener(error -> {
                binding.progressIndicator.setVisibility(View.GONE);
                binding.loginBtn.setVisibility(View.VISIBLE);
                Log.d("AUTH", error.toString());
                Snackbar.make(binding.getRoot(), Objects.requireNonNull(error.getMessage()), Snackbar.LENGTH_SHORT).show();
            });

        }
    }

    private void checkUser() {
        if (auth.getCurrentUser() != null){
            if (whoLogin) {
                Intent iStudentView = new Intent(LoginActivity.this, StudentViewActivity.class);
                iStudentView.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(iStudentView);
            }

            else {
                Intent iFacultyView = new Intent(LoginActivity.this, FacultyViewActivity.class);
                iFacultyView.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(iFacultyView);
            }
        }
    }

}