package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class alumno1 extends AppCompatActivity {
        EditText nota1;
        EditText nota2;
        EditText nota3;

        TextView respuesta;

        Button boton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno1);


        nota1 = (EditText) findViewById(R.id.not1);
        nota2 = (EditText) findViewById(R.id.not2);
        nota3 = (EditText) findViewById(R.id.not3);

        respuesta = (TextView) findViewById(R.id.asig);

        boton1 = (Button) findViewById(R.id.btnNota);

    }

    public void calculo(View view){
        String nota1_String = nota1.getText().toString();
        String nota2_String = nota2.getText().toString();
        String nota3_String = nota3.getText().toString();

        int nota1_int = Integer.parseInt(nota1_String);
        int nota2_int = Integer.parseInt(nota2_String);
        int nota3_int = Integer.parseInt(nota3_String);

        int promedio = (nota1_int +nota2_int+nota3_int)/3;

        if(promedio >=6){
            respuesta.setText("Aprobado: "+promedio);
        }else if(promedio <= 5) {
            respuesta.setText("Reprobado: " + promedio);
        }
    }


    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}