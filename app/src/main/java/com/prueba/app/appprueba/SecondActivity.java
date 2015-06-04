package com.prueba.app.appprueba;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by roxana on 26/05/15.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String varString = getIntent().getStringExtra("valorTest");
        Log.d("HelloWorld Sec Activity",varString);
    }
}
