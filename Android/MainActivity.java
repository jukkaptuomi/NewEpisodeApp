package com.example.uusinjakso;

import android.os.Bundle;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.lang.Exception;
import java.util.concurrent.ExecutionException;
import java.lang.Thread;
import android.os.StrictMode;

public class MainActivity extends Activity{
    EditText et;
    TextView tw;
    TextView uusin;
    Button button;

    private Sarjat lista;
    private URLyhteys yhteys;




    protected void onCreate(Bundle savedInstanceState){
        this.lista = new Sarjat();
        this.yhteys = new URLyhteys();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        uusin = (TextView) findViewById(R.id.textView2);
        et =(EditText) findViewById(R.id.editText);
        tw = (TextView) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)  {
                tw.setText(yhteys.haeUusin(yhteys.haeSarja(et.getText().toString())));
            }
        });
    }
}

