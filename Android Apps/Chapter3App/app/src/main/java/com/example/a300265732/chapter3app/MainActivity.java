package com.example.a300265732.chapter3app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costOfTicket = 99.99;
    double costOfTicket1 = 56.99;
    double CostOfTicket3 = 75.99;
    int NumOfTicket;
    double totalCost;
    String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tickets = (EditText)findViewById(R.id.num_ticktes);
        final Spinner group = (Spinner)findViewById(R.id.spinner);
        final TextView result = (TextView)findViewById(R.id.txtresult);
        Button button = (Button)findViewById(R.id.btn_cost);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumOfTicket = Integer.parseInt(tickets.getText().toString());
                selection = group.getSelectedItem().toString();
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                if(selection.equals("Concert 1"))
                {
                    totalCost = NumOfTicket * costOfTicket1;
                }
                if(selection.equals("Concert 2"))
                {
                    totalCost = NumOfTicket * costOfTicket;
                }
                else{
                    totalCost = NumOfTicket * CostOfTicket3;
                }
                //result.setText("The cost of tickets for "+ selection +" is " + currency.format(totalCost));
                Intent i = new Intent(MainActivity.this, Second.class);
                i.putExtra("data",totalCost);
                startActivity(i);

            }
        });

    }
}
