package org.crazyit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by joris.tian on 2016/12/30.
 */

public class FirstActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        button.setText("Start Second Activity");
        button.setHeight(20);
        button.setWidth(10);
        setContentView(button);

        System.out.print("FirstActivity");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent =   new Intent(FirstActivity.this, SecondActivity.class);
             startActivity(intent);
            }
        });

    }
}
