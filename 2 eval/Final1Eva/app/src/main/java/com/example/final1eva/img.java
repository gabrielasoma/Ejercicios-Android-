package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class img extends AppCompatActivity {

    private ImageView ivImagen;


    private EditText etTexto;
    private ImageView ivImagen1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        ivImagen = (ImageView)findViewById(R.id.imageView);


        etTexto = (EditText)findViewById(R.id.etTexto);
        ivImagen1 = (ImageView)findViewById(R.id.imageView1);
    }

    /*Primero*/
    public void aguacate(View v) {
        ivImagen.setImageResource(R.drawable.aguacates);
    }

    public void cereza(View v) {
        ivImagen.setImageResource(R.drawable.cerezas);
    }

    public void manzana(View v) {
        ivImagen.setImageResource(R.drawable.manzanas);
    }

    /*Segundo*/
    public void mostrar (View v) {
        if(etTexto.getText().toString().equalsIgnoreCase("a") || etTexto.getText().toString().equalsIgnoreCase("c") || etTexto.getText().toString().equalsIgnoreCase("m")) {
            int resID = this.getResources().getIdentifier(etTexto.getText().toString().toLowerCase(), "drawable", this.getPackageName());
            ivImagen1.setImageResource(resID);
        } else {
            Toast.makeText(this, "Debe teclear una letra correcta", Toast.LENGTH_LONG).show();
            ivImagen1.setImageResource(R.drawable.f);
        }

        /*
        if(String.valueOf(etTexto.getText()).equalsIgnoreCase("c"))
        {
            ivImagen.setImageResource(R.drawable.c);
        }
        else if(String.valueOf(etTexto.getText()).equalsIgnoreCase("a"))
        {
            ivImagen.setImageResource(R.drawable.a);
        }
        else if(String.valueOf(etTexto.getText()).equalsIgnoreCase("m"))
        {
            ivImagen.setImageResource(R.drawable.m);
        }
        else
        {
            Toast.makeText(this, "Debe teclear una letra", Toast.LENGTH_LONG).show();
            ivImagen.setImageResource(R.drawable.f);
        }
        */
    }


    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}