package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class mandarDatos2 extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String AGE = "AGE";
    public static final String SURNAME = "SURNAME";


    private TextView nombretxt;
    private TextView apellidotxt;
    private TextView edadtxt;

    private String nombre;
    private String apellido;
    private int edad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandar_datos2);
        
        nombretxt = (TextView) findViewById(R.id.textNombre);
        apellidotxt = (TextView) findViewById(R.id.textApellido);
        edadtxt = (TextView) findViewById(R.id.textEdad);

        Intent i = getIntent();
        nombre = i.getStringExtra(NAME);
        apellido =i.getStringExtra(SURNAME);
        edad = i.getIntExtra(AGE,0);


        nombretxt.setText("Nombre: " + nombre);
        apellidotxt.setText("Apellido: " + apellido);
        edadtxt.setText("Edad :"+edad);
    }

    public void Atras(View view){
        Intent back = new Intent(this,mandarDatos1.class);
        startActivity(back);
    }
}