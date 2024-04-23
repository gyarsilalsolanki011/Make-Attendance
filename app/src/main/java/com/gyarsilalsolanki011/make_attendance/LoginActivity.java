package com.gyarsilalsolanki011.make_attendance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.gyarsilalsolanki011.make_attendance.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {
    private Boolean whoLogin;
    private ActivityLoginBinding binding;
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


        //for login Activity
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
        if (whoLogin) {
            Intent iStudentView = new Intent(LoginActivity.this, StudentViewActivity.class);
            startActivity(iStudentView);
        }

        else {
            Intent iFacultyView = new Intent(LoginActivity.this, FacultyViewActivity.class);
            startActivity(iFacultyView);
        }
    }

}