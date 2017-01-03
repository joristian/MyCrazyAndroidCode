package org.crazyit.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class MainActivity extends Activity {

    public static final int NUMBER_PER_SCREEN = 12;

    public static class DataItem {
        public String dataName;
        public Drawable drawable;
    }

    private ArrayList<DataItem> items = new ArrayList<DataItem>();

    private int screenNo = -1;

    private int screenCount;

    ViewSwitcher viewSwitcher;

    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        inflater = LayoutInflater.from(MainActivity.this);

        for (int i = 0; i < 40; i++) {
            String label = "" + i;
            Drawable drawable = getResources().getDrawable(
                    R.mipmap.ic_launcher);

            DataItem dataItem = new DataItem();
            dataItem.dataName = label;
            dataItem.drawable = drawable;
            items.add(dataItem);
        }

        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ?
                items.size() / NUMBER_PER_SCREEN :
                items.size() / NUMBER_PER_SCREEN + 1;

        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);

        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.slidelistview, null);
            }
        });

        next(null);
    }

    public void next(View v) {
        if (screenNo < screenCount - 1) {
            screenNo++;

            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
            viewSwitcher.setInAnimation(this, R.anim.slide_out_left);

            ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showNext();
        }
    }

    public void prev(View v){
        if (screenNo > 0 ){
            screenNo--;
            viewSwitcher.setInAnimation(this, R.anim.slide_out_left);
            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);

            ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);

            viewSwitcher.showPrevious();
        }
    }

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if(screenNo == screenCount -1 &&
                    items.size()% NUMBER_PER_SCREEN != 0){
                return items.size() % NUMBER_PER_SCREEN;
            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int i) {
            return items.get(screenNo * NUMBER_PER_SCREEN + i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View view = convertView;
            if(convertView == null){
                view = inflater.inflate(R.layout.labelicon, null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

            imageView.setImageDrawable(getItem(i).drawable);

            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText(getItem(i).dataName);
            return view;
        }
    };
}
