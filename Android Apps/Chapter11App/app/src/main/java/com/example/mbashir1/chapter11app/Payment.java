package com.example.mbashir1.chapter11app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView text = findViewById(R.id.txtMonthlyPayment);
        ImageView img = findViewById(R.id.imgYears);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        Button button = findViewById(R.id.btnThirdAct);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Payment.this , Third.class));
            }
        });


        int years = sp.getInt("key1",0);
        float loan = sp.getFloat("key2",0);
        float interest = sp.getFloat("key3",0);

        float monthlymPay, totalloan, totalInterest;
        totalInterest = (interest / (years +12)) * loan;
        totalloan = loan + totalInterest;
        monthlymPay = totalloan/(12*years);
        DecimalFormat df = new DecimalFormat("$###,###.##");
        text.setText("Monthly payment is " + df.format(monthlymPay));

        if(years == 3)
        {
            img.setImageResource(R.drawable.three);
        }else if(years ==4)
        {
            img.setImageResource(R.drawable.four);
        }
        else if(years ==5)
        {
            img.setImageResource(R.drawable.five);
        }else
            text.setText("Enter 3, 4 or 5 number of years");

    }
}
