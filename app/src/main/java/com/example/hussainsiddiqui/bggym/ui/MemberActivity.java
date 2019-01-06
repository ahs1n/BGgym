package com.example.hussainsiddiqui.bggym.ui;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.hussainsiddiqui.bggym.R;
import com.example.hussainsiddiqui.bggym.contract.DataProvider;
import com.example.hussainsiddiqui.bggym.db.DatabaseHelper;

public class MemberActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    ListView listView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        listView = findViewById(R.id.member_list);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        cursor = databaseHelper.getData();
        listAdapter = new com.example.hussainsiddiqui.bggym.other.ListAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(listAdapter);

        if (cursor.moveToFirst()) {

            do {
                String name, email, cell;
                name = cursor.getString(0);
                email = cursor.getString(1);
                cell = cursor.getString(2);
                DataProvider dataProvider = new DataProvider(name, email, cell);
                listAdapter.equals(dataProvider);

            }
            while (cursor.moveToFirst());
        }

    }
}

