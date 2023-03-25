package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class spinnerCalculadora extends AppCompatActivity {

    Button boton;
    EditText n1, n2;
    TextView r;
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_calculadora);

        boton= (Button)findViewById(R.id.btn);
        sp= (Spinner)findViewById(R.id.spn);

        n1= (EditText) findViewById(R.id.num1);
        n2= (EditText) findViewById(R.id.num2);
        r= (TextView) findViewById(R.id.result);

        String [] operaciones = {"Sumar","Restar","Multiplicar","Dividir"};

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,operaciones);
        sp.setAdapter(adapter);

        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String operacion= sp.getSelectedItem().toString();

                Toast.makeText(getApplication(), "Selecciona la operación: "+operacion,Toast.LENGTH_SHORT).show();

                double valor1, valor2,resp;

                valor1= Double.parseDouble(n1.getText().toString());
                valor2= Double.parseDouble(n2.getText().toString());

                resp=0;

                if(operacion.equals("Sumar")){
                    resp= valor1+valor2;
                }else if(operacion.equals("Restar")){
                    resp=valor1 -valor2;

                }else if(operacion.equals("Multiplicar")){
                    resp= valor1*valor2;

                }else if(operacion.equals("Dividir")){
                    if(valor2==0){
                        Toast toast1 = Toast.makeText(spinnerCalculadora.this, "No se puede divider entre 0", Toast.LENGTH_SHORT);
                        toast1.show();

                    }else{
                        resp = valor1/valor2;
                    }

                }else{
                    resp=0;
                }
                //manda el resultado a la etiqueta correspondiente
                r.setText(String.valueOf(resp));

            }
        });
    }


    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }



}