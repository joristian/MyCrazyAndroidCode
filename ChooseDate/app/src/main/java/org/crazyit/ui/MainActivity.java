package org.crazyit.ui;

import android.app.Activity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import java.util.Calendar;

import static android.Manifest.permission_group.CALENDAR;
import static android.R.attr.y;

public class MainActivity extends Activity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR);
        minute = cal.get(Calendar.MINUTE);


        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                MainActivity.this.year = year;
                MainActivity.this.day = month;
                MainActivity.this.month = day;
                showDate(year, month, day, hour, minute);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                MainActivity.this.hour = i;
                MainActivity.this.minute = i1                ;
            }
        });
    }

    private void showDate(int year, int month, int day, int hour, int minute) {
        EditText show = (EditText) findViewById(R.id.show);
        show.setText("Your Buying Date" + year + "年" + (month + 1) + '月' + day + "日" + hour + "小时" + +minute + "分");
    }
}
