package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class spinnerOtro extends AppCompatActivity {
    private Spinner spinner;
    private ImageView ivImg;
    private String frutas[] = {"Aguacates", "Cerezas", "Fresas", "Manzanas"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_otro);

        spinner = (Spinner)findViewById(R.id.spinner3);
        ivImg = (ImageView)findViewById(R.id.imageView3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.formatospotro, frutas);
        spinner.setAdapter(adapter);
    }
    public void mostrar(View view) {
        int id = this.getResources().getIdentifier(spinner.getSelectedItem().toString().toLowerCase(), "drawable", this.getPackageName());
        ivImg.setImageResource(id);

        /*
        if(spinner.getSelectedItem().equals("Aguacate"))
        {
            ivImg.setImageResource(R.drawable.aguacates);
        }
        else if(spinner.getSelectedItem().equals("Cereza"))
        {
            ivImg.setImageResource(R.drawable.cerezas);
        }
        else if(spinner.getSelectedItem().equals("Fresa"))
        {
            ivImg.setImageResource(R.drawable.fresas);
        }
        else
        {
            ivImg.setImageResource(R.drawable.manzanas);
        }
        */
    }
    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}