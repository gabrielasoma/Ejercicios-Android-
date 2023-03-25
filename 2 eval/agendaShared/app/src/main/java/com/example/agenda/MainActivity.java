package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//share preference agenda, nos permite guardar datos limitados

    private EditText et_nombre, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nombre=(EditText) findViewById(R.id.txt_nombre);
        et_datos=(EditText) findViewById(R.id.txt_datos);
    }

    //metodo para el boto guardar
    public void Guardar(View view){

        //Como vamos a guardar vamos a crear variables, que nos permiten almacenar temporalmente
        String nombre = et_nombre.getText().toString();
        String datos = et_datos.getText().toString();

        //Creamos el objeto de share, creamos la agenda que contiene los datos de modo privado
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);

        //Creamos objeto para poder editar el archivo, sin el .edit no se puede editar el archivo
        SharedPreferences.Editor ojb_editor = preferencias.edit();

        //valores, nuestra referencia es el nombre del contacto (declaradas en este metodo), los informacion que queremos guardar son los datos
        ojb_editor.putString(nombre, datos);

        //Es obligatorio
        ojb_editor.commit();

        Toast.makeText(this, "El contacto ha sido guardado", Toast.LENGTH_SHORT).show();

    }

    //metodo para el boto buscar

    public void Buscar(View view){

        //como vamos a buscar un contacto, hay que recuperar el nombre del usuario
        String nombre = et_nombre.getText().toString();


        //Creamos el objeto de share, creamos la agenda que contiene los datos de modo privado
        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);

        //En esta variable vamos a almacenar los datos que se van a mostrar del contacto que el usuario esta buscando
        //El primer parametro nos pide la referencia del dato que estamos buscando , el segundo es el valor que queremos mostrar
        String datos = preferencias.getString(nombre,"");

        //Condicional para saber si existe el contacto
        if(datos.length() == 0){
            Toast.makeText(this, "No se encontro ningun registro",Toast.LENGTH_SHORT).show();
        }else{

            //En caso de que encuentre los datos
            et_datos.setText(datos);

        }


    }

}