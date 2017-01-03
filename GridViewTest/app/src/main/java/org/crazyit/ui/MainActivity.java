package org.crazyit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    GridView gridView;
    ImageView imageView;
    int[] imageIds = new int[]{
            R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7,
            R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10,
            R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13,
            R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();

        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("Image", imageIds[i]);
            listItems.add(listItem);
        }

        imageView = (ImageView) findViewById(R.id.imageView);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems,
                R.layout.cell,
                new String[]{"Image"},
                new int[]{R.id.image1});

        gridView = (GridView) findViewById(R.id.grid01);

        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                imageView.setImageResource(imageIds[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                imageView.setImageResource(imageIds[i]);
            }
        });
    }
}
