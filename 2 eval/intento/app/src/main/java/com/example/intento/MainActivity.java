package com.example.intento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.tv1);

        BufferedReader fichero = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.texto)));

        try {
            /*
            String lectura = fichero.readLine();
            while(lectura !=null)
                lectura = fichero.readLine();
           */
            tv1.setText(fichero.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            fichero.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
