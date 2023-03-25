package com.example.p803;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//Aplicación Android que permita insertar registros y consultar una BD con la
//siguiente estructura:
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void crearClientes(View view)
    {
        Intent i = new Intent(this, CrearClientes.class);
        startActivity(i);
    }

    public void crearFacturas(View view)
    {
        Intent i = new Intent(this, CrearFacturas.class);
        startActivity(i);
    }

    public void consularFacturas(View view)
    {
        Intent i = new Intent(this, ConsultarFacturas.class);
        startActivity(i);
    }
}