package com.example.a300265732.chapter7app;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int [] animals ={R.drawable.eagle,R.drawable.elephant,R.drawable.gorilla,R.drawable.panther,R.drawable.panda,R.drawable.polar};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = findViewById(R.id.gridview);
        final ImageView image = findViewById(R.id.image);

        grid.setAdapter(new ImageAdapater(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,"The selected animal is " + (position+1),Toast.LENGTH_SHORT).show();
                image.setImageResource(animals[position]);
            }
        });
    }
    private class ImageAdapater extends BaseAdapter {
        private Context context;
        public ImageAdapater(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return animals.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(animals[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }
}
