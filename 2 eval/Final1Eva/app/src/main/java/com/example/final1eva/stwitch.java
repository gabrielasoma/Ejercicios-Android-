package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class stwitch extends AppCompatActivity {
    //stich
    private Switch swModo;
    private TextView tvModo;


    //img boton
    private EditText txtNum1, txtNum2;
    private TextView tvResul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stwitch);

        swModo = (Switch)findViewById(R.id.swModo);
        tvModo = (TextView)findViewById(R.id.tvModo);


        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        tvResul = (TextView)findViewById(R.id.tvResul);

    }

    //stich
    public void Modo(View v) {
        if(swModo.isChecked())
        {
            tvModo.setText("Activado");
            swModo.setText("Activado");
        }
        else
        {
            tvModo.setText("Desactivado");
            swModo.setText("Desactivado");
        }
    }

    //img boton
    public void Suma(View v) {
        tvResul.setText(String.valueOf(Float.parseFloat(String.valueOf(txtNum1.getText())) + Float.parseFloat(String.valueOf(txtNum2.getText()))));
    }

    public void Resta(View v) {
        tvResul.setText(String.valueOf(Float.parseFloat(String.valueOf(txtNum1.getText())) - Float.parseFloat(String.valueOf(txtNum2.getText()))));
    }

    public void Multi(View v) {
        tvResul.setText(String.valueOf(Float.parseFloat(String.valueOf(txtNum1.getText())) * Float.parseFloat(String.valueOf(txtNum2.getText()))));
    }

    public void Divi(View v) {
        tvResul.setText(String.valueOf(Float.parseFloat(String.valueOf(txtNum1.getText())) / Float.parseFloat(String.valueOf(txtNum2.getText()))));
    }

    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}