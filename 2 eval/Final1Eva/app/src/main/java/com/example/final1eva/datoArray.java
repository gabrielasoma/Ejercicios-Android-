package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class datoArray extends AppCompatActivity {

    //variables

    Button boton2;
    String[] datosArray = new String[]{"Juanito","Pinto","Avenida Siempre","22"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dato_array);

        boton2 = (Button) findViewById(R.id.bt3);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle enviarDatosArray = new Bundle();
                enviarDatosArray.putStringArray("datosMandadosArray",datosArray);

                Intent i = new Intent(datoArray.this,datoArray1.class);
                i.putExtras(enviarDatosArray);
                startActivity(i);

            }
        });


    }

    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }


}