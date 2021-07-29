package com.shakibmansoori.sqlitedatabaseoperations.Activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.shakibmansoori.sqlitedatabaseoperations.R;

import java.util.ArrayList;

public class ChannelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channels);


        ArrayList<Model> arrayList = new ArrayList<>();

        arrayList.add(new Model(R.drawable.ic_baseline_contacts, "Shakib MAnsoori", "Hii This is a Chennel"));
        arrayList.add(new Model(R.drawable.ic_baseline_contacts, "Shakib MAnsoori", "Hii This is a Chennel"));
        arrayList.add(new Model(R.drawable.ic_baseline_contacts, "Shakib MAnsoori", "Hii This is a Chennel"));
        arrayList.add(new Model(R.drawable.ic_baseline_contacts, "Shakib MAnsoori", "Hii This is a Chennel"));
        arrayList.add(new Model(R.drawable.ic_baseline_contacts, "Shakib MAnsoori", "Hii This is a Chennel"));

        ListView listView = findViewById(R.id.chennel_listview);

        Adapter adapter = new Adapter(this, arrayList);
        listView.setAdapter(adapter);


    }
}