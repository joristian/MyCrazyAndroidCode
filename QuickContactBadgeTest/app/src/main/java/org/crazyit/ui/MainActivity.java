package org.crazyit.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {
    QuickContactBadge badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        badge = (QuickContactBadge)findViewById(R.id.badge);
        badge.assignContactFromPhone("020-888888", false);
    }
}
