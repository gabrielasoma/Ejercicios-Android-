package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Object View;
    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void uno(android.view.View view){
        Intent uno1 = new Intent(this,spinnerCalculadora.class);
        startActivity(uno1);
    }

    public void dos(android.view.View view){
        Intent dos1 = new Intent(this,parametro1.class);
        startActivity(dos1);
    }

    public void tres(android.view.View view){
        Intent tres1 = new Intent(this,spinnerRadioCheck.class);
        startActivity(tres1);
    }

    public void cuatro(android.view.View view){
        Intent cuatro1 = new Intent(this, mandarDatos1.class);
        startActivity(cuatro1);
    }

    public void cinco(android.view.View view){
        Intent cinco1 = new Intent(this, intentBundle1.class);
        startActivity(cinco1);
    }

    public void seis(android.view.View view){
        Intent seis1 = new Intent(this, operaciones.class);
        startActivity(seis1);
    }

    public void siete(android.view.View view){
        Intent siete1 = new Intent(this, alumno1.class);
        startActivity(siete1);
    }


    public void ocho(android.view.View view){
        Intent ocho1 = new Intent(this, radioCheck.class);
        startActivity(ocho1);
    }
    public void nueve(android.view.View view){
        Intent nueve1 = new Intent(this, arraysNum.class);
        startActivity(nueve1);
    }

    public void diez(android.view.View view){
        Intent diez1 = new Intent(this, dato1.class);
        startActivity(diez1);
    }

    public void once(android.view.View view){
        Intent once1 = new Intent(this, completo.class);
        startActivity(once1);
    }

    public void doce(android.view.View view){
        Intent doce1 = new Intent(this, toggle.class);
        startActivity(doce1);
    }

    public void trece(android.view.View view){
        Intent trece1 = new Intent(this, lista.class);
        startActivity(trece1);
    }
    public void catorce(android.view.View view){
        Intent catorce1 = new Intent(this, criba.class);
        startActivity(catorce1);
    }
    public void quince(android.view.View view){
        Intent quince1 = new Intent(this, imOp.class);
        startActivity(quince1);
    }

    public void dieciseis(android.view.View view){
        Intent dieciseis1 = new Intent(this, factura1.class);
        startActivity(dieciseis1);
    }
    public void diecisiete(android.view.View view){
        Intent diecisiete1 = new Intent(this, stwitch.class);
        startActivity(diecisiete1);
    }
    public void dieciocho(android.view.View view){
        Intent dieciocho1 = new Intent(this, img.class);
        startActivity(dieciocho1);
    }

    public void diecinueve(android.view.View view){
        Intent dieciocho1 = new Intent(this, spinnerOtro.class);
        startActivity(dieciocho1);
    }
    public void veinte(android.view.View view){
        Intent veinte1 = new Intent(this, gridLayout.class);
        startActivity(veinte1);
    }

    public void veinteuno(android.view.View view){
        Intent veinteuno1 = new Intent(this, TabHost1.class);
        startActivity(veinteuno1);
    }
    public void veintedos(android.view.View view){
        Intent veintedos1 = new Intent(this, TabHost2.class);
        startActivity(veintedos1);
    }
    public void veintetres(android.view.View view){
        Intent veintetres1 = new Intent(this, conectar.class);
        startActivity(veintetres1);
    }

    public void veintecuatro(android.view.View view){
        Intent veintecuatro1 = new Intent(this, relativeLayout.class);
        startActivity(veintecuatro1);
    }

}