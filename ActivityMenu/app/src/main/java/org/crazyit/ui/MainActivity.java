package org.crazyit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        SubMenu prog = menu.addSubMenu("Start Activity");

        prog.setHeaderIcon(R.drawable.tools);
        prog.setHeaderTitle("Choose Your Activity");

        MenuItem menuItem = prog.add("Check Java");
        menuItem.setIntent(new Intent(this, OtherActivity.class));

        return super.onCreateOptionsMenu(menu);
    }
}
