package com.example.a300265732.databaseapp;

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

        final EditText fname = findViewById(R.id.fname);
        final EditText lname = findViewById(R.id.lname);
        final EditText cell = findViewById(R.id.phone);
        final TextView output = findViewById(R.id.result);
        final EditText id = findViewById(R.id.id);

        Button aButton = findViewById(R.id.abtn);
        Button vButton = findViewById(R.id.vbtn);
        Button dButton = findViewById(R.id.dbtn);
        Button uButton = findViewById(R.id.ubtn);


        aButton.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View v) {
                isInserted = dbh.addRecord(fname.getText().toString(),lname.getText().toString(),cell.getText().toString());

                if(isInserted)
                {
                    Toast.makeText(MainActivity.this,"Data added successfully",Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(MainActivity.this,"Data not added",Toast.LENGTH_LONG).show();

                }
            }
        });

        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = dbh.viewdata();
                StringBuilder str = new StringBuilder();
                if(c.getCount()>0)
                {
                    while(c.moveToNext()){
                        str.append("ID : "+ c.getString(0));
                        str.append(" Fname : "+ c.getString(1));
                        str.append(" Lname : "+ c.getString(2));
                        str.append(" Cellphone : "+ c.getString(3));
                        str.append("\n");
                    }
                    output.setText(str);
                }
            }
        });

        dButton.setOnClickListener(new View.OnClickListener() {
            boolean isDeleted;
            @Override
            public void onClick(View v) {
                int intid = Integer.parseInt(id.getText().toString());
                isDeleted = dbh.delRec(intid);
                if(isDeleted)
                {
                    Toast.makeText(MainActivity.this,"Record Deleted",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(MainActivity.this," No record found to delete",Toast.LENGTH_LONG).show();
                }
            }
        });

        uButton.setOnClickListener(new View.OnClickListener() {
            boolean isupdated;
            @Override
            public void onClick(View v) {
                int intid = Integer.parseInt(id.getText().toString());
                isupdated= dbh.updateRec(intid,"77777");
                if(isupdated)
                {
                    Toast.makeText(MainActivity.this,"Record Updated",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"No record found to update",Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}
