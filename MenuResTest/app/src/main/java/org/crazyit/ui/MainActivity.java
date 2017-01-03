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
        MenuInflater inflater = new MenuInflater(this);

        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View source,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.context, menu);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("Choose BackgroundColor");
    }

    @Override
    public boolean onContextItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {
            case R.id.red:
                menuItem.setChecked(true);
                textView.setBackgroundColor(Color.RED);
                break;
            case R.id.blue:
                menuItem.setChecked(true);
                textView.setBackgroundColor(Color.BLUE);
                break;
            case R.id.green:
                menuItem.setChecked(true);
                textView.setBackgroundColor(Color.GREEN);
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.isCheckable()) {
            menuItem.setChecked(true);
        }
        switch (menuItem.getItemId()) {
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
                menuItem.setChecked(true);
                break;
            case R.id.green_font:
                textView.setTextColor(Color.GREEN);
                menuItem.setChecked(true);
                break;
            case R.id.blue_font:
                textView.setTextColor(Color.BLUE);
                menuItem.setChecked(true);
                break;

            case R.id.plain_item:
                Toast toast = Toast.makeText(MainActivity.this, "Clicked Common Menu", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }

        return true;
    }
}
