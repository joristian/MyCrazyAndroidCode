package org.crazyit.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

        private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewFlipper = (ViewFlipper)findViewById(R.id.details);

    }

    public void prev(View v){
		viewFlipper.setInAnimation(this , android.R.anim.slide_in_left);
		viewFlipper.setOutAnimation(this , android.R.anim.slide_out_right);

        viewFlipper.showPrevious();
        viewFlipper.stopFlipping();
    }

    public void next(View v){
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);

        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);

        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }
    public void play(View v){
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
        viewFlipper.startFlipping();
    }
}
