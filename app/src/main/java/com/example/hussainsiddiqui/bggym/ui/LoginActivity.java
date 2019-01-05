package com.example.hussainsiddiqui.bggym.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hussainsiddiqui.bggym.R;
import com.example.hussainsiddiqui.bggym.db.DatabaseHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper db;
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login, SignUp;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.user_name);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.lgn);
        SignUp = findViewById(R.id.signup);

        Login.setOnClickListener(this);
        SignUp.setOnClickListener(this);

    }

    private void validate(String userName, String userPassword) {
        db = new DatabaseHelper(this);
        if (userName.equals("admin") && userPassword.equals("1234")) {

            finish();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        } else if (db.login(Name.getText().toString(), Password.getText().toString())) {
            finish();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        } else {
            counter--;

            Toast.makeText(this, "No of attempts remaining: " + String.valueOf(counter), Toast.LENGTH_LONG).show();

            if (counter == 0) {
                Login.setEnabled(false);

            }
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.lgn) {
            validate(Name.getText().toString(), Password.getText().toString());
        } else if (v.getId() == R.id.signup) {
            startActivity(new Intent(this, Signup.class));
        }
    }

    public void log(View v) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}