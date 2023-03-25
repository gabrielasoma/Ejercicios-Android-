package com.example.a805;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private BaseDatos datos;
    private SQLiteDatabase db;
    private TextView tvNumCita;
    private EditText etFecha, etHora, etAsunto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumCita = (TextView)findViewById(R.id.tvNumCita);
        etFecha = (EditText)findViewById(R.id.etFecha);
        etHora = (EditText)findViewById(R.id.etHora);
        etAsunto = (EditText)findViewById(R.id.etAsunto);
    }
    public void onResume()
    {
        super.onResume();
        datos = new BaseDatos(this,"Datos",null,4);
        db = datos.getWritableDatabase();
    }
    public void onPause()
    {
        super.onPause();
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, 1, Menu.NONE, "Insertar Cita");
        menu.add(Menu.NONE, 2, Menu.NONE, "Borrar Cita");
        menu.add(Menu.NONE, 3, Menu.NONE, "Consultar Cita");
        menu.add(Menu.NONE, 4, Menu.NONE, "Modificar Cita");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case 1:
                addCita();
                return true;
            case 2:
                borrarCita();
                return true;
            case 3:
                verCita();
                return true;
            case 4:
                modCita();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addCita()
    {
        if(comprobarDatos())
        {
            Cursor cursor = db.rawQuery("select fecha, hora from Citas where fecha = '" + etFecha.getText().toString() + "' and hora = '" + etHora.getText().toString() + "'", null);

            if(cursor.moveToFirst())
            {
                Toast.makeText(this, "Cita duplicada", Toast.LENGTH_LONG).show();
            }
            else
            {
                try
                {
                    String nombre = etFecha.getText().toString() + etHora.getText().toString();
                    OutputStreamWriter fichero = new OutputStreamWriter(openFileOutput(nombre + ".txt", Context.MODE_PRIVATE));

                    fichero.write(etAsunto.getText().toString());
                    fichero.flush();
                    fichero.close();
                    Toast.makeText(this, "Asunto guardado", Toast.LENGTH_LONG).show();

                    db.execSQL("INSERT INTO Citas(fecha, hora) VALUES (" + etFecha.getText().toString() + ", '" + etHora.getText().toString() + "')");
                    Toast.makeText(this, "Cita guardada", Toast.LENGTH_LONG).show();

                    limpiarCampos();
                }
                catch (FileNotFoundException e)
                {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                catch (IOException e)
                {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void borrarCita()
    {
        String nombre = etFecha.getText().toString() + etHora.getText().toString();

        File fichero = new File(getFilesDir(), nombre + ".txt");

        if(fichero.delete())
        {
            db.execSQL("delete from Citas where fecha = '" + etFecha.getText().toString() + "' and hora = '" + etHora.getText().toString() + "'");
            Toast.makeText(this, "Cita eliminada", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Error al eliminar la cita", Toast.LENGTH_LONG).show();
        }
    }

    public void verCita()
    {
        Cursor cursor = db.rawQuery("select * from Citas where fecha = '" + etFecha.getText().toString() + "' and hora = '" + etHora.getText().toString() + "'", null);

        if(cursor.moveToFirst())
        {
            tvNumCita.setText(cursor.getString(0));
            etFecha.setText(cursor.getString(1));
            etFecha.setText(cursor.getString(2));

            try
            {
                String nombre = etFecha.getText().toString() + etHora.getText().toString();
                BufferedReader fichero = new BufferedReader(new InputStreamReader(openFileInput(nombre + ".txt")));
                StringBuilder sb = new StringBuilder();
                String lectura = fichero.readLine();

                while(lectura != null)
                {
                    sb.append(lectura + "\n");
                    lectura = fichero.readLine();
                }

                etAsunto.setText(sb);
                fichero.close();
            }
            catch (IOException e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this, "No existe una cita con esa fecha y hora", Toast.LENGTH_LONG).show();
            limpiarCampos();
        }
    }

    public void modCita()
    {
        Cursor cursor = db.rawQuery("select * from Citas where fecha = '" + etFecha.getText().toString() + "' and hora = '" + etHora.getText().toString() + "'", null);

        if(cursor.moveToFirst())
        {
            String nombre = etFecha.getText().toString() + etHora.getText().toString();

            try
            {
                OutputStreamWriter fichero = new OutputStreamWriter(openFileOutput(nombre + ".txt", Context.MODE_PRIVATE));

                fichero.write(etAsunto.getText().toString());
                fichero.flush();
                fichero.close();

                Toast.makeText(this, "Cita modificada", Toast.LENGTH_LONG).show();
            }
            catch (IOException e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this, "No existe la cita", Toast.LENGTH_LONG).show();
        }
    }

    public boolean comprobarDatos()
    {
        if(etFecha.getText().toString().isEmpty())
        {
            Toast.makeText(this, "La fecha es obligatoria", Toast.LENGTH_LONG).show();
            return false;
        }

        if(etHora.getText().toString().isEmpty())
        {
            Toast.makeText(this, "La hora es obligatoria", Toast.LENGTH_LONG).show();
            return false;
        }

        if(etAsunto.getText().toString().isEmpty())
        {
            Toast.makeText(this, "El asunto es obligatorio", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    public void limpiarCampos()
    {
        etAsunto.setText("");
        etFecha.setText("");
        etHora.setText("");
        tvNumCita.setText("NumCita");
    }
}