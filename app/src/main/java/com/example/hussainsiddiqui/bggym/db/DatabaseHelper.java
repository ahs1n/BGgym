package com.example.hussainsiddiqui.bggym.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + SIGNUP.TABLE_NAME + "(" +
                        SIGNUP.COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        SIGNUP.COL_2 + " TEXT," +
                        SIGNUP.COL_3 + " TEXT," +
                        SIGNUP.COL_4 + " LONG," +
                        SIGNUP.COL_5 + " TEXT," +
                        SIGNUP.COL_6 + " TEXT," +
                        SIGNUP.COL_7 + " BOOLEAN )"
        );

        db.execSQL(
                "CREATE TABLE " + REGISTER.TABLE_NAME + "(" +
                        REGISTER.COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        REGISTER.COL_2 + " TEXT," +
                        REGISTER.COL_3 + " TEXT," +
                        REGISTER.COL_4 + " TEXT," +
                        REGISTER.COL_5 + " TEXT," +
                        REGISTER.COL_6 + " INTEGER," +
                        REGISTER.COL_7 + " BOOLEAN )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SIGNUP.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SIGNUP.TABLE_NAME);
        onCreate(db);

    }

    public long insertdata(String fname, String email, long phone, String pass, String rpass) {
        SQLiteDatabase signdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SIGNUP.COL_2, fname);
        contentValues.put(SIGNUP.COL_3, email);
        contentValues.put(SIGNUP.COL_4, phone);
        contentValues.put(SIGNUP.COL_5, pass);
        contentValues.put(SIGNUP.COL_6, rpass);
        contentValues.put(SIGNUP.COL_7, false);
        long id = signdb.insert(SIGNUP.TABLE_NAME, null, contentValues);

        return id;

    }

    public long insertdata(String fname, String lname, String add, String email, long phone) {
        SQLiteDatabase regdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(REGISTER.COL_2, fname);
        contentValues.put(REGISTER.COL_3, lname);
        contentValues.put(REGISTER.COL_4, add);
        contentValues.put(REGISTER.COL_5, email);
        contentValues.put(REGISTER.COL_6, phone);
        contentValues.put(REGISTER.COL_7, false);
        long id = regdb.insert(DatabaseHelper.REGISTER.TABLE_NAME, null, contentValues);

        return id;
    }

    public boolean checkEmailAlreadyExist(String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Check if email exists
        Cursor res = db.rawQuery("SELECT * FROM " + SIGNUP.TABLE_NAME + " WHERE " + SIGNUP.COL_3 + " = ?", new String[]{email});
        return res.getCount() > 0;
    }

    public boolean login(String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Check if email exists
        Cursor res = db.rawQuery("SELECT * FROM " + SIGNUP.TABLE_NAME + " WHERE " + SIGNUP.COL_3 + " = ? and " + SIGNUP.COL_5 + " = ? ", new String[]{email, pass});
        return res.getCount() > 0;
    }

    public interface SIGNUP {
        String TABLE_NAME = "signup";
        String COL_1 = "ID";
        String COL_2 = "FullName";
        String COL_3 = "Email";
        String COL_4 = "Phone";
        String COL_5 = "Password";
        String COL_6 = "RetypePassword";
        String COL_7 = "Flag";
    }

    public interface REGISTER {
        String TABLE_NAME = "register";
        String COL_1 = "ID";
        String COL_2 = "FirstName";
        String COL_3 = "LastName";
        String COL_4 = "Address";
        String COL_5 = "Email";
        String COL_6 = "Phone";
        String COL_7 = "Flag";
    }
}
