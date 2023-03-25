package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class datos extends AppCompatActivity {

    TextView mensaje;
    EditText mensajeIntroducido;

    public void presionar(View view) {
        mensaje = findViewById(R.id.res3);
        mensajeIntroducido = findViewById(R.id.texto3);

        String mensajeString = mensajeIntroducido.getText().toString();
        mensaje.setText(mensajeString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        /*
        mensaje = findViewById(R.id.res3);
        mensaje.setText("Hola mundo");
        */
    }

    public void Atras (View view){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }
}