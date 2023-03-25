package com.example.crud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import utilidades.utilidades;

public class consultar extends AppCompatActivity {
    EditText campoId, campoNombre, campoTelefono;

    //Tipo conexion
    conexion conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        conn= new conexion(getApplicationContext(),"bd_usuarios",null,1);


        campoId = (EditText) findViewById(R.id.editConDoc);
        campoNombre = (EditText) findViewById(R.id.editConNombre);
        campoTelefono = (EditText) findViewById(R.id.editConTel);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnBuscar:
                //consultar();
                consultarSQL();
                break;
            case R.id.btnAct:
                actualizar();
                break;
            case R.id.btnEliminar:
                eliminar();
                break;
        }
    }



    public void atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }

    private void consultar(){
        //Readable
        SQLiteDatabase db= conn.getReadableDatabase();

        //Buscamos por id
        String[] parametros = {campoId.getText().toString()};

        //Definimos los campos que queremos que nos visualice
        String[] campos = {utilidades.CAMPO_NOMBRE,utilidades.CAMPO_TELEFONO};

        //Creamos cursor
        //Null: 1º group by, 2º having, 3º order by
        try{
            //que todo este bien
            //mirar parametros de cursor
            Cursor cursor = db.query(utilidades.TABLA_USUARIO,campos,utilidades.CAMPO_ID+"=?",parametros,null,null,null);

            //hacemos que el cursor se pare en el primer registro que encuentre
            cursor.moveToFirst();

            //Recoge los datos y los muestra en el editText
            campoNombre.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));

            //Hay que cerrar el cursor
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    private void consultarSQL() {
        //Aqui es read
        SQLiteDatabase db= conn.getReadableDatabase();

        //Buscamos por id
        String[] parametros = {campoId.getText().toString()};

        try{
            //Select nombnre,telefono from usuario where codigo =?
            Cursor cursor=db.rawQuery("SELECT "+utilidades.CAMPO_NOMBRE+","+utilidades.CAMPO_TELEFONO+
                    " FROM "+utilidades.TABLA_USUARIO + " WHERE "+utilidades.CAMPO_ID +" =? ",parametros);

            cursor.moveToFirst();

            //recoge los datos
            campoNombre.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));

            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    private void actualizar() {
        //getwrite para escribir sobre la bd(WRITE)
        SQLiteDatabase db= conn.getWritableDatabase();

        //Buscamos por id
        String[] parametros = {campoId.getText().toString()};

        //Clave y valor, recogemos sus datos
        ContentValues values = new ContentValues();
        values.put(utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(utilidades.CAMPO_TELEFONO, campoTelefono.getText().toString());

        //Actualizamos
        //mandamos la tabla, el valor, y el campo id que estamos introduciendo , luego el parametro
        db.update(utilidades.TABLA_USUARIO,values,utilidades.CAMPO_ID+"=?",parametros);

        Toast.makeText(getApplicationContext(),"Ya se actualizo",Toast.LENGTH_LONG).show();
        //Cerramos conexion
        db.close();
    }

    private void eliminar() {
        //Abrimos la base de datos(write)
        SQLiteDatabase db= conn.getWritableDatabase();

        //Buscamos por id
        String[] parametros = {campoId.getText().toString()};

        db.delete(utilidades.TABLA_USUARIO,utilidades.CAMPO_ID+"=?",parametros);

        Toast.makeText(getApplicationContext(),"Se elimino el usuario",Toast.LENGTH_LONG).show();

        campoId.setText("");
        limpiar();

        //Cerramos conexion
        db.close();
    }


    //inventado alert
    /*
    private void eliminar() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(consultar.this);
        alerta.setMessage("¿Desea eliminar el registro?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish();

                        //Abrimos la base de datos
                        SQLiteDatabase db= conn.getWritableDatabase();
                        //Buscamos por id
                        String[] parametros = {campoId.getText().toString()};

                        db.delete(utilidades.TABLA_USUARIO,utilidades.CAMPO_ID+"=?",parametros);

                        Toast.makeText(getApplicationContext(),"Se elimino el usuario",Toast.LENGTH_LONG).show();

                        campoId.setText("");
                        limpiar();

                        //Cerramos conexion
                        db.close();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //se cierra el alert
                        dialog.cancel();
                    }
                });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("Salida");
        titulo.show();
    }
     */

    private void limpiar() {
        campoNombre.setText("");
        campoTelefono.setText("");
    }
}