package com.example.hussainsiddiqui.bggym.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hussainsiddiqui.bggym.R;
import com.example.hussainsiddiqui.bggym.contract.UserDataProvider;
import com.example.hussainsiddiqui.bggym.db.DatabaseHelper;

public class Registration extends AppCompatActivity {
    Button _submit;
    EditText _txtfname, _txtlname, _txtaddress, _txtemail, _txtphone;
    DatabaseHelper db;
    UserDataProvider userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        this.setTitle("Newly Registered Members");

        initialize();
        setListeners();
        setContentUI();
    }

    public void setContentUI() {

        // Initializing DB
        db = new DatabaseHelper(this);

        //get data from intent
        userData = (UserDataProvider) getIntent().getSerializableExtra("userInfo");
        _txtfname.setText(userData.getName());
        _txtemail.setText(userData.getEmail());
        _txtphone.setText(String.valueOf(userData.getCell_no()));

        this.setTitle("Register " + userData.getName().toUpperCase());

    }

    public void initialize() {
        _submit = findViewById(R.id.r_submit);
        _txtfname = findViewById(R.id.first_name);
        _txtlname = findViewById(R.id.last_name);
        _txtaddress = findViewById(R.id.addr);
        _txtemail = findViewById(R.id.email);
        _txtphone = findViewById(R.id.cellno);
    }

    public void setListeners() {

        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = _txtfname.getText().toString();
                String lname = _txtlname.getText().toString();
                String add = _txtaddress.getText().toString();
                String email = _txtemail.getText().toString();
                String phone = _txtphone.getText().toString();

                if (db.updateUserInfo(userData.getId(), fname)) {
                    Long id = db.insertdata(fname, lname, add, email, Long.parseLong(phone));
                    if (id != 0) {
                        Toast.makeText(getApplicationContext(), "Register successfully", Toast.LENGTH_LONG).show();

                        finish();
                        startActivity(new Intent(getApplicationContext(), MemberActivity.class));
                    }
                }

            }
        });
    }

}
