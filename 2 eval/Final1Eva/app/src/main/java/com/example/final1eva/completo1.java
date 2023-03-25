package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class completo1 extends AppCompatActivity {

    EditText e1;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completo1);

        e1 =findViewById(R.id.editb1);
        t1 = findViewById(R.id.te1);

        String datos =
                "\nNombre: "+getIntent().getStringExtra("nombre") +
                "\nEmail: "+getIntent().getStringExtra("email")+
                "\nEdad: "+getIntent().getIntExtra("edad",0) +
                "\nDireccion: "+getIntent().getStringExtra("direccion")+
                "\nDepartamento: "+getIntent().getStringExtra("sp") +
                "\nHorario :"+getIntent().getStringExtra("tiempo")+

                "\nSitio :"+getIntent().getStringExtra("sitio");


        e1.setText(getIntent().getStringExtra("nombre"));
        t1.setText(datos);
    }




    public void Atras(View view){
        Intent back = new Intent(this,completo.class);
        startActivity(back);
    }
}