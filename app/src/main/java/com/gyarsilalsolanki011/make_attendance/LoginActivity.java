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


public class LoginActivity extends AppCompatActivity {

    TextView txtInput;
    Integer whoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText userName, passWord;
        Button loginBtn, registerBtn;

        txtInput = findViewById(R.id.txtInput);
        userName = findViewById(R.id.username_input);
        passWord = findViewById(R.id.password_input);
        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);
        whoLogin = getIntent().getIntExtra("whoLogin",1);

        if (whoLogin==1){
            txtInput.setText(R.string.login1);
        }
        else {
            txtInput.setText(R.string.login2);
        }


        //for login Activity
        loginBtn.setOnClickListener(v -> {

            if (whoLogin==1) {

                Intent iStudentView = new Intent(LoginActivity.this, StudentViewActivity.class);
                startActivity(iStudentView);

            }

            else {

                Intent iFacultyView = new Intent(LoginActivity.this, FacultyViewActivity.class);
                startActivity(iFacultyView);

            }
        });


        //for Registration Activity
        registerBtn.setOnClickListener(v -> {

            if (whoLogin==1) {

                Intent iStudentReg = new Intent(LoginActivity.this, RegistrationActivity.class);
                iStudentReg.putExtra("whoReg",1);
                startActivity(iStudentReg);

            }

            else {

                Intent iFacultyReg = new Intent(LoginActivity.this, RegistrationActivity.class);
                iFacultyReg.putExtra("whoReg",2);
                startActivity(iFacultyReg);

            }
        });
    }

}