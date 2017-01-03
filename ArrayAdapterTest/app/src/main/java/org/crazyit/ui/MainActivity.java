package org.crazyit.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView1 = (ListView) findViewById(R.id.listView);
        String[] arr1 = {"Modey",
                "Dog",
                "Cat",
                "Fish"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.array_item,arr1);
        listView1.setAdapter(adapter);

        ListView listView2 = (ListView) findViewById(R.id.listView2);
        String[] arr2 = {"JAVA",
                "Android",
                "XML",
                "C++"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.checked_item,arr2);
        listView2.setAdapter(adapter2);
    }
}
