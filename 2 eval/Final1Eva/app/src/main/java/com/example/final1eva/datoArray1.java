package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class datoArray1 extends AppCompatActivity {
    TextView recup1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dato_array1);

        recup1 = (TextView) findViewById(R.id.recibidoArray);

        Bundle traido1 = getIntent().getExtras();
        String [] info1 = traido1.getStringArray("datosMandadosArray");

        recup1.setText("Nombre: " +info1[0]+"\nApellido: "+info1[1]+"\nDirección: "+info1[2] +"\nEdad: "+info1[3]);

    }


    public void Atras(View view){
        Intent back = new Intent(this,datoArray.class);
        startActivity(back);
    }


}