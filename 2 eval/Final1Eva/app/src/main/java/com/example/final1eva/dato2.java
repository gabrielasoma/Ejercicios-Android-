
package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class dato2 extends AppCompatActivity {
    TextView nombre1;
    TextView apellido1;
    TextView edad1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dato2);

        nombre1 = findViewById(R.id.t1);
        apellido1 = findViewById(R.id.t2);
        edad1 = findViewById(R.id.t3);

        String nombreFinal = getIntent().getStringExtra("keyname");
        String apellidoFinal = getIntent().getStringExtra("keysurname");
        String edadFinal = getIntent().getStringExtra("keyage");
        System.out.println(edadFinal);
        nombre1.setText(nombreFinal);
        apellido1.setText(apellidoFinal);
       // edad1.setText(edadFinal);

    }


    public void Atras(View view){
        Intent back = new Intent(this,dato1.class);
        startActivity(back);
    }


}