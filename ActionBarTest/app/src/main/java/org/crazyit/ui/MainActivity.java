package org.crazyit.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        actionBar = getActionBar();

    }

    public void showActionBar(View source)
    {
        actionBar.show();
    }


    public void  hideActionBar(View source) {
        actionBar.hide();
    }
}
