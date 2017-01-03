package org.crazyit.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class MainActivity extends Activity {

    final static int MAX_PROGRESS = 100;

    private int[] data = new int[50];

    int progressStatus = 0;
    int hasData = 0;

    ProgressDialog progressDialog1;
    ProgressDialog progressDialog2;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg){
            if(msg.what == 0x123){
                progressDialog2.setProgress(progressStatus);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void  showSpinner(View source){
        ProgressDialog.show(this, "任务执行中",
                "请等待.....", false, true);
    }

    public void showIndeterminate(View source){
        progressDialog1 = new ProgressDialog(MainActivity.this);

        progressDialog1.setTitle("任务执行中");

        progressDialog1.setMessage("任务执行中，请等待....");

        progressDialog1.setCancelable(true);

        progressDialog1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressDialog1.setIndeterminate(true);

        progressDialog1.show();
    }

    public void showProgress(View source){

        progressStatus = 0;

        hasData = 0;

        progressDialog2 = new ProgressDialog(MainActivity.this);

        progressDialog2.setMax(MAX_PROGRESS);

        progressDialog2.setTitle("完成百分比");

        progressDialog2.setMessage("耗时任务的完成百分比");

        progressDialog2.setCancelable(false);

        progressDialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressDialog2.setIndeterminate(false);

        progressDialog2.show();

        new  Thread(){
            public void run(){
                while (progressStatus < MAX_PROGRESS){
                    progressStatus = MAX_PROGRESS
                            * doWork() / data.length;

                    handler.sendEmptyMessage(0x123);
                }

                if (progressStatus >= MAX_PROGRESS){
                    progressDialog2.dismiss();
                }
            }
        }.start();

    }

    public int  doWork(){
        data[hasData++] = (int) (Math.random() * 100);

        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

      return hasData;
    }
}
