package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import entidades.Usuario;
import utilidades.utilidades;

public class spinner extends AppCompatActivity {
    TextView campoId,campoNombre, campoTelefono;
    Spinner comboPersona;
    ArrayList<String> listaSpinner;//representa info del combo
    ArrayList<Usuario> personasList;//info con la que mapeamos, construir objetos

    //Conexion
    conexion conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        //NUeva conexion
        conn = new conexion(getApplicationContext(),"bd_usuarios",null,1);

        comboPersona =(Spinner) findViewById(R.id.sp);
        campoId =(TextView)findViewById(R.id.idSp);
        campoNombre =(TextView)findViewById(R.id.nombreSp);
        campoTelefono =(TextView)findViewById(R.id.telefonoSp);

        //Metodo
        consularListaPersonas();

        //Llenamos los datos el spinner
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item,listaSpinner);
        comboPersona.setAdapter(adaptador);


        //Como seleccionar un dato y que muestre sus datos en el textView seleccionando el spinner
        comboPersona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){//En caso que seleccione algun item, va a traer sus datos al textView
                    //El -1 es porque  nuestro spinner le hemos añadido cabecera (Selecciona)
                    campoId.setText(personasList.get(position-1).getId().toString());
                    campoNombre.setText(personasList.get(position-1).getNombre().toString());
                    campoTelefono.setText(personasList.get(position-1).getTelefono().toString());
                }else{//En caso de pulsar selecciona se pone vacio
                    campoId.setText("");
                    campoNombre.setText("");
                    campoTelefono.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    //obtenemos los datos
    private void consularListaPersonas() {
        //Leemos la base de datos
        SQLiteDatabase db =conn.getReadableDatabase();

        //Creamos un instancia a la clase usuario para crear objeto persona
        Usuario persona =null;

        //Creamos instancia a la lista de personas
        personasList = new ArrayList<Usuario>();

        //queremos recorrer la BD: select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ utilidades.TABLA_USUARIO,null);

        while(cursor.moveToNext()){
            //llenamos y asignamos la info de la bd
            persona = new Usuario();

            //le mandamos lo que halla en el regitro
            persona.setId(cursor.getInt(0));
            persona.setNombre(cursor.getString(1));
            persona.setTelefono(cursor.getString(2));

            //Se pone el log para que salga por consola, pero no es necesario
            Log.i("id",persona.getId().toString());
            Log.i("Nombre",persona.getNombre().toString());
            Log.i("Tel",persona.getTelefono().toString());

            //Debemos de rellenar el array con persona
            personasList.add(persona);
        }
        obtenerLista();

    }

    //obtenemos los datos del spinner
    private void obtenerLista() {
    //instanciamos el list de personas
        listaSpinner = new ArrayList<String>();
        listaSpinner.add("Selecciona");

        for (int i =0; i<personasList.size();i++){
            //añadimos elementos del list en el spinner
            listaSpinner.add(personasList.get(i).getId()+" - "+personasList.get(i).getNombre());
        }
    }

    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }


}