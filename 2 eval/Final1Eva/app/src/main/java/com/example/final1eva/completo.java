package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class completo extends AppCompatActivity {
    EditText nombre;
    EditText email;
    EditText direccion;
    EditText edad;

    Button b1;

    Spinner sp;

    RadioButton r1;
    RadioButton r2;

    CheckBox c1;
    CheckBox c2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completo);

        nombre = findViewById(R.id.ed1);
        email = findViewById(R.id.ed2);
        edad = findViewById(R.id.ed3);
        direccion = findViewById(R.id.ed4);


        b1 = findViewById(R.id.btnGuardar);
        sp = findViewById(R.id.spinner);
        r1 = findViewById(R.id.rbt1);
        r2 = findViewById(R.id.rbt2);

        c1 = findViewById(R.id.cb1);
        c2 = findViewById(R.id.cb2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombre.getText().toString().equals("") || email.getText().toString().equals("")) {
                    Toast.makeText(completo.this, "Debe agregar nombre y correo", Toast.LENGTH_LONG);
                } else {
                    Intent i = new Intent(completo.this, completo1.class);
                    i.putExtra("nombre", nombre.getText().toString());
                    i.putExtra("edad", Integer.parseInt(edad.getText().toString()));
                    i.putExtra("email", email.getText().toString());
                    i.putExtra("direccion", direccion.getText().toString());
                    i.putExtra("sp", sp.getSelectedItem().toString());

                    //radio
                    String horario = "";
                    if (r1.isChecked()) {
                        horario = "Tiempo completo";
                    } else {
                        horario = "Medio tiempo";
                    }
                    i.putExtra("tiempo", horario);

                    //check
                    String sit = "";
                    boolean b;

                    if (!c1.isChecked() && !c2.isChecked()) {
                        sit += "Debe seleccionar al menos un producto\n";
                        b = false;
                    }

                    if (c1.isChecked() == true) {
                        sit = "terraza " +  "/ ";
                        b = true;
                    }

                    if (c2.isChecked() == true) {
                        sit = sit +" mesa";
                        b = true;
                    }

                    if (b = true) {
                        if (c1.isChecked()) {
                            i.putExtra("sitio",sit);
                        }
                        if (c2.isChecked()) {
                            i.putExtra("sitio",sit);
                        }

                        startActivity(i);
                    }

                }
            }
        });
    }

        public void Atras (View view){
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);

    }
}