package org.crazyit.ui;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TabHost tabHost =  getTabHost();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1")
                .setIndicator("Answered Call").setContent(R.id.tab01);

        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2")
                .setIndicator("Make Call", getResources().getDrawable(R.mipmap.ic_launcher))
                .setContent(R.id.tab02);

        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3")
                .setIndicator("missed Call")
                .setContent(R.id.tab03);

        tabHost.addTab(tab2);


    }
}
