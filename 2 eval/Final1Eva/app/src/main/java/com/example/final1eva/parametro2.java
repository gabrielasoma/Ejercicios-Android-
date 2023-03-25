package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class parametro2 extends AppCompatActivity {

    /*Intent*/
    TextView t1;

    /*Bundle*/
    TextView recup;


    /*Bundle array*/
    TextView recup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametro2);

        /*Intent*/
        t1 = (TextView) findViewById(R.id.sol);
        String recibido = getIntent().getStringExtra("dato");
        t1.setText("Hola intent "+ recibido);


        /*Bundle*/
        recup = (TextView) findViewById(R.id.sol1);
        Bundle traido = getIntent().getExtras();
        String info = traido.getString("datosMandados");
        recup.setText(info);


        /*Bundle array*/
        recup1 = (TextView) findViewById(R.id.txt3);
        Bundle traido1 = getIntent().getExtras();
        String [] info1 = traido1.getStringArray("datosMandadosArray");

        recup1.setText("Nombre: " +info1[0]+"\nApellido: "+info1[1]+"\nDirección: "+info1[2] +"\nEdad: "+info1[3]);


    }



    public void Atras(View view){
        Intent back = new Intent(this,parametro1.class);
        startActivity(back);
    }

}