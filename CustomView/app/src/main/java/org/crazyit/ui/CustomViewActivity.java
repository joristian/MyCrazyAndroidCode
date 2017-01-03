package org.crazyit.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        LinearLayout main = (LinearLayout)findViewById(R.id.root);

        final DrawView drawView = new DrawView(this);
        drawView.setMinimumHeight(500);
        drawView.setMinimumWidth(300);
        main.addView(drawView);
    }
}
