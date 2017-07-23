package com.example.android.habittrackingapp.data;

import android.provider.BaseColumns;

/**
 * Created by martin on 23.7.17.
 */

public class Contract {


    // empty constructor
    private Contract() {}


    public class Entry implements BaseColumns {

        public final static String TABLE_NAME = "my_habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DATE = "date";
        public final static String COLUMN_HABIT_NAME = "habit_name";
        public final static String COLUMN_SUCCESS = "success";


        // possible values for COLUMN_SUCCESS
        public final static int HABIT_SUCCESS =  1;
        public final static int HABIT_FAILURE = 2;

        public final static int HABIT_HEALTH = 3;
        public final static int HABIT_HYGIENE = 4;
        public final static int HABIT_LEARNING = 5;
    }
}
