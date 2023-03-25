package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class mandarDatos1 extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText edad;

    private Button boton;

    private String nombrestring;
    private String apellidostring;
    private int edadint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandar_datos1);

        nombre = (EditText) findViewById(R.id.editNombre);
        apellido = (EditText) findViewById(R.id.editApellido);
        edad = (EditText) findViewById(R.id.editEdad);

        boton = (Button) findViewById(R.id.btndatos);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandarTodoDato();
            }
        });
    }


    public void mandarTodoDato(){
        nombrestring = nombre.getText().toString().trim();
        apellidostring = apellido.getText().toString().trim();
        edadint = Integer.parseInt(edad.getText().toString().trim());

        Intent i = new Intent(mandarDatos1.this,mandarDatos2.class);

        i.putExtra(mandarDatos2.NAME,nombrestring);
        i.putExtra(mandarDatos2.SURNAME,apellidostring);
        i.putExtra(mandarDatos2.AGE,edadint);

        startActivity(i);
    }


    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}