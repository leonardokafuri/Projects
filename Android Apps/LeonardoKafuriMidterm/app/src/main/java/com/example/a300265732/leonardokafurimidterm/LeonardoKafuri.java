package com.example.a300265732.leonardokafurimidterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class LeonardoKafuri extends AppCompatActivity {

     int rlength, rwidth,amount,roomsize, tilearea;
     String selection;
     //created global variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leonardo_kafuri);
        final EditText roomwidth = findViewById(R.id.width);
        final EditText roomlength = findViewById(R.id.length);
        final Spinner group = findViewById(R.id.spinner);
        Button calculate = findViewById(R.id.findTiles);
        //indentify all the inputs and

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlength = Integer.parseInt(roomlength.getText().toString());
                rwidth = Integer.parseInt(roomwidth.getText().toString()); // getting the input by the user and setting to a int
                selection = group.getSelectedItem().toString(); // getting the spinner input
                if(selection.equals("12x12")) // if the tiles will be 12x12 do the follwing
                {

                    roomsize = (rlength*rwidth)/12;
                    tilearea = 12*12;
                    amount = roomsize / tilearea;

                    Intent i = new Intent(LeonardoKafuri.this,tiles.class); // creating a new intent to pass the value
                    i.putExtra("data",amount);// value set is data and passing the integer amount that will hold the amount of tiles needed
                    startActivity(i);// start 4th activity

                }else if(selection.equals("18x18")) // if the tilies will be 18x18 do the following
                {
                    roomsize = (rlength*rwidth)/12; // if 1 foot is 12 inches, get the area in feet and divide by 12?
                    tilearea = 18*18;
                    amount= roomsize / tilearea; // i wasnt complety sure how to apply the formula with inches and foot
                    Intent i = new Intent(LeonardoKafuri.this,tiles.class);
                    i.putExtra("data",amount);
                    startActivity(i);

                }


            }
        });

    }
}
