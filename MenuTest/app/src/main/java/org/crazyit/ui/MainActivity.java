package org.crazyit.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    final int FONT_10 = 0x111;
    final int FONT_12 = 0x112;
    final int FONT_14 = 0x113;
    final int FONT_16 = 0x114;
    final int FONT_18 = 0x115;

    final int PLAIN_ITEM = 0x11b;
    final int FONT_RED = 0x116;
    final int FONT_BLUE = 0x117;
    final int FONT_GREEN = 0x118;

    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        editText = (EditText) findViewById(R.id.txt);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu fontmenu = menu.addSubMenu("Font Size");
        fontmenu.setIcon(R.drawable.font);
        fontmenu.setHeaderIcon(R.drawable.font);

        fontmenu.setHeaderTitle("Choose Font Size");
        fontmenu.add(0, FONT_10, 0, "Font 10");
        fontmenu.add(0, FONT_12, 0, "Font 12");
        fontmenu.add(0, FONT_14, 0, "Font 14");
        fontmenu.add(0, FONT_16, 0, "Font 16");
        fontmenu.add(0, FONT_18, 0, "Font 18");

        menu.add(0, PLAIN_ITEM, 0, "Common Menu");

        SubMenu colorMenu = menu.addSubMenu("Font Color");

        colorMenu.setIcon(R.drawable.color);
        colorMenu.setHeaderIcon(R.drawable.color);
        colorMenu.setHeaderTitle("Choose Color");
        colorMenu.add(0, FONT_RED, 0, "RED");
        colorMenu.add(0, FONT_BLUE, 0, "BLUE");
        colorMenu.add(0, FONT_GREEN, 0, "GREEN");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case FONT_10:
                editText.setTextSize(10 * 2);
                break;
            case FONT_12:
                editText.setTextSize(12 * 2);
                break;
            case FONT_14:
                editText.setTextSize(14 * 2);
                break;
            case FONT_16:
                editText.setTextSize(16 * 2);
                break;
            case FONT_18:
                editText.setTextSize(18 * 2);
                break;
            case FONT_RED:
                editText.setTextColor(Color.RED);
                break;
            case FONT_BLUE:
                editText.setTextColor(Color.BLUE);
                break;
            case FONT_GREEN:
                editText.setTextColor(Color.GREEN);
                break;

            case PLAIN_ITEM:
                Toast toast = Toast.makeText(MainActivity.this, "Click common Menu", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }
}
