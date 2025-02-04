package com.bongoacademy.digitalmoneybag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "digital_moneybag", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE expense (id INTEGER PRIMARY KEY AUTOINCREMENT, amount DOUBLE, reason TEXT, time DOUBLE)");
        db.execSQL("CREATE TABLE income (id INTEGER PRIMARY KEY AUTOINCREMENT, amount DOUBLE, reason TEXT, time DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS expense");
        db.execSQL("DROP TABLE IF EXISTS income");
    }

    public void addExpense(double amount, String reason) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("amount", amount);
        values.put("reason", reason);
        values.put("time", System.currentTimeMillis());
        db.insert("expense", null, values);
    }

    public void addIncome(double amount, String reason) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("amount", amount);
        values.put("reason", reason);
        values.put("time", System.currentTimeMillis());
        db.insert("income", null, values);
    }

    //=====================================================================================================

    public double calculateTotalExpense() {

        double totalExpense = 0;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select *from expense", null);


        if (cursor != null && cursor.getCount()> 0) {
            while (cursor.moveToNext()) {
                double amount = cursor.getDouble(1);
                totalExpense += amount;
            }
        }

        return totalExpense;
    }



    //==============================================================================================

    public double calculateTotalIncome() {

        double total = 0;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select *from income", null);


        if (cursor != null && cursor.getCount()> 0) {

            while (cursor.moveToNext()) {
                double amount = cursor.getDouble(1);
                total += amount;
            }
        }

        return total;
    }

    //===========================================================================================
}
