package com.example.hussainsiddiqui.bggym.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hussainsiddiqui.bggym.contract.UserDataProvider;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + SIGNUP.TABLE_NAME + "(" +
                        SIGNUP.Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        SIGNUP.Name + " TEXT," +
                        SIGNUP.Email + " TEXT," +
                        SIGNUP.Cell_No + " LONG," +
                        SIGNUP.Password + " TEXT," +
                        SIGNUP.Retype_Pass + " TEXT," +
                        SIGNUP.COL_FLAG + " BOOLEAN )"
        );

        db.execSQL(
                "CREATE TABLE " + REGISTER.TABLE_NAME + "(" +
                        REGISTER.Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        REGISTER.First_Name + " TEXT," +
                        REGISTER.Last_Name + " TEXT," +
                        REGISTER.Address + " TEXT," +
                        REGISTER.Email + " TEXT," +
                        REGISTER.Cell_No + " LONG," +
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
        contentValues.put(SIGNUP.Name, fname);
        contentValues.put(SIGNUP.Email, email);
        contentValues.put(SIGNUP.Cell_No, phone);
        contentValues.put(SIGNUP.Password, pass);
        contentValues.put(SIGNUP.Retype_Pass, rpass);
        contentValues.put(SIGNUP.COL_FLAG, false);
        long id = signdb.insert(SIGNUP.TABLE_NAME, null, contentValues);

        return id;

    }

    public long insertdata(String fname, String lname, String add, String email, long phone) {
        SQLiteDatabase regdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(REGISTER.First_Name, fname);
        contentValues.put(REGISTER.Last_Name, lname);
        contentValues.put(REGISTER.Address, add);
        contentValues.put(REGISTER.Email, email);
        contentValues.put(REGISTER.Cell_No, phone);
        long id = regdb.insert(DatabaseHelper.REGISTER.TABLE_NAME, null, contentValues);

        return id;
    }

    public boolean checkEmailAlreadyExist(String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Check if email exists
        Cursor res = db.rawQuery("SELECT * FROM " + SIGNUP.TABLE_NAME + " WHERE " + SIGNUP.Email + " = ?", new String[]{email});
        return res.getCount() > 0;
    }

    public boolean login(String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Check if email exists
        Cursor res = db.rawQuery("SELECT * FROM " + SIGNUP.TABLE_NAME + " WHERE " + SIGNUP.Email + " = ? and " + SIGNUP.Password + " = ? ", new String[]{email, pass});
        return res.getCount() > 0;
    }

    public boolean updateUserInfo(int id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(SIGNUP.Name, name);
        values.put(SIGNUP.COL_FLAG, true);

// Which row to update, based on the ID
        String selection = SIGNUP.Id + " =?";
        String[] selectionArgs = {String.valueOf(id)};

        int count = db.update(SIGNUP.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count > 0;

    }

    /*Use for show reg member data*/
    public Cursor getData() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("Select * from " + SIGNUP.TABLE_NAME, null);
        return result;
    }

    /*Get All newly signup members*/
    public ArrayList<UserDataProvider> GetNewlyMembers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                SIGNUP.Id,
                SIGNUP.Name,
                SIGNUP.Email,
                SIGNUP.Cell_No,
                SIGNUP.COL_FLAG
        };
        String whereClause = SIGNUP.COL_FLAG + " =? ";
        String[] whereArgs = {"0"};
        String groupBy = null;
        String having = null;

        String orderBy = SIGNUP.Id + " ASC";

        ArrayList<UserDataProvider> allFC = new ArrayList<>();
        try {
            c = db.query(
                    SIGNUP.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                UserDataProvider fc = new UserDataProvider();
                fc.setId(c.getInt(c.getColumnIndex(SIGNUP.Id)));
                fc.setName(c.getString(c.getColumnIndex(SIGNUP.Name)));
                fc.setEmail(c.getString(c.getColumnIndex(SIGNUP.Email)));
                fc.setCell_no(c.getLong(c.getColumnIndex(SIGNUP.Cell_No)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public interface SIGNUP {
        String TABLE_NAME = "signup";
        String Id = "ID";
        String Name = "FullName";
        String Email = "Email";
        String Cell_No = "Phone";
        String Password = "Password";
        String Retype_Pass = "RetypePassword";
        String COL_FLAG = "Flag";
    }

    public interface REGISTER {
        String TABLE_NAME = "register";
        String Id = "ID";
        String First_Name = "FirstName";
        String Last_Name = "LastName";
        String Address = "Address";
        String Email = "Email";
        String Cell_No = "Phone";
        String COL_7 = "Flag";
    }

}
