package com.nexis.loginanimasyon;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextParams;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databaseyardimci extends SQLiteOpenHelper {

    public static final String databaseName = "Signup.db";

    public Databaseyardimci(@Nullable Context context) {
        super(context, "Signup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table kullanici (email TEXT primary key, sifre TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i2) {
        MyDatabase.execSQL("drop Table if exists kullanici");

    }
    public Boolean insertData(String email, String sifre){
        SQLiteDatabase MyDatabase= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("sifre", sifre);
        long result =MyDatabase.insert("kullanici", null,contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor= MyDatabase.rawQuery("Select * from kullanici where email = ?", new String[]{email});

        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkEmailSifre(String email, String sifre){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor= MyDatabase.rawQuery("Select * from kullanici where email = ? and sifre = ?", new String[]{email , sifre});

        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }

    }
}
