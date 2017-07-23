 package com.example.android.habittrackingapp;

 import android.database.Cursor;
 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.util.Log;

 import com.example.android.habittrackingapp.data.Contract;
 import com.example.android.habittrackingapp.data.DbHelper;

 import java.util.Date;
 import java.text.SimpleDateFormat;


 public class MainActivity extends AppCompatActivity {

     // this TAG will be used in logs for checks and debugging
     private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper DbHelper = new DbHelper(this);

        /** We are definitelly going to use Date to track our habits.
         *  so here I create Date object
         *  and on the second line we format the date to proper format
         */
        Date date = new Date();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
        String dateString = dateFormater.format(date);

        // Let's make sure we can save the date as integer using Integer.parseInt method
        int dateInt = Integer.parseInt(dateString);

        DbHelper.insertNewHabit(dateInt, Contract.Entry.HABIT_HEALTH,
                1);
        DbHelper.insertNewHabit(dateInt, Contract.Entry.HABIT_HYGIENE,
                1);
        DbHelper.insertNewHabit(dateInt, Contract.Entry.HABIT_LEARNING,
                1);
        Cursor cursor = DbHelper.readAllHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit number: " + cursor.getInt(0) + " with date " + cursor.getInt(1) +
                    " and activity number " + cursor.getInt(2) + " was (1/2 success/failure)  " + cursor.getString(3));
        }
    }
}
