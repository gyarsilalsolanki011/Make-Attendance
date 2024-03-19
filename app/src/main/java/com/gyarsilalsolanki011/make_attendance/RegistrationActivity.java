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

import com.gyarsilalsolanki011.make_attendance.database.DatabaseManager;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {
    ArrayList<String> arrDataList = new ArrayList<>();
    Integer whoReg;
    EditText editText1, editText2, editText3, editText4, editText5;
    Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //id finding
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);

        arrDataList.add(editText1.getText().toString());
        arrDataList.add(editText2.getText().toString());
        arrDataList.add(editText3.getText().toString());
        arrDataList.add(editText4.getText().toString());
        arrDataList.add(editText5.getText().toString());

        regBtn = findViewById(R.id.regBtn);
        TextView stuFacTxt = findViewById(R.id.stu_fac_txt);
        whoReg = getIntent().getIntExtra("whoReg",1);

        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.addData(arrDataList, whoReg);

        if (whoReg==1) {
            stuFacTxt.setText("Roll No. :");
        }

        else {
            stuFacTxt.setText("Subject :");
        }

        regBtn.setOnClickListener(v -> {

            if (whoReg==1) {

                Intent iStudentView = new Intent(RegistrationActivity.this, StudentViewActivity.class);
                startActivity(iStudentView);

            }

            else {


                Intent iFacultyView = new Intent(RegistrationActivity.this, FacultyViewActivity.class);
                startActivity(iFacultyView);

            }
        });

    }
}