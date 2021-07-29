package com.shakibmansoori.sqlitedatabaseoperations;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText mCourseNameET, mCourseDuraET, mCourseTracksET, mCourseDescET;
    Button submitBtn, nextBtn;
    ListView listView;
    DbHandler mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCourseNameET = findViewById(R.id.etCourseName);
        mCourseDuraET = findViewById(R.id.etCourseDuration);
        mCourseTracksET = findViewById(R.id.etCourseTracks);
        mCourseDescET = findViewById(R.id.etCourseDesc);
        submitBtn = findViewById(R.id.submitBtn);
        nextBtn = findViewById(R.id.nextBtn);

        listView = findViewById(R.id.listView);



        StringBuilder builder = mDbHelper.readData();

        ArrayAdapter adapter


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cName = mCourseNameET.getText().toString();
                String cDuration = mCourseDuraET.getText().toString();
                String cTracks = mCourseTracksET.getText().toString();
                String cDesc = mCourseDescET.getText().toString();


                if (!(cName.isEmpty() && cDuration.isEmpty() && cTracks.isEmpty() && cDesc.isEmpty())) {

                    DbHandler dbHandler = new DbHandler(getApplicationContext());
                    dbHandler.addNewCourse(cName, cDuration, cTracks, cDesc);

                    Toast.makeText(MainActivity.this, cName + " Course SuccessFully Save", Toast.LENGTH_SHORT).show();

                    mCourseNameET.setText("");
                    mCourseDuraET.setText("");
                    mCourseTracksET.setText("");
                    mCourseDescET.setText("");

                    displayDatabaseInfo();

                } else {
                    Toast.makeText(MainActivity.this, "Fill All The Field", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }


    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new DbHandler(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        Cursor cursor = db.rawQuery("SELECT * FROM " + DbHandler.TABLE_NAME, null);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
//            TextView displayView = findViewById(R.id.textView);
//            displayView.setText("Number of rows in table: " + cursor.getCount());
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }


}