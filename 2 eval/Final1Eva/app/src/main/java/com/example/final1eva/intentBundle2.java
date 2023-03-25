package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class intentBundle2 extends AppCompatActivity {

    TextView persona;
    TextView imc1;
    TextView des;
    TextView consejo;
    

    String n;
    double e;
    double p;
    double a;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_bundle2);

        persona =(TextView) findViewById(R.id.textPersona);
        imc1 =(TextView) findViewById(R.id.textImc);
        des =(TextView) findViewById(R.id.textDesc);
        consejo=(TextView) findViewById(R.id.textCons);

        Bundle i= getIntent().getExtras();

        n = i.getString("nombre");
        e=i.getDouble("edad");
        p=i.getDouble("peso");
        a=i.getDouble("altura");

        mensajeR();

    }

    public double imc(double peso, double altura){
        double res =0;
        res= peso/(altura*altura);
        return res;

    }

    public void mensajeR() {

        persona.setText("");
        imc1.setText("");
        des.setText("");
        consejo.setText("");

        String diag = "";
        String con = "";

        persona.setText("Nombre: " +n +"\nEdad: :"+ e);

        double sol = imc(p, a);
        imc1.setText("IMC: " + sol);


        if (sol > 40) {
            diag = "Obesidad morbida";
            con = "Ve a un hospital";
        } else if (sol >= 30) {
            diag = "Obesidad";
            con = "No comas tanto";

        } else if (sol >= 25) {
            diag = "Sobrepeso";
            con = "Haz ejercicio";

        } else if (sol >= 18.5) {
            diag = "Peso normal";
            con = "Muy bien";
        } else {
            diag = "Bajo peso";
            con = "Puedes comer algo";
        }

        des.setText("Tu diagnostico es: " + diag);
        consejo.setText("Consejo :" +con);

    }

    public void Atras(View view){
        Intent back = new Intent(this,intentBundle1.class);
        startActivity(back);
    }
}