package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import entidades.Usuario;

public class listaEnviar extends AppCompatActivity {
    TextView campoId, campoNombre, campoTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_enviar);
        campoId =(TextView) findViewById(R.id.idList);
        campoNombre =(TextView) findViewById(R.id.nombreList);
        campoTelefono =(TextView) findViewById(R.id.telefonoList);

        //Recogemos los datos de la otra clase con el bundle
        Bundle objetoEnviado = getIntent().getExtras();

        Usuario user = null;

        if(objetoEnviado != null){
            user =(Usuario) objetoEnviado.getSerializable("usuario");
            campoId.setText(user.getId().toString());
            campoNombre.setText(user.getNombre().toString());
            campoTelefono.setText(user.getTelefono().toString());
        }
    }


    public void atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}