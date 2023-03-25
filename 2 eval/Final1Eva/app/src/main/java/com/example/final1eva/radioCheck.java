package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class radioCheck extends AppCompatActivity {

    EditText num1;
    EditText num2;

    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    CheckBox check4;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;

    Button b1;
    Button b2;
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_check);

        num1 = (EditText) findViewById(R.id.e1);
        num2 = (EditText) findViewById(R.id.e2);

        check1 = (CheckBox) findViewById(R.id.c1);
        check2 = (CheckBox) findViewById(R.id.c2);
        check3 = (CheckBox) findViewById(R.id.c3);
        check4 = (CheckBox) findViewById(R.id.c4);

        radio1 = (RadioButton) findViewById(R.id.r1);
        radio2 = (RadioButton) findViewById(R.id.r2);
        radio3 = (RadioButton) findViewById(R.id.r3);
        radio4 = (RadioButton) findViewById(R.id.r4);

        b1 = (Button) findViewById(R.id.btnCal);
        b2 = (Button) findViewById(R.id.btnCal1);
        t1 = (TextView) findViewById(R.id.text1);


    }

    //calcular radio
    public void calculando(View view) {

        String n1_String = num1.getText().toString();
        String n2_String = num2.getText().toString();

        int n1_int = Integer.parseInt(n1_String);
        int n2_int = Integer.parseInt(n2_String);

        if (radio1.isChecked() == true) {
            int suma = n1_int + n2_int;
            String resultado = String.valueOf(suma);
            t1.setText(resultado);
        } else if (radio2.isChecked() == true) {
            int resta = n1_int - n2_int;
            String resultado = String.valueOf(resta);
            t1.setText(resultado);

        } else if (radio3.isChecked() == true) {
            int multiplicar = n1_int * n2_int;
            String resultado = String.valueOf(multiplicar);
            t1.setText(resultado);

        } else if (radio4.isChecked() == true) {
            if (n2_int != 0) {
                int dividir = n1_int / n2_int;
                String resultado = String.valueOf(dividir);
                t1.setText(resultado);
            } else {
                Toast.makeText(this, "El segundo valor debe ser diferente de 0", Toast.LENGTH_LONG).show();
            }
        }
    }


    //calcular check
    public void calculando1(View view) {

        String n1_String = num1.getText().toString();
        String n2_String = num2.getText().toString();

        int n1_int = Integer.parseInt(n1_String);
        int n2_int = Integer.parseInt(n2_String);

        String resultado = "";


        if (check1.isChecked() == true) {
            int suma = n1_int + n2_int;
            resultado = "La suma es: " + suma + " / ";
        }

        if (check2.isChecked() == true) {
            int resta = n1_int - n2_int;
            resultado = resultado + "\nLa resta es: " + resta + " / ";
        }

        if (check3.isChecked() == true) {
            int multiplicar = n1_int * n2_int;
            resultado = resultado + "\nLa multiplicacion es: " + multiplicar + " / ";
        }
        if (check4.isChecked() == true) {
            if (n2_int != 0) {
                int dividir = n1_int / n2_int;
                resultado = resultado + "\nLa division es: " + dividir + " / ";
            } else {
            Toast.makeText(this, "El segundo valor debe ser diferente de 0", Toast.LENGTH_LONG).show();
            }
        }
        t1.setText(resultado);
    }


    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}



