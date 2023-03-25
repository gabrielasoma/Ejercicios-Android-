package com.example.crudcurso.conexion;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class conexionBd  extends  SQLiteOpenHelper {

    //Constructor, 4 parametros
    public conexionBd( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Creamos la bd y en el metodo le modificamos el nombre
    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        //es importante los espacios
        //crea la tabla
        BaseDeDatos.execSQL("create table articulos(codigo int primary key, descripcion text, precio real) ");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
