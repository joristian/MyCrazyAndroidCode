package org.crazyit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private SearchView searchView;
    private ListView listView;
    private final  String[] mStrings = {"aaaa", "bbbbb", "ccccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = (ListView)findViewById(R.id.lv);
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mStrings));
        listView.setTextFilterEnabled(true);

        searchView = (SearchView)findViewById(R.id.sv);
//        searchView.setIconifiedByDefault(false);
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("Search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextChange(String newText) {
               if (TextUtils.isEmpty(newText)){
                   listView.clearTextFilter();
               }else {
                   listView.setFilterText(newText);
               }
                return true;
            }


            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(MainActivity.this, "Your choose is " + s,
                        Toast.LENGTH_SHORT).show();
                return  false;
            }
        });
    }
}
