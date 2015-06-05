package com.prueba.app.appprueba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

//import java.util.logging.Handler;

/**
 * Created by roxana on 02/06/15.
 */
public class DialogActivity extends Activity {

    final CharSequence[] items = {"azul","verde","amarillo"};

    private ProgressDialog barProgressDialog;
    private Handler updateBarHandler;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //showDialog();
        //showDialogWithList();
        //showDialogWithCheckbox();
        //showRingDialog();
        //showBarDialog();
        showCustomDialog();
    }

    private void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Titulo")
                .setMessage("cerrar app?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Dialog", "seguimos en la app");
                    }
                }).show();
    }

    private void showDialogWithList(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("elige un color");
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDialogWithCheckbox(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("elige un color");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showRingDialog(){
        final ProgressDialog ringProgressDialog = ProgressDialog.show(DialogActivity.this, "espere", "descargando...", true);
        ringProgressDialog.setCancelable(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ringProgressDialog.dismiss();
            }
        }).start();
    }

    private void showBarDialog(){
        barProgressDialog = new ProgressDialog(DialogActivity.this);

        barProgressDialog.setTitle("espere...");
        barProgressDialog.setMessage("descargando...");
        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_HORIZONTAL);
        barProgressDialog.setProgress(0);
        barProgressDialog.setMax(20);
        barProgressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (barProgressDialog.getProgress() <= barProgressDialog.getMax()) {
                        Thread.sleep(2000);

                        updateBarHandler.post(new Runnable(){
                            @Override
                            public void run() {
                                barProgressDialog.incrementProgressBy(2);
                            }
                        });

                    if (barProgressDialog.getProgress() == barProgressDialog.getMax()){
                        barProgressDialog.dismiss();
                    }

                }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }).start();
    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater(); //para crear estilo personalizado del layout

        builder.setView(inflater.inflate(R.layout.dialog_custom,null))
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            })
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

        AlertDialog alert = builder.create();
        alert.show();

    }
}