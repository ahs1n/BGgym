package com.example.hussainsiddiqui.bggym.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hussainsiddiqui.bggym.R;
import com.example.hussainsiddiqui.bggym.db.DatabaseHelper;

public class Signup extends AppCompatActivity {
    Button _signup;
    EditText _txtfname, _txtemail, _txtpass, _txtrpass, _txtphone;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initializing();
        setListeners();
        setContentUI();

    }

    public void setContentUI() {

        // Initializing DB
        db = new DatabaseHelper(this);

    }

    public void initializing() {
        _signup = findViewById(R.id.s_signup);
        _txtfname = findViewById(R.id.s_fname);
        _txtemail = findViewById(R.id.s_email);
        _txtphone = findViewById(R.id.s_phone);
        _txtpass = findViewById(R.id.s_pass);
        _txtrpass = findViewById(R.id.s_rpass);
    }

    public void setListeners() {

        _signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = _txtfname.getText().toString();
                String email = _txtemail.getText().toString();
                String phone = _txtphone.getText().toString();
                String pass = _txtpass.getText().toString();
                String rpass = _txtrpass.getText().toString();

                if (db.checkEmailAlreadyExist(email)) {
                    Toast.makeText(Signup.this, "Email Address already exist!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Long id = db.insertdata(fname, email, Long.parseLong(phone), pass, rpass);
                if (id > 0) {
                    Toast.makeText(getApplicationContext(), "Signup Successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }

            }

        });

    }

    public void checkEmail(View v) {

    }

}
