package com.prueba.app.appprueba;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by roxana on 27/05/15.
 */
public class LayoutActivity extends Activity{

    private EditText userNameEditText;
    private EditText passwordEditText;

    private Button loginButton;


    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.table_layout);

        userNameEditText = (EditText) findViewById(R.id.editTextUsername);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);

        loginButton = (Button) findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userNameEditText.getText().toString().equals("admin") ||
                        passwordEditText.getText().toString().equals("admin")){
                    finish();
                }
                else {
                    Log.d("Login","Datos incorrectos");
                }
            }
        });

    }
}
