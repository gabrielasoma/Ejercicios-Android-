package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
//NUevo

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos conexion
        //bd_usuario es el nombre de base de datos
        conexion conn = new conexion(this,"bd_usuarios",null,1);

    }
    public void registrar(View view){
        Intent back = new Intent(this,registrar.class);
        startActivity(back);
    }

    public void consultar(View view){
        Intent back = new Intent(this,consultar.class);
        startActivity(back);
    }

    public void spin(View view){
        Intent back = new Intent(this,spinner.class);
        startActivity(back);
    }

    public void list(View view){
        Intent back = new Intent(this,list.class);
        startActivity(back);
    }

    //Otra manera, luegos
    public void onClick(View view){
        Intent miIntent=null;
        switch (view.getId()){

        }
    }


    //===========Inventado ============
    //Método para mostrar y ocultar el menú
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //Método para asignar las funciones correspondientes a las opciones.
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.item1){
            Toast.makeText(this, "Opción 1: Registrar", Toast.LENGTH_SHORT).show();
            Intent back = new Intent(this,registrar.class);
            startActivity(back);

        } else if(id == R.id.item2){
            Toast.makeText(this, "Opción 2: consultar", Toast.LENGTH_SHORT).show();
            Intent back = new Intent(this,consultar.class);
            startActivity(back);
        }else if(id == R.id.item3){
            Toast.makeText(this, "Opción 3", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
    //=============Inventado ============

}