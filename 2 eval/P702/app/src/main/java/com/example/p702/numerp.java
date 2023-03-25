package com.example.p702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class numerp extends AppCompatActivity {
    private SharedPreferences prefe;
    private SharedPreferences.Editor editor;
    private TextView tvAciertos, tvResul;
    private EditText etNumero;
    private int aleatorio, aciertos;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerp);
        tvAciertos = (TextView)findViewById(R.id.tvCantAci);
        tvResul = (TextView)findViewById(R.id.tvResul);
        etNumero = (EditText)findViewById(R.id.etNumero);
        prefe = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        editor = prefe.edit();

        aciertos = prefe.getInt("Aciertos", 0);
        tvAciertos.setText(String.valueOf(prefe.getInt("Aciertos", 0)));

        aleatorio = random.nextInt(10)+1;
    }

    public void comprobar(View view) {
        if(Integer.parseInt(etNumero.getText().toString()) == aleatorio) {
            aciertos++;

            editor = prefe.edit();
            editor.putInt("Aciertos", aciertos);
            editor.commit();
            tvAciertos.setText(String.valueOf(prefe.getInt("Aciertos", 0)));

            tvResul.setText("¡¡¡Acertaste!!! \n\n Número reseteado");
            etNumero.setText("");

            aleatorio = random.nextInt(10)+1;

        }else if(Integer.parseInt(etNumero.getText().toString()) < aleatorio) {
            tvResul.setText("El número a adivinar es mayor");
        }else {
            tvResul.setText("El número a adivinar es menor");
        }
    }
    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }

}