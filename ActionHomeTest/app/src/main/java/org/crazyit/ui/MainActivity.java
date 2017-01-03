package org.crazyit.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import static org.crazyit.ui.R.id.txt;

public class MainActivity extends Activity {

    private TextView textView;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView) findViewById(txt);

        actionBar = getActionBar();

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.isCheckable()) {
            item.setChecked(true);
        }

        switch (item.getItemId()) {

            case android.R.id.home:
                Intent intent = new Intent(this, FirstActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.f_10:
                textView.setTextSize(10 * 2);
                break;
            case R.id.f_12:
                textView.setTextSize(12 * 2);
                break;
            case R.id.f_14:
                textView.setTextSize(14 * 2);
                break;
            case R.id.f_16:
                textView.setTextSize(16 * 2);
                break;
            case R.id.f_18:
                textView.setTextSize(18 * 2);
                break;
			case R.id.red:
				textView.setTextColor(Color.RED);
                item.setChecked(true);
				break;
			case R.id.green:
				textView.setTextColor(Color.GREEN);
                item.setChecked(true);
				break;
			case R.id.blue:
				textView.setTextColor(Color.BLUE);
				item.setChecked(true);
				break;
        }
        return true;
    }
}
