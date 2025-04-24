package com.example.sujansmiles.subjects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SqLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "subject_db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "subject_tbl";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_COLOR = "color";


    public SqLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * CREATE TABLE subject_tbl (
     * id INTEGER PRIMARY KEY AUTOINCREMENT,
     * name TEXT,
     * color INTEGER
     * )
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(\n" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                COLUMN_NAME + " TEXT,\n" +
                COLUMN_COLOR + " INTEGER )";

        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * CRUD Operation
     * C : Create
     * R: Red
     * U: Update
     * D: Delete
     */
    public void create(String name, int color) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_COLOR, color);

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    /**
     * SELECT * FROM <table-name>
     *
     * @return
     */
    public ArrayList<Subject> read() {
        ArrayList<Subject> subjects = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                int color = cursor.getInt(cursor.getColumnIndex(COLUMN_COLOR));

                Subject subject = new Subject(id, name, color);

                subjects.add(subject);

            } while (cursor.moveToNext());
        }

        return subjects;
    }

    public void update(int id, String name, int color) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_COLOR, color);

        db.update(
                TABLE_NAME,
                contentValues,
                COLUMN_ID + " = ?", new String[]{String.valueOf(id)}
        );

        db.close();
    }

    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " = ?", new String[]{String.valueOf(id)}
        );
        db.close();
    }
}
