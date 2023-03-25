package com.example.gridfacil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView _grid;

    //array con datos que van dentro del grid
    String [] nombres={"Juan","Maria","Lucas","Karen","Luana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _grid=findViewById(R.id.grid);

        //metemos dentro del grid los nombres
        _grid.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,nombres));

        _grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //este string es para un toast del grid, nos muestra el nombre
                String texto =parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_LONG).show();

            }
        });
    }

    public void list(View view){
        Intent back = new Intent(this,list.class);
        startActivity(back);
    }

    public void spinner(View view){
        Intent back = new Intent(this,spinner.class);
        startActivity(back);
    }

}