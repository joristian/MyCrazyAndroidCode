package org.crazyit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends Activity {

    int[] imageIds = new int[]
            {
                    R.drawable.shuangzi, R.drawable.shuangyu,
                    R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
                    R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
                    R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
                    R.drawable.mojie
            };
    private AdapterViewFlipper flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(imageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };

        flipper.setAdapter(adapter);
    }
    public void prev(View source){
        flipper.showPrevious();
        flipper.stopFlipping();
    }
    public void  next(View source){
        flipper.showNext();
        flipper.stopFlipping();
    }
    public void auto(View source){
        flipper.startFlipping();
    }
}
