package org.crazyit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends Activity {

    NumberPicker picker1, picker2;

    int minPrice = 25;
    int maxPrice = 75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        picker1 = (NumberPicker) findViewById(R.id.numberPicker);

        picker1.setMinValue(10);
        picker1.setMaxValue(50);
        picker1.setValue(minPrice);

        picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                minPrice = newValue;
                showSelectPrice();
            }
        });
        picker2 = (NumberPicker)findViewById(R.id.numberPicker2);
        picker2.setMinValue(60);
        picker2.setMaxValue(100);
        picker2.setValue(maxPrice);

        picker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                maxPrice = newValue;
                showSelectPrice();
            }
        });

    }

    private void  showSelectPrice(){
        Toast.makeText(this, "Your Chosed Min Price is " + minPrice
                +", Max Price is " + maxPrice,
                Toast.LENGTH_SHORT).show();
    }
}
