package com.example.statetechlist;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] attraction={"State Tech", "Campus Life", "Schedule a Visit",
                "Weight Room", "Overhead View", "Main Entrance"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main,
                R.id.state, attraction));
    }

    @Override
    protected void onListItemClick(ListView listView, View v, int position, long id) {
        switch(position) {
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://statetechmo.edu")));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://statetechmo.edu/campus-life/")));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://statetechmo.edu/contact-admissions/schedule-visit/")));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, weightRoom.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, overhead.class));
                break;
            case 5:
                startActivity(new Intent(MainActivity.this, entrance.class));
                break;
        }
    }
}