package org.crazyit.ui;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    static final int NOTIFICATION_ID = 0x123;
    NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }
    public void  send(View source){
        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        long[] vibrate = {0, 100, 150 ,200};
        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("New Mesaage")
                .setSmallIcon(R.drawable.notify)
                .setContentTitle("a new Message")
                .setContentText("You are the best")
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                //.setSound(Uri.parse("android.resource://org.crazyit.ui/"+R.raw.msg))

                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .build();

                notificationManager.notify(NOTIFICATION_ID,notification);
    }

    public void del(View source){
        notificationManager.cancel(NOTIFICATION_ID);
    }

}
