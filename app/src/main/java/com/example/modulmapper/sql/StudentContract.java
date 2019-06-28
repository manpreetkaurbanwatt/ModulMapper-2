package com.example.modulmapper.sql;

import android.provider.BaseColumns;

public class StudentContract {

    public static final class StudentEntry implements BaseColumns {

        public static final String TABLE_NAME = "addstudent";
        public static final String COLUMN_STUDENT_ID = "student_name";
        public static final String COLUMN_STUDENT_NAME = "student_id";
        public static final String COLUMN_STUDENT_EMAIL = "student_email";
        public static final String COLUMN_STUDENT_MAJOR = "student_major";
        public static final String COLUMN_STUDENT_PHONE  = "student_phone";
    }
}
