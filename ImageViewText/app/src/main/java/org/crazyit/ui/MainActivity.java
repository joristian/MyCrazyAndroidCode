package org.crazyit.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int[] images = new int[]{
            R.drawable.lijiang,
            R.drawable.qiao,
            R.drawable.shuangta,
            R.drawable.shui,
            R.drawable.xiangbi
    };
    int currentImage = 2;
    private int alpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button plus = (Button) findViewById(R.id.plus);
        final Button minus = (Button) findViewById(R.id.minus);
        final ImageView imageFull = (ImageView) findViewById(R.id.imageViewFull);
        final ImageView imagePart = (ImageView) findViewById(R.id.imageViewPart);
        final Button next = (Button) findViewById(R.id.nextid);

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                    imageFull.setImageResource(
                            images[++currentImage % images.length]);
            }
        }
        );

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == plus) {
                    alpha += 20;
                }
                if (view == minus) {
                    alpha -= 20;
                }
                if (alpha >= 255) {
                    alpha = 255;
                }
                if (alpha <= 0) {
                    alpha = 0;
                }

                imageFull.setImageAlpha(alpha);
            }
        };

        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);

        imageFull.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageFull.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
				System.out.println(bitmap.getWidth());
				System.out.println(imageFull.getWidth());
                double scale = 1.0 * bitmap.getHeight() / imageFull.getHeight();
                int x = (int) (motionEvent.getX() * scale);
                int y = (int) (motionEvent.getY() * scale);

                if (x + 120 > bitmap.getWidth()) {
                    x = bitmap.getWidth() - 120;
                }
                if (y + 120 > bitmap.getHeight()) {
                    y = bitmap.getHeight() - 120;
                }
                imagePart.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));
                imagePart.setImageAlpha(alpha);
                return false;
            }
        });
    }
}
