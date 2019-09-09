package com.example.a300265732.fragmentapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentFour extends Fragment {

    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_four, container, false);
    }

    public void onActivityCreated(Bundle savedInstance) {
        super.onActivityCreated(savedInstance);
        tv =(TextView)getActivity().findViewById(R.id.output);
    }
    public void changeTxt(String data)
    {
        tv.setText(data);
    }

}
