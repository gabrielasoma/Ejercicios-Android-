package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class factura1 extends AppCompatActivity {
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;

    EditText e1;
    EditText e2;
    EditText e3;

    Button sol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura1);

        c1=(CheckBox) findViewById(R.id.cBici);
        c2=(CheckBox) findViewById(R.id.cPat);
        c3=(CheckBox) findViewById(R.id.cMono);

        e1 = (EditText) findViewById(R.id.eBici);
        e2 = (EditText) findViewById(R.id.ePat);
        e3 = (EditText) findViewById(R.id.eMono);

        sol = (Button) findViewById(R.id.btnIntento);

    }

    public void enviar(View view){
        Intent i = new Intent(factura1.this,factura2.class);
        Bundle bundle = new Bundle();
        String cad = "";
        boolean b = true;

        if(!c1.isChecked() && !c2.isChecked() && !c3.isChecked()){
            cad += "Debe seleccionar al menos un producto\n";
            b=false;
        }

        if((e1.getText().toString().isEmpty() || e1.getText().toString().equals(0))  && c1.isChecked() ){
            cad +="Indica la cantida de la bicicleta\n";
            b= false;
        }

        if((e2.getText().toString().isEmpty() || e2.getText().toString().equals(0))  && c2.isChecked()){
            cad +="Indica la cantida del patin\n";
            b= false;
        }

        if((e3.getText().toString().isEmpty() || e3.getText().toString().equals(0))  && c3.isChecked() ){
            cad +="Indica la cantida del monopatin\n";
            b= false;
        }


        //si la b es true
        if(b){
            if(c1.isChecked()){
                bundle.putString("bicicleta",c1.getText().toString());
                bundle.putInt("prebici",Integer.parseInt(e1.getText().toString()) * 2);
            }

            if(c2.isChecked()){
                bundle.putString("patin",c2.getText().toString());
                bundle.putInt("prepatin",Integer.parseInt(e2.getText().toString()) * 3);
            }
            if(c3.isChecked()){
                bundle.putString("mono",c3.getText().toString());
                bundle.putInt("premono",Integer.parseInt(e3.getText().toString()) * 5);
            }

            i.putExtras(bundle);
            startActivity(i);
        }else{
            Toast.makeText(factura1.this, cad,Toast.LENGTH_LONG).show();
        }

    }


    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }


}