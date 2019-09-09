package com.example.mbashir1.chapter11app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    int intyear;
    float decloan;
    float decInterest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText years = findViewById(R.id.eTYears);
        final EditText loan = findViewById(R.id.eTLoan);
        final EditText interest = findViewById(R.id.eTIRate);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        Button button = findViewById(R.id.btnCal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intyear = Integer.parseInt(years.getText().toString());
                decloan = Float.parseFloat(loan.getText().toString());
                decInterest = Float.parseFloat(interest.getText().toString());

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1",intyear);
                editor.putFloat("key2",decloan);
                editor.putFloat("key3",decInterest);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });

    }
}
