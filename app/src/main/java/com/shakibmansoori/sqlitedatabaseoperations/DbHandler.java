package com.shakibmansoori.sqlitedatabaseoperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;

    public static final String DB_NAME = "course_db";

    public static final String TABLE_NAME = "mycourses";

    public static final String _id = "id";

    public static final String _name = "name";

    public static final String _duration = "duration";

    public static final String _description = "desc";

    public static final String _tracks = "tracks";


    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + _id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + _name + " TEXT,"
                + _duration + " TEXT,"
                + _description + " TEXT,"
                + _tracks + " TEXT)";

        db.execSQL(query);
    }


    public void addNewCourse(String cName, String cDuration, String cTracks, String cDescrip) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(_name, cName);
        values.put(_duration, cDuration);
        values.put(_tracks, cTracks);
        values.put(_description, cDescrip);

        db.insert(TABLE_NAME, null, values);

        db.close();

    }


    public StringBuilder readData() {

        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {_id, _name, _duration, _description, _tracks};

        StringBuilder stringBuilder;

        Cursor cursor = db.query(
                TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        try {


            int current_id = cursor.getColumnIndex(_id);
            int current_name = cursor.getColumnIndex(_name);
            int current_dura = cursor.getColumnIndex(_duration);
            int current_track = cursor.getColumnIndex(_description);

            stringBuilder = new StringBuilder();
            while (cursor.moveToNext()) {

                int id = cursor.getInt(current_id);
                String name = cursor.getString(current_name);

                String str = "id " + id + " Name" + name + "\n";
                stringBuilder.append(str);


            }

        } finally {
            cursor.close();

        }

        return stringBuilder;

    }

    public void delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        // delete by id
        String selection = _id + "= ?";
        String[] selectionArgs = {id};
        db.delete(TABLE_NAME, selection, selectionArgs);

        db.close();
    }

    // by this mehtod we can update our data
    public void update(String name, String orijnalname) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(_name, name);

        // update by name
        String[] selectionArgs = {orijnalname};
        db.update(TABLE_NAME, values, _name + "=?", selectionArgs);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);

        onCreate(db);
    }
}
