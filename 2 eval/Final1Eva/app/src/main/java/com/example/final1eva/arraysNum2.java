package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class arraysNum2 extends AppCompatActivity {
    TextView texto;
    int numeros[] = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrays_num2);



        texto = (TextView) findViewById(R.id.n1);

        numeros = getIntent().getExtras().getIntArray("num");
        texto.setText("");

        for (int i=0; i<numeros.length;i++){
            texto.setText(texto.getText() + "\n" +numeros[i]);
        }
    }

    public void Atras(View view){
        Intent back = new Intent(this,arraysNum.class);
        startActivity(back);
    }
}