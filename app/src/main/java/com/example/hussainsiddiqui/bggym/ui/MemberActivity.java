package com.example.hussainsiddiqui.bggym.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hussainsiddiqui.bggym.R;
import com.example.hussainsiddiqui.bggym.contract.UserDataProvider;
import com.example.hussainsiddiqui.bggym.db.DatabaseHelper;
import com.example.hussainsiddiqui.bggym.other.CustomListAdapter;

import java.util.ArrayList;

public class MemberActivity extends AppCompatActivity {
    ListView listView;
    CustomListAdapter customListAdapter;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        this.setTitle("Newly Registered Members");

        listView = findViewById(R.id.member_list);

        db = new DatabaseHelper(this);

        try {
            ArrayList<UserDataProvider> userData = db.GetNewlyMembers();
            customListAdapter = new CustomListAdapter(this, android.R.layout.simple_list_item_1, userData);
            listView.setAdapter(customListAdapter);

        } catch (Exception ex) {
            Log.e("Fetch Users", ex.getMessage());
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }


}

