package org.crazyit.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView) findViewById(R.id.txt);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflator = new MenuInflater(this);

		inflator.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
		MenuInflater inflator = new MenuInflater(this);
		inflator.inflate(R.menu.context , menu);
        System.out.print("onCreateContextMenu");
		menu.setHeaderIcon(R.drawable.tools);
		menu.setHeaderTitle(" 背景颜色");
    }
    @Override
    public boolean onContextItemSelected(MenuItem menuItem){
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {
            case R.id.blue:
                textView.setBackgroundColor(Color.BLUE);
                menuItem.setChecked(true);
                break;
            case R.id.red:
                textView.setBackgroundColor(Color.RED);
                menuItem.setChecked(true);
                break;
            case  R.id.green:
                textView.setBackgroundColor(Color.GREEN);
                menuItem.setChecked(true);
                break;
        }
       // menuItem.setCheckable(true);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (item.isCheckable()) {
            item.setChecked(true);
        }

        int id = item.getItemId();
        switch (id) {
            case R.id.font_10:
                textView.setTextSize(10 * 2);
                break;
            case R.id.font_12:
                textView.setTextSize(12 * 2);
                break;
            case R.id.font_14:
                textView.setTextSize(14 * 2);
                break;
            case R.id.font_16:
                textView.setTextSize(16 * 2);
                break;
            case R.id.font_18:
                textView.setTextSize(18 * 2);
                break;

            case R.id.red_font:
                textView.setTextColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green_font:
                item.setChecked(true);
                textView.setTextColor(Color.GREEN);
                break;
            case R.id.blue_font:
                item.setChecked(true);
                textView.setTextColor(Color.BLUE);
                break;

            case R.id.plain_item:
                Toast.makeText(MainActivity.this, "Common Menu is Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        //noinspection SimplifiableIfStatement


        return true;
    }


}
