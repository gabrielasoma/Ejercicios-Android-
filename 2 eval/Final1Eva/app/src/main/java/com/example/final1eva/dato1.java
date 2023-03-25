package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dato1 extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText edad;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dato1);

        nombre = findViewById(R.id.et1);
        apellido = findViewById(R.id.et2);
        edad = findViewById(R.id.et3);
        boton = findViewById(R.id.bt);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre_string = nombre.getText().toString();
                String apellido_string = apellido.getText().toString();
                String edad_string = edad.getText().toString();

                Integer edad1_int =Integer.parseInt(edad_string);

                Intent i = new Intent(dato1.this,dato2.class);
                i.putExtra("keyname",nombre_string);
                i.putExtra("keysurname",apellido_string);
                i.putExtra("keyage",edad1_int);
                startActivity(i);
            }
        });
    }

    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}