package com.example.a300265732.chapter5app;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        String [] attractions = {"Science World","UBC Museum","Stanley Park", "Capilano Bridge", "Canada Place"};

        setListAdapter(new ArrayAdapter<String>(MainActivity.this,R.layout.activity_main,R.id.travel,attractions));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        switch (position){
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.scienceworld.ca/")));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://moa.ubc.ca/")));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this,Stanley.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this,Capilano.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this,Canada.class));
                break;
        }

    }
}
