package org.crazyit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    StackView stackView;
    int[] imageIds = new int[]
            {
                    R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7,
                    R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10,
                    R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13,
                    R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        stackView = (StackView) findViewById(R.id.mStackView);

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems, R.layout.cell, new String[] {"image"},
        new int[] {R.id.imageView});

        stackView.setAdapter(simpleAdapter);

    }

    public  void  prev(View source){
        stackView.showPrevious();
    }
    public void  next(View source){
        stackView.showNext();
    }
}