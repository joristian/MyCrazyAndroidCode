package org.crazyit.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {

    TextSwitcher textSwitcher;
    String[] strs = new String[]{
            "Crazy IT JAVA",
            "JAVA EE",
            "Crazy Android",
            "Crazy XML"
    };

    int curStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textSwitcher = (TextSwitcher)findViewById(R.id.textSwitcher);

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(MainActivity.this);
                textView.setTextSize(40);
                textView.setTextColor(Color.MAGENTA);
                return textView;
            }
        });

        next(null);
    }

    public void  next(View v){

        textSwitcher.setText(strs[curStr++ % strs.length]);
    }
}
