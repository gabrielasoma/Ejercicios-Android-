package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class parametro1 extends AppCompatActivity {
    //intent
    EditText n1;
    Button btn1;

    //bundle
    EditText numEnviar;
    Button boton1;

    //parametro (2 maneras)
    TextView mensaje;
    EditText mensajeIntroducido;
    Button boton2;

    /*Bundle array*/
    Button boton3;
    String[] datosArray = new String[]{"Juanito","Pinto","Avenida Siempre","22"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametro1);
        //Intent
        n1 = (EditText) findViewById(R.id.texto1);
        btn1 = (Button) findViewById(R.id.enviar);

        //Bundle
        numEnviar = (EditText) findViewById(R.id.txt1);
        boton1 = (Button) findViewById(R.id.bt1);


        //parametro
        mensaje = findViewById(R.id.ver);
        mensajeIntroducido = findViewById(R.id.txt2);
        boton2 = (Button) findViewById(R.id.bt2);


        /*bundle*/
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                Bundle enviarDatos = new Bundle();
                enviarDatos.putString("datosMandados", numEnviar.getText().toString());

                Intent i = new Intent(parametro1.this, parametro2.class);
                i.putExtras(enviarDatos);
                startActivity(i);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensajeString = mensajeIntroducido.getText().toString();
                mensaje.setText(mensajeString);
            }
        });


        /*Bundle array + foto (automatico)*/
        boton3 = (Button) findViewById(R.id.btn3);

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle enviarDatosArray = new Bundle();
                enviarDatosArray.putStringArray("datosMandadosArray",datosArray);

                Intent i = new Intent(parametro1.this,parametro2.class);
                i.putExtras(enviarDatosArray);
                startActivity(i);
            }
        });

    }

    /*Intent */
    public void mandar(View view) {
        Intent i = new Intent(this, parametro2.class);
        i.putExtra("dato", n1.getText().toString());
        startActivity(i);
    }


    /*PARAMETRO*/
    /*
    public void mandar1(View view) {
        String mensajeString = mensajeIntroducido.getText().toString();
        mensaje.setText(mensajeString);

    }
    */




    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}