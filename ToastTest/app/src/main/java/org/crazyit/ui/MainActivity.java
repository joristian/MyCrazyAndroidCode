package org.crazyit.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button simple = (Button) findViewById(R.id.simple);

        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(MainActivity.this,
                        "Simple Toast Message", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        final Button test = (Button) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(MainActivity.this);

                toast.setGravity(Gravity.CENTER, 0, 0);

                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.tools);

                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.addView(imageView);

                TextView textView = new TextView(MainActivity.this);
                textView.setText("Toast Message with Image");
                textView.setTextSize(24);
                textView.setTextColor(Color.MAGENTA);
                textView.setGravity(Gravity.CENTER);

                linearLayout.addView(textView);

                toast.setView(linearLayout);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
