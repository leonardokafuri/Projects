package com.example.a300265732.inclassapp5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    String [] coffee = {"Blenz","Starbucks","Tim Hortons", "Waves", "Prado"};
    int [] images = new int[] { R.drawable.blenz, R.drawable.starbucks, R.drawable.timhortons,R.drawable.waveslogo,R.drawable.prado};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt", "Place : " + coffee[i]);
            hm.put("images", Integer.toString(images[i]));
            aList.add(hm);
        }

        String[] from = { "images","txt"}; // Keys used in Hashmap
        int[] to = { R.id.image,R.id.travel}; // Ids of views in listview_layout

    // Instantiating an adapter to store each items
    // R.layout.listview_layout defines the layout of each item
    SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.layout, from, to);

    // Getting a reference to listview of activity_main.xml layout file
    ListView listView = ( ListView ) findViewById(R.id.listview);

    // Setting the adapter to the listView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this,Blenz.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,Starbucks.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,TimHortons.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this,Waves.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this,Prado.class));
                        break;
                }
            }
        });





    }
    }

