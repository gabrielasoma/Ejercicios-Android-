package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class intentBundle1 extends AppCompatActivity {
    EditText nombre;
    EditText edad;
    EditText peso;
    EditText altura;

    Button enviar;
    Toast m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_bundle1);

        nombre = (EditText) findViewById(R.id.editNombre1);
        edad = (EditText) findViewById(R.id.editEdad1);
        peso = (EditText) findViewById(R.id.editPeso);
        altura = (EditText) findViewById(R.id.editAlt);
        enviar =(Button)findViewById(R.id.btnPeso);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                switch(v.getId()){

                    case R.id.enviar:
                    */

                        if(nombre.getText().length()==0 || edad.getText().length()==0 || peso.getText().length()==0  || altura.getText().length()==0){
                            m = Toast.makeText(intentBundle1.this,"Introduce valores",Toast.LENGTH_SHORT);
                            m.show();
                        }else{
                            String n = nombre.getText().toString();
                            double e= Double.parseDouble(edad.getText().toString());
                            double p=Double.parseDouble(peso.getText().toString());
                            double a= Double.parseDouble(altura.getText().toString());

                            if(e>100 || e<10){//edad
                                m=Toast.makeText(intentBundle1.this,"Edad incorrecta (10-100)", Toast.LENGTH_SHORT);
                                m.show();

                            }else if(p>200 || p<10){//peso
                                m=Toast.makeText(intentBundle1.this,"Peso incorrecto (10kg-200kg)", Toast.LENGTH_SHORT);
                                m.show();
                            }else if(a>2.3 || a<.5){
                                m=Toast.makeText(intentBundle1.this,"Altura incorrecto (.5 - 2.5 metros)", Toast.LENGTH_SHORT);
                                m.show();
                            }else{
                                Intent i= new Intent(intentBundle1.this, intentBundle2.class);
                                i.putExtra("nombre",n);
                                i.putExtra("edad",e);
                                i.putExtra("peso",p);
                                i.putExtra("altura",a);
                                startActivity(i);
                            }
                            /*
                            break;

                        }
                        */

                }

            }
        });

    }







    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}