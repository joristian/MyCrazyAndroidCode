package org.crazyit.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView show;
    String[] items = new String[]{
            "疯狂Java讲义",
            "疯狂Ajaxj讲义",
            "疯狂Java EE讲义",
            "疯狂Android讲义"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        show = (TextView) findViewById(R.id.show);
    }

    public void simple(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Simple Diag");

        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Diag Test Content \n Second line");
        setPositiveButton(builder);
        setNegativeButton(builder);

        builder.create().show();


    }

    public void simpleList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Simple List Diag");
        builder.setIcon(R.drawable.tools);

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                show.setText(" You click " + items[i]);
            }
        });

        setPositiveButton(builder);
        setNegativeButton(builder);

        builder.create();
        builder.show();


    }

    public void singleChoice(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Single Choice");
        builder.setIcon(R.drawable.tools);
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                show.setText("You choose " + items[i]);
            }
        });

        setNegativeButton(builder);
        setPositiveButton(builder);
        builder.create().show();
    }

    public void multiChoice(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Multi Choice Diag")
                .setIcon(R.drawable.tools)
                .setMultiChoiceItems(items,
                        new boolean[]{false, true, false, false}, null);

        setNegativeButton(builder);
        setPositiveButton(builder).create().show();
    }

    public void customList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Custom List Diag");
        builder.setIcon(R.drawable.tools);
        builder.setAdapter(new ArrayAdapter<String>(this,
                R.layout.array_item, items), null);
        setNegativeButton(builder);
        setPositiveButton(builder);

        builder.create().show();
    }

    public void customView(View view){
        TableLayout loginForm = (TableLayout) getLayoutInflater()
                .inflate(R.layout.login, null);

        new  AlertDialog.Builder(this)
                .setTitle("Custom View Diag")
                .setIcon(R.drawable.tools)
                .setView(loginForm)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create()
                .show();
    }



    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        return builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                show.setText(" Click Confirm Button");
            }
        });
    }

    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        return builder.setNegativeButton("Cancl", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                show.setText(" Click Cancel Button");
            }
        });
    }


}

