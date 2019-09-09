package com.example.mbashir1.chapter4app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double conversionRate = 2.2;
    double weight;
    double convertedWeight;
    String check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        /*EditText weightEntered = findViewById(R.id.eTWeight);
        RadioButton radLToK = findViewById(R.id.radLbsToKilo);
        RadioButton radKToLbs = findViewById(R.id.radKiloToLbs);
        Button button = findViewById(R.id.btnConvert);

        TextView result = findViewById(R.id.txtResult);
        CheckBox cBox = findViewById(R.id.cBDebetic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = Double.parseDouble(weightEntered.getText().
                        toString());
                if(cBox.isChecked()){
                    checked = "Diabetic patient";
                }
                else {
                    checked = "Not Diabetic patient";
                }
                DecimalFormat pattern = new DecimalFormat("#.#");
                if(radLToK.isChecked()){
                    if(weight<=500){
                        convertedWeight = weight/conversionRate;
                        result.setText(pattern.format(convertedWeight) + " Kgs " +
                                "and " + checked);
                    }
                    else{
                        Toast.makeText
                                (MainActivity.this,
                                        "Pounds should be less than 500",
                                        Toast.LENGTH_LONG
                                        ).show();
                    }

                }
                if(radKToLbs.isChecked()){
                    if(weight<=225){
                        convertedWeight = weight*conversionRate;
                        result.setText(pattern.format(convertedWeight) + " lbs and "
                                + checked);
                    }
                    else{
                        Toast.makeText
                                (MainActivity.this,
                                        "Kilogram should be less than 225",
                                        Toast.LENGTH_LONG
                                ).show();
                    }
                }
            }
        });*/

    }

    public void method(View view) {
        // Is the button now checked?
        EditText weightEntered = findViewById(R.id.eTWeight);
        RadioButton radLToK = findViewById(R.id.radLbsToKilo);
        RadioButton radKToLbs = findViewById(R.id.radKiloToLbs);
        Button button = findViewById(R.id.btnConvert);
        TextView result = findViewById(R.id.txtResult);
        CheckBox cBox = findViewById(R.id.cBDebetic);

        DecimalFormat pattern = new DecimalFormat("#.#");
        weight = Double.parseDouble(weightEntered.getText().
                toString());
        if(cBox.isChecked()){
            check = "Diabetic patient";
        }
        else {
            check = "Not Diabetic patient";
        }
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radLbsToKilo:
                if (checked){
                     if(weight<=500){
                        convertedWeight = weight/conversionRate;
                        result.setText(pattern.format(convertedWeight) + " Kgs " +
                                "and " + check);
                    }
                    else{
                        Toast.makeText
                                (MainActivity.this,
                                        "Pounds should be less than 500",
                                        Toast.LENGTH_LONG
                                ).show();
                    }
                }
                    break;
            case R.id.radKiloToLbs:
                if (checked){
                    if(weight<=225){
                        convertedWeight = weight*conversionRate;
                        result.setText(pattern.format(convertedWeight) + " lbs and "
                                + check);
                    }
                    else{
                        Toast.makeText
                                (MainActivity.this,
                                        "Kilogram should be less than 225",
                                        Toast.LENGTH_LONG
                                ).show();
                    }
                }

                    break;
        }
    }

}













