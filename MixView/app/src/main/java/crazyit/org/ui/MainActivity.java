package crazyit.org.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int[] images = new int[]{
            R.drawable.java,
            R.drawable.ajax,
            R.drawable.html,
            R.drawable.javaee,
            R.drawable.swift, };

    int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LinearLayout main = (LinearLayout) findViewById(R.id.root);
        final ImageView image = new ImageView(this);
        main.setOrientation(LinearLayout.VERTICAL  );
//        main.setGravity(LinearLayout.TEXT_ALIGNMENT_CENTER);
        main.addView(image);
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(images[++currentImg % images.length]);
            }
        });

    }
}
