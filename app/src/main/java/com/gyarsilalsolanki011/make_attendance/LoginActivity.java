package com.gyarsilalsolanki011.make_attendance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.gyarsilalsolanki011.make_attendance.R;

public class LoginActivity extends AppCompatActivity {

    TextView txtInput;
    Boolean whoLogin;

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


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (whoLogin) {

                    Intent iStudentMain = new Intent(LoginActivity.this, StudentViewActivity.class);


                }

                else {

                    Intent iStudentMain = new Intent(LoginActivity.this, FacultyViewActivity.class);

                }
            }
        });


    }

    public void StudentLogin() {
        txtInput.setText(R.string.login1);
        whoLogin = Boolean.TRUE;
    }

    public void FacultyLogin() {
        txtInput.setText(R.string.login2);
        whoLogin = Boolean.FALSE;
    }

}