package com.example.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import utilidades.utilidades;

public class conexion extends SQLiteOpenHelper {

    public conexion( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Genera las tablas de las entidades
    @Override
    public void onCreate(SQLiteDatabase db) {
        //IMPORTANTE CREAMOS LOA BD
        db.execSQL(utilidades.CREAR_TABLA_USUARIO);



    }


    //Verifica si existe una version antigua, y si existe que la actualice
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
