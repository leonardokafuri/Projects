package com.example.mbashir1.databasemultipletablesapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentActivity extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        db =new DatabaseHelper(this);
        Button aButton = (Button) findViewById(R.id.btnAdd);
        Button hButton = (Button) findViewById(R.id.btnHm);
        final EditText fn = (EditText)findViewById(R.id.editTextFN);
        final EditText ln = (EditText) findViewById(R.id.editTextLN);
        final EditText cn = (EditText) findViewById(R.id.editTextCN);
        final EditText pi = (EditText) findViewById(R.id.editTextPId);

        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAdded= db.addRec(fn.getText().toString(),ln.getText().toString(),
                        cn.getText().toString(),pi.getText().toString());
                if(isAdded){
                    Toast.makeText(StudentActivity.this,"Data Added",Toast.LENGTH_LONG).show();
                    fn.setText("");
                    ln.setText("");
                    cn.setText("");
                    pi.setText("");
                }
                else{
                    Toast.makeText(StudentActivity.this,"Data not Added",Toast.LENGTH_LONG).show();
                }
            }
        });

        hButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentActivity.this,MainActivity.class));
            }

        });
    }
}
