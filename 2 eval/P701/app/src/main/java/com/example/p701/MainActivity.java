package com.example.p701;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
//Proyecto que muestre un contador con el número de veces que se ha iniciado.
public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1 = (TextView)findViewById(R.id.tv1);
        SharedPreferences prefe = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefe.edit();
        cont = prefe.getInt("Contador", 1);
        tv1.setText("La aplicación se ha abierto " + String.valueOf(cont) + " veces");
        editor.putInt("Contador", ++cont);
        editor.commit();
    }
}