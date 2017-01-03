package org.crazyit.ui;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer chm;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        chm = (Chronometer) findViewById(R.id.testCHM);
        start = (Button)findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chm.setBase(SystemClock.elapsedRealtime());
                chm.start();
                start.setEnabled(false);
                start.setText("Stop");
            }
        });

        chm.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(SystemClock.elapsedRealtime() - chm.getBase() > 20 * 1000){
                    chm.stop();
                    start.setText("Start");
                    start.setEnabled(true);
                }
            }
        });
    }
}
