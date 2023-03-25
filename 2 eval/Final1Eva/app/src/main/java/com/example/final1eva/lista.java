package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class lista extends AppCompatActivity {

    private TextView txt;
    private ListView list;
    private String paises[] = {"Alemania", "Andorra", "Austria", "España", "Francia", "Italia", "Portugal", "Reino Unido", "Rusia", "San Marino", "Suiza", "Vaticano"};
    private String poblacion[] = {"81.861.000", "77.000", "8.457.000", "47.244.000", "63.604.000", "59.649.000", "10.588.000", "63.214.000", "143.184.000", "32.000", "7.986.000", "800"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        txt = (TextView) findViewById(R.id.texto);
        list = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listas, paises);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txt.setText(poblacion[i]);
            }
        });
    }

    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }

}