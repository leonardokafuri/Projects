package com.example.a300265732.leonardokafurimidterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class tiles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiles);

        TextView result = findViewById(R.id.result);
        Intent intent = getIntent(); // get the intent that was passed to it
        if(intent!=null)
        {
            int tiles = intent.getIntExtra("data",0); // get the value that was passed
            result.setText("The number of tiles required are " + tiles); // setting the textview with the value
        }
    }
}
