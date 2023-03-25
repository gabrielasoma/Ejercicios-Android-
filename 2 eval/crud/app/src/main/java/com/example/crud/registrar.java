package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLData;

import utilidades.utilidades;

public class registrar extends AppCompatActivity {
    EditText campoId, campoNombre, campoTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        campoId = (EditText) findViewById(R.id.editId);
        campoNombre = (EditText) findViewById(R.id.editIdNombre);
        campoTelefono = (EditText) findViewById(R.id.editIdTel);

    }
    public void onClick(View view) {
        //registrarUsuario();
        registrarUsuarioSql();
    }


    private void registrarUsuario() {
        //Es la misma que aparece en el main
        conexion conn = new conexion(this,"bd_usuarios",null,1);

        //Con esto abrimos la base de datos y nos permite editar
        SQLiteDatabase db = conn.getWritableDatabase();

        //Para hacer el registro contentValue, clave y valor asociado
        //Creamos el objeto
        ContentValues values = new ContentValues();

        //Usamos la variable de utilidades, el siguiente valor es el que en el main y lo obtenemos
        //CAMPO_ID (TABLA),campoId dato del edit
        values.put(utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        //INSERTAR en bd, nos retorna un long, le enviamos el campoId para que le ponga values
        Long idResultante = db.insert(utilidades.TABLA_USUARIO,utilidades.CAMPO_ID,values);

        //El toast nos muestra el id de la bd
        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_LONG).show();
        db.close();
    }


    private void registrarUsuarioSql() {
        //Es la misma que aparece en el main
        conexion conn = new conexion(this,"bd_usuarios",null,1);

        //Con esto abrimos la base de datos y nos permite editar
        SQLiteDatabase db = conn.getWritableDatabase();

        String insert = " INSERT INTO "+ utilidades.TABLA_USUARIO + "( "+utilidades.CAMPO_ID+", "+utilidades.CAMPO_NOMBRE+","+utilidades.CAMPO_TELEFONO+")" +
                " VALUES ("+campoId.getText().toString()+",'"+campoNombre.getText().toString()+"', '"
                +campoTelefono.getText().toString()+"')";

        //Para que inserte hay que poner esto
        db.execSQL(insert);

        //El toast nos muestra el id de la bd
        Toast.makeText(getApplicationContext(),"Añadido correctamente",Toast.LENGTH_LONG).show();

        //Cerramos
        db.close();
    }

    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }

}