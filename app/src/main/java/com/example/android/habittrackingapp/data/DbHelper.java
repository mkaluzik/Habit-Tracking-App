package com.example.android.habittrackingapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittrackingapp.data.Contract.Entry;

/**
 * Created by martin on 23.7.17.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DbHelper.class.getSimpleName();

    /** NAME of Database file */
    private static final String DATABASE_NAME = "habits.db";

    /** Database Version */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link DbHelper}.
     *
     * @param context of the app
     */
    public DbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL STATEMENT
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + Entry.TABLE_NAME + " ("
                + Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Entry.COLUMN_DATE + " INTEGER NOT NULL,"
                + Entry.COLUMN_HABIT_NAME + " INTEGER NOT NULL DEFAULT 0,"
                + Entry.COLUMN_SUCCESS + " INTEGER NOT NULL DEFAULT 0);";

        //EXECUTE STATEMENT
        db.execSQL(SQL_CREATE_HABITS_TABLE);

    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }


    public void insertNewHabit(int date, int habit, int success) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.Entry.COLUMN_DATE, date);
        values.put(Contract.Entry.COLUMN_HABIT_NAME, habit);
        values.put(Contract.Entry.COLUMN_SUCCESS, success);
        db.insert(Contract.Entry.TABLE_NAME, null, values);
    }

    public Cursor readAllHabits() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Contract.Entry._ID,
                Contract.Entry.COLUMN_DATE,
                Contract.Entry.COLUMN_HABIT_NAME,
                Contract.Entry.COLUMN_SUCCESS
        };
        Cursor cursor = db.query(
                Contract.Entry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }
}