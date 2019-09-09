package com.example.a300265732.chapter3app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView result = (TextView)findViewById(R.id.txt_result);

        Intent intent = getIntent();
        if (intent != null){
            double data = intent.getDoubleExtra("data",0);
            result.setText("The data is " + data);
        }
    }
}
