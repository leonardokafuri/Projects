package com.example.a300265732.fragmentapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentThree extends Fragment {

    Button btn;
    int counter= 0;
    Comunicator com;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_three, container, false);
    }
    public void onActivityCreated(Bundle savedInstance) {
        super.onActivityCreated(savedInstance);
        com = (Comunicator)getActivity();
        btn = getActivity().findViewById(R.id.btnFrag3click);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                com.respond("You have clicked " + counter + " times");
            }
        });
    }


}
