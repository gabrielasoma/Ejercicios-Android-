package com.example.p803;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    //Variables de la base de datos
    String crearClientes = "CREATE TABLE Clientes(dni text PRIMARY KEY,nombre TEXT, direccion text, tfno text)";
    String crearFacturas = "CREATE TABLE Facturas(num integer PRIMARY KEY,dni TEXT, concepto text, valor real)";

    public BaseDatos(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto,nombre,factory,version);
    }

    //Creamos la base de datos
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(crearClientes);
        db.execSQL(crearFacturas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int versionAnt,int versionNue) {
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL("DROP TABLE IF EXISTS Facturas");
        db.execSQL(crearClientes);
        db.execSQL(crearFacturas);
    }
}
