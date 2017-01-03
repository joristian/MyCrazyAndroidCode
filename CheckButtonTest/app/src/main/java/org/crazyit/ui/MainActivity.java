package org.crazyit.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.rg);
        tx = (TextView)findViewById(R.id.show);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override

                public void onCheckedChanged(RadioGroup group, int checkedid){
                String tip = checkedid == R.id.male ? "You are Male!" : "You are Female!";
                tx.setText(tip);
            }

        });
    }
}
