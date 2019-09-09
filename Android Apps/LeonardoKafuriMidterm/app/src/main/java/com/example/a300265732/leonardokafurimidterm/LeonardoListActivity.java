package com.example.a300265732.leonardokafurimidterm;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeonardoListActivity extends ListActivity {
    // extend the class to List Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_leonardo_list);
        String [] tileOptions = {"Floor Tiling Calculator", "Floor Tiling Tips" ,"Floor Tiling Styles","Floor Tiling Sizes"};
        // have a array of strings for each of the options
        setListAdapter(new ArrayAdapter<String>(LeonardoListActivity.this,R.layout.activity_leonardo_list,R.id.tiling,tileOptions));
        //set an list adapter on the layout and on the textview that has a drawable left for the image
    }

    @Override
    protected void onListItemClick(ListView l , View v,int position,long id)
    {
        switch (position)
        {
            //set an on click listener for the listview
            //whenever the user clicks at some area, do a specific function
            case 0:
                startActivity(new Intent(LeonardoListActivity.this,LeonardoKafuri.class));
                // when go to calculator, start the 3rd activity
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://diy.com/")));
                // open an website for tips
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://pinterest.ca/")));
                //go to website for styles
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://homedepot.com/")));
                //go to webstite for sizes
                break;

        }


    }
}
