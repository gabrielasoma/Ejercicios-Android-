package com.example.crudcompletoultimo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.crudcompletoultimo.db.NuevoActivity;
import com.example.crudcompletoultimo.db.conexion;

public class MainActivity extends AppCompatActivity {
    Button bCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bCrear = (Button) findViewById(R.id.btnCrear);


        bCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexion conn = new conexion(MainActivity.this);
                SQLiteDatabase db = conn.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(MainActivity.this, "Se ha creado correctamente la bd", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error al crear la bd", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu_principal, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void nuevoRegistro() {
        Intent intent = new Intent(this, NuevoActivity.class);
        startActivity(intent);


    }
}
