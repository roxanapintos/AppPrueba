package com.prueba.app.appprueba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by roxana on 27/05/15.
 */
public class HelloBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BroadCast Receiver", "Conectado");

    }
}
