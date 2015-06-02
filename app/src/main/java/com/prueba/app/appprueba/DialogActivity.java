package com.prueba.app.appprueba;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by roxana on 02/06/15.
 */
public class DialogActivity extends Activity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showDialog();

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
                });


    }
}
