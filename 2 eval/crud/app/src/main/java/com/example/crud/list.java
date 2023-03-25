package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import entidades.Usuario;
import utilidades.utilidades;

public class list extends AppCompatActivity {
    ListView list;

    //En este array esta la info que va a aparecer en el list
    ArrayList<String> listaInfo;

    //Tipo usuario
    ArrayList<Usuario>listaUsuarios;

    //Conexion
    conexion conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //Conexion
        conn = new conexion(getApplicationContext(),"bd_usuarios",null,1);

        list =(ListView) findViewById(R.id.ls);

        //metodo, hacer consulta a la bd , la info de registros que devuelve se presenta en la listView
        consultarListaPersona();

        //Hacemos adaptador
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInfo);
        list.setAdapter(adaptador);

        //damos click y aparecen sus datos, INTENT
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion ="id: "+listaUsuarios.get(position).getId()+"\n";
                       informacion +="Nombre: "+listaUsuarios.get(position).getNombre()+"\n";
                       informacion +="Telefono: "+listaUsuarios.get(position).getTelefono()+"\n";

               //en el toast aparecen todos los datos del selseccionado
                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();


                //IMPORTANTE
                //Mandamos los datos a otra hoja cuando seleccionemos algun item
                //Con esto nos dice la posiccion del item seleccionado
                Usuario user = listaUsuarios.get(position);

                //Creamos un intent y mandamos los datos a listEnviar.class
                Intent intent = new Intent(list.this,listaEnviar.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("usuario",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void consultarListaPersona() {
        //metodo, hacer consulta a la bd , la info de registros que devuelve se presenta en la listView
        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuario = null;
        listaUsuarios = new ArrayList<Usuario>();

        //Select * from usuarios
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_USUARIO,null);

        while(cursor.moveToNext()){
            //Objeto
            usuario  = new Usuario();


            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            //Añadimos los usuarios
            listaUsuarios.add(usuario);
        }
        obtenerLista();//recorre la lista de usuario y la asigna al array list de lista info
    }

    private void obtenerLista() {//recorre la lista de usuario y la asigna al array list de lista info
        listaInfo = new ArrayList<String>();
        for (int i=0; i<listaUsuarios.size();i++){
            listaInfo.add(listaUsuarios.get(i).getId() + " - "+listaUsuarios.get(i).getNombre());
        }

    }

    public void atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }

    public void reg(View view){

        Intent back = new Intent(this,registrar.class);
        startActivity(back);



    }
}