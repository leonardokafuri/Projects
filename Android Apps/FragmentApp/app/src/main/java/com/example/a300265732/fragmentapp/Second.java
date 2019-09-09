package com.example.a300265732.fragmentapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Second extends AppCompatActivity implements Comunicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void respond(String data) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentFour f4 = (FragmentFour)fm.findFragmentById(R.id.frag4);
        f4.changeTxt(data);
    }
}
