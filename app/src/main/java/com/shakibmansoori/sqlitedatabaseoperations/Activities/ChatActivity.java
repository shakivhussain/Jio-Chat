package com.shakibmansoori.sqlitedatabaseoperations.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.shakibmansoori.sqlitedatabaseoperations.MainActivity;
import com.shakibmansoori.sqlitedatabaseoperations.R;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        ArrayList<Model> arrayList = new ArrayList<Model>();

        arrayList.add(new Model(R.drawable.ic_baseline_arrow_back, "SHakib Mansoori", "Hii Bro"));
        arrayList.add(new Model(R.drawable.ic_baseline_arrow_back, "SHakib Mansoori", "Hii Bro"));
        arrayList.add(new Model(R.drawable.ic_baseline_arrow_back, "SHakib Mansoori", "Hii Bro"));
        arrayList.add(new Model(R.drawable.ic_baseline_arrow_back, "SHakib Mansoori", "Hii Bro"));
        arrayList.add(new Model(R.drawable.ic_baseline_arrow_back, "SHakib Mansoori", "Hii Bro"));


        ListView listView = findViewById(R.id.chatLv);

        Adapter adapter = new Adapter(this, arrayList);

        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ch_searchBtn:
                Toast.makeText(this, "Search Bar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ch_contact:
                startActivity(new Intent(getApplicationContext(), ChannelsActivity.class));
                Toast.makeText(this, "Contacts", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ch_brMsg:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                Toast.makeText(this, "BroadCast Msg", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ch_inviteFrnd:
                Toast.makeText(this, "Invite Frnds", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ch_scanQr:
                Toast.makeText(this, "Scan QR Code", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ch_ViewPr:
                Toast.makeText(this, "View Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ch_setting:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}