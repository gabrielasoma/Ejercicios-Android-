package com.example.gridfacil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class spinner extends AppCompatActivity {
    Spinner _spCiudades;
    String [] arrayPaises = {"Egipto","España","Mexico"};

    //manera estatica
    //android:entries="@array/ciudades"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        _spCiudades =findViewById(R.id.spCiudades);
        _spCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Ciudad elegida",parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        _spCiudades.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayPaises));
    }


    public void atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}