package com.example.crudcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudcurso.conexion.conexionBd;

public class MainActivity extends AppCompatActivity {
    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_codigo =(EditText) findViewById(R.id.txt_codigo);
        et_descripcion =(EditText) findViewById(R.id.txt_descripcion);
        et_precio =(EditText) findViewById(R.id.txt_precio);
    }

    public void Registrar(View view){
        //Creamos objeto de la clase conexion, en el name se le pone el nombre del bd
        conexionBd admin = new conexionBd(this,"administracion",null,1);

        //abrimos bd modo lectura,escritura con getWriteDatabase
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //trabajamos con los datos que el usuario nos esta dando
        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        //validamos los campos
        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            //ponemos los datos dentro de la bd
            //Con esto los guardamos
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo); //ponemos en el primer campo un nombre inventado y en el segundo parametro le mandamos la variable que contiene ese valor
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            //Ahora lo insertamos en la tabla articulo
            BaseDeDatos.insert("articulos",null, registro);
            BaseDeDatos.close();

            //limpiamos
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this,"Debes rellenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para consultar un articulo
    public void buscar(View view){
        //conectamos con la base de datos y luego abrimos con lectura y escritura
        conexionBd admin = new conexionBd(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //Buscamos por id y recogemos sus datos y los ponemos en el text
        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            //Creamos un cursor, nos apoya para seleccionar un producto a traves de su codigo
            Cursor fila = BaseDeDatos.rawQuery("select descripcion, precio from articulos where codigo =" + codigo, null);

            //que encuentre datos dentro de la tabla
            if(fila.moveToFirst()){
                et_descripcion.setText(fila.getString(0));//se comporta como un array por lo que empieza en 0 el set text aunque los campos de la bd sean distinto , debe tener este orden
                et_precio.setText(fila.getString(1));
                BaseDeDatos.close();

            }else{//caso de que el producto no existe
                Toast.makeText(this,"No existe el articulo",Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }

        }else{
            Toast.makeText(this,"Debes introducir el codigo del articulo",Toast.LENGTH_SHORT).show();
        }
    }

    //metodo eliminar
    public void eliminar(View view){
        //conectamos con la base de datos y luego abrimos con lectura y escritura
        conexionBd admin = new conexionBd(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //Para eliminar buscamos por id
        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            //borramos, el metodo delete retorna un valor entero(cantidad de registros borrados)
            int cantidad = BaseDeDatos.delete("articulos", "codigo=" + codigo, null);
            BaseDeDatos.close();

            //limpiamos
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if(cantidad ==1){
                Toast.makeText(this,"Articulo eliminado exitosamente",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"El articulo seleccionado no existe",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Debes introducir el codigo del articulo",Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para modificar, casi igual que el registro
    public void modificar(View view){

        //conectamos con la base de datos y luego abrimos con lectura y escritura
        conexionBd admin = new conexionBd(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //recogemos los datos para poder editarlos
        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo); //ponemos en el primer campo un nombre inventado y en el segundo parametro le mandamos la variable que contiene ese valor
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            //linea para modificar
            int cantidad = BaseDeDatos.update("articulos", registro, "codigo=" +codigo,null);
            BaseDeDatos.close();

            if(cantidad ==1){
                Toast.makeText(this,"Articulo modificado correctamente",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"El articulo no existe",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Debes rellenar todos los campos",Toast.LENGTH_SHORT).show();
        }


    }
}