package com.example.multilayoutapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    EditText inputName, inputEmail, inputPhone;
    Button submitBtn, clearBtn;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPhone = findViewById(R.id.inputPhone);
        submitBtn = findViewById(R.id.submitBtn);
        clearBtn = findViewById(R.id.clearBtn);

        dbHelper = new DBHelper(this);

        submitBtn.setOnClickListener(v -> {
            String name = inputName.getText().toString();
            String email = inputEmail.getText().toString();
            String phone = inputPhone.getText().toString();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Toast.makeText(FormActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean inserted = dbHelper.insertStudent(name, email, phone);
                if (inserted) {
                    Toast.makeText(FormActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                    inputName.setText("");
                    inputEmail.setText("");
                    inputPhone.setText("");
                } else {
                    Toast.makeText(FormActivity.this, "Failed to Save", Toast.LENGTH_SHORT).show();
                }
            }

            //Log.d("DBPath", getDatabasePath("StudentDB").getAbsolutePath());


        });



        clearBtn.setOnClickListener(v -> {
            inputName.setText("");
            inputEmail.setText("");
            inputPhone.setText("");
        });
    }
}
