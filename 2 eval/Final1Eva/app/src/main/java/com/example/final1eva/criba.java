package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class criba extends AppCompatActivity {

    private GridView gv1;
    private String numeros[];
    private EditText txtNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criba);

        gv1 = (GridView) findViewById(R.id.gv1);
        txtNum = (EditText) findViewById(R.id.txtNumero);

    }
        public void calcular(View v){
            boolean b = true;
            try {
                int n = Integer.parseInt(txtNum.getText().toString());
                numeros = new String[n];
            }
            catch(NumberFormatException e) {
                Toast.makeText(this, "Debe teclear un número", Toast.LENGTH_LONG).show();
                b = false;
            }

            if(b) {
                llenar(numeros);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.formatocriba, numeros);
                gv1.setAdapter(adapter);
            }
        }

        public void llenar(String v[]) {
            for(int i = 0; i < v.length; i++) {
                if(primo(i + 1)) {
                    v[i] = String.valueOf(i + 1);
                } else {
                    v[i] = "";
                }
            }
        }

        public boolean primo(int n) {
            int cont = 0;
            for(int i = 1; i <= n; i++) {
                if(n % i == 0) {
                    cont++;
                }
            }

            if(cont <= 2) {
                return true;
            } else {
                return false;
            }
        }

    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }




}