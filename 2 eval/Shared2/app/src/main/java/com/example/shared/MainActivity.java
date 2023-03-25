package com.example.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editUsu;
    EditText editPass;
    TextView txtUsu;
    TextView txtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsu=(EditText) findViewById(R.id.idUsu);
        editPass = (EditText) findViewById(R.id.idPass);
        txtUsu =(TextView) findViewById(R.id.idtxtUsu);
        txtPass =(TextView) findViewById(R.id.idtxtPass);

        //Este metodo sirve para ver si se han guardo la info al cerrar la app
        cargarPreferencias();
        
    }
    
    public void onClick(View view){
        switch(view.getId()){
            case  R.id.btnGuardar:
                guardarReferencias();
                break;
            case R.id.btnCargar://Manda los datos a otro activity
                Intent intent = new Intent (this, shared.class);
                startActivity(intent);
                break;
        }
    }


    //este metodo genera el archivo de preferencias(xml), lee la info de los campos y los almacena en un archivo
    private void guardarReferencias() {
        //Credenciales es el nombre del archivo, y que sea privado
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        //Leemos la info del campo de texto
        String usuario= editUsu.getText().toString();
        String pass= editPass.getText().toString();

        //Asignamos al archivo credenciales los datos que introducimos, el editor nos permite modificar el archivo credenciales
        SharedPreferences.Editor editor = preferences.edit();

        //Le agregamos los datos que queremos introducirle, (clave, valor)
        editor.putString("usser",usuario);
        editor.putString("pass",pass);

        //De esta manera sabemos que funciona
        txtUsu.setText(usuario);
        txtPass.setText(pass);

        //Para completar el proceso de crear el archivo y almacenar la info
        editor.commit();
    }

    //Nos guarda la info cuando hayamos cerrado la app, vamos a LEERLO no EDITARLO
    private void cargarPreferencias() {
        //Usamos el mismo shared
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        //Clave, y valor por defecto, en un primer valor nos pondra no existe la info hasta que se pongan nuevos datos
        String user=preferences.getString("usser","No existe la información");
        String pass=preferences.getString("pass","No existe la información");

        //Nos muestra la info recuperada
        txtUsu.setText(user);
        txtPass.setText(pass);
    }


}