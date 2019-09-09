package com.example.mbashir1.databasemultipletablesapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh = new DatabaseHelper(this);
        Button aButton = (Button)findViewById(R.id.btnAddStudent);
        Button pButton = (Button)findViewById(R.id.btnAddProvince);
        Button vButton = (Button)findViewById(R.id.buttonView);
        final TextView result = (TextView)findViewById(R.id.textViewR);

        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StudentActivity.class));
            }
        });

        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAdded = dbh.addRecProvince();
                if(isAdded){
                    Toast.makeText(MainActivity.this,"Data Added",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(MainActivity.this,"Data not Added",Toast.LENGTH_LONG).show();
                }
            }
        });

        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to view student records
                /*Cursor c = dbh.viewData();
                StringBuilder str = new StringBuilder();
                if(c.getCount()>0){
                    while (c.moveToNext()){
                        str.append("ID : " +c.getString(0));
                        str.append(" First Name : " +c.getString(1));
                        str.append(" Last Name : "+c.getString(2));
                        str.append(" Cell number : "+ c.getString(3));
                        str.append(" prov Id : " + c.getString(4));
                        str.append("\n");
                    }
                    result.setText(str);
                }
                else{
                    //display a toast message
                }*/

                //if you want to veiw province records
                /*Cursor c = dbh.viewProvinceRec();
                StringBuilder str = new StringBuilder();
                if(c.getCount()>0){
                    while (c.moveToNext()){
                        str.append("ID : " +c.getString(0));
                        str.append(" Prov Name : " +c.getString(1));

                        str.append("\n");
                    }
                    result.setText(str);
                }
                else{
                    //display a toast message
                }*/

                //to view combined records
                Cursor c = dbh.viewProvStudRec();
                StringBuilder str = new StringBuilder();
                if(c.getCount()>0){
                    while (c.moveToNext()){
                        str.append("ID : " +c.getString(0));
                        str.append(" First Name : " +c.getString(1));
                        str.append(" Prov id : " + c.getString(2));
                        str.append(" Prov Name : "+ c.getString(3));

                        str.append("\n");
                    }
                    result.setText(str);
                }
                else{
                    //display a toast message
                }

            }
        });
    }
}
