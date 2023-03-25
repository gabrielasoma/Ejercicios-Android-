package com.example.gridfacil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class list extends AppCompatActivity {
    ListView _lista;
    String[] paises = {"Egipto","España","Mexico"};
    //para inflar valorer

    //se pone esto en el xml del list view para que carge datos por defecto
    //android:entries="@array/lista"


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        _lista =findViewById(R.id.list);

        _lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("valor :",parent.getItemAtPosition(position).toString());
            }
        });

        //inflamos el list
        _lista.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,paises));


    }
    public void atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}