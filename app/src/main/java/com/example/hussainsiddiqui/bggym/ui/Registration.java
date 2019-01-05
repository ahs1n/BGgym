package com.example.hussainsiddiqui.bggym.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hussainsiddiqui.bggym.R;
import com.example.hussainsiddiqui.bggym.db.DatabaseHelper;

public class Registration extends AppCompatActivity {
    Button _submit;
    EditText _txtfname, _txtlname, _txtaddress, _txtemail, _txtphone;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initialize();
        setListeners();
        setContentUI();
    }

    public void setContentUI() {

        // Initializing DB
        db = new DatabaseHelper(this);

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

                Long id = db.insertdata(fname, lname, add, email, Long.parseLong(phone));
                Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();

            }
        });
    }

}
