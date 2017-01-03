package org.crazyit.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    ListView myList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myList = (ListView) findViewById(R.id.myList);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(0);

                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.mipmap.ic_launcher);

                TextView textView = new TextView(MainActivity.this);
                textView.setText("It" + (i+1)+ "Item");
                textView.setTextSize(20);
                
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setTextColor(Color.RED);
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }
        };

        myList.setAdapter(adapter);
    }
}
