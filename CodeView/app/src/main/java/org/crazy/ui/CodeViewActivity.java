package org.crazy.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CodeViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new  LinearLayout(this);
        super.setContentView(layout);
        layout.setOrientation(LinearLayout.VERTICAL);

        final TextView textView = new TextView(this);
        Button button = new Button(this);
        button.setTextColor(Color.RED);
        button.setText(R.string.OK);
        button.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(textView);
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextColor(Color.GREEN);
                textView.setText("Hello Word " + new java.util.Date());
            }
        });
    }
}
