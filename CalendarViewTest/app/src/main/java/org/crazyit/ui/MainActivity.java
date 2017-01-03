package org.crazyit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends Activity {
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                System.out.println("Toast.show");

                Toast.makeText(MainActivity.this,
                        "Your BirthDay is " + year + "Year" + month + "Month" + day + "Day",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }
}
