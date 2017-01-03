package org.crazyit.auto_start;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        setContentView(R.layout.activity_main);
        new Thread(){
            public void run() {
                try {
                    sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
            }.start();

    }
    public class BootBroadcastReceiver extends BroadcastReceiver {
        static final String action_boot="android.intent.action.BOOT_COMPLETED";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(action_boot)){
                Intent ootStartIntent=new Intent(context,MainActivity.class);
                ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(ootStartIntent);
            }

        }

    }
}
