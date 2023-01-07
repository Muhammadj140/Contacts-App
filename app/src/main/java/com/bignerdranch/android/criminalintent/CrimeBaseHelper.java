package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import database.CrimeDbSchema.CrimeTable;

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimebase.db";

    public CrimeBaseHelper(Context context)
    { super(context, DATABASE_NAME, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CrimeTable.NAME +
                "(" + "_id integer primary key autoincrement," +
                CrimeTable.Cols.UUID + ", " +
                CrimeTable.Cols.PERSONNAME + ", " +
                CrimeTable.Cols.NUMBER + ", " +
                CrimeTable.Cols.SOLVED + ", "+
                CrimeTable.Cols.DATE + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


