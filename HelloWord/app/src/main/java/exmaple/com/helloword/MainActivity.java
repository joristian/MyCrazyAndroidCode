package exmaple.com.helloword;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickHandler(View source){
        TextView textView = (TextView) findViewById(R.id.show);
        TextView lengthView = (TextView) findViewById(R.id.Length);
        textView.setTextColor(Color.RED);
        String Dsn = CommonUtil.getDSN();
        lengthView.setText(" Lenght " + Dsn.length());
        Dsn = Dsn.trim();
        textView.setText(" DSN " +  Dsn);

    }
}
