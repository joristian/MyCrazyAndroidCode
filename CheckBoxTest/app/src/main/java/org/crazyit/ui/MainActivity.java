package org.crazyit.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    TextView txtShow;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button = (Button) findViewById(R.id.Time);
        txtShow = (TextView) findViewById(R.id.show);

        final Context context = MainActivity.this;
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          SimpleDateFormat formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日   HH:mm:ss");
                                          Date curDate =  new Date(System.currentTimeMillis());
                                          String str = formatter.format(curDate);
                                          txtShow.setText(str);
                                          long time = System.currentTimeMillis() + 1000 * 60 * 60 * 12;
                                          Intent intent = new Intent("com.sfexpress.setSystemTime");
                                          intent.putExtra("system_time", time);
                                          context.sendBroadcast(intent);
                                      }
                                  }
        );

    }
}
