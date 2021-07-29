package com.shakibmansoori.sqlitedatabaseoperations;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button viewBtn = findViewById(R.id.viewBtn);
        TextView itemsTv = findViewById(R.id.listOfitems);
        EditText editText = findViewById(R.id.idEditTv);
        EditText editText1 = findViewById(R.id.idEditTv1);


        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DbHandler db = new DbHandler(getApplicationContext());

                StringBuilder builder = db.readData();
                String listOfItems = builder.toString();

                String newName = editText.getText().toString();
                String newName1 = editText1.getText().toString();

                if (!newName.isEmpty()) {
                    db.update(newName, newName1);
                    itemsTv.setText(listOfItems);
                    Toast.makeText(MainActivity2.this, newName + " updated", Toast.LENGTH_SHORT).show();
                }
                {
                    Toast.makeText(MainActivity2.this, "not delete show only", Toast.LENGTH_SHORT).show();
                    itemsTv.setText(listOfItems);
                }


            }
        });
    }


}