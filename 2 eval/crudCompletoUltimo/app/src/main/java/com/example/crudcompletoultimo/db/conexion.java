package com.example.crudcompletoultimo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class conexion extends SQLiteOpenHelper {

    //variable
    private static final int DATABASE_VERSION= 1;
    private static final String DATABASE_NOMBRE= "agenda.db";
    public static final String TABLE_CONTACTOS= "t_contactos";


    //Modificamos el parametro y dejamos solo 1
    public conexion( @Nullable  Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }


    //crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //debe de ser el nombre de db porque se manda por parameto


        db.execSQL("CREATE TABLE " + TABLE_CONTACTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "correo_electronico TEXT)");
    }



    //Se ejecuta cuando cambia la version de base de datos, por ejemplo añadir nueva tabla, editar un campo , etc...
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Nos eliminar la tabla que tenemos y despues la agrega
        db.execSQL("DROP TABLE "+ TABLE_CONTACTOS);
        onCreate(db);
    }
}
