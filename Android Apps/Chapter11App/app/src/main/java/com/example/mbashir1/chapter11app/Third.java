package com.example.mbashir1.chapter11app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Third extends AppCompatActivity {

    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        final EditText text = findViewById(R.id.editText);
        final TextView output = findViewById(R.id.txtResult);
        Button buttonW = findViewById(R.id.btnW);
        Button buttonR = findViewById(R.id.btnR);

        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = text.getText().toString();
                try{
                    FileOutputStream fout = openFileOutput("File1.txt",MODE_APPEND);
                    fout.write(data.getBytes());
                    fout.write("\n".getBytes());
                    fout.close();
                    Toast.makeText(Third.this,"Data saved",Toast.LENGTH_LONG).show();

                }catch(Exception e)
                {
                    e.printStackTrace();

                }

            }
        });

        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fin = openFileInput("File1.txt");
                    String temp = "";
                    int c;
                    char ch;
                    while((c=fin.read()) != -1)
                    {
                        ch = (char) c;
                        temp += Character.toString(ch);

                    }
                    output.setText(temp);
                    fin.close();
                }catch (Exception e)
                {
                    e.printStackTrace();

                }
            }
        });


    }
}
