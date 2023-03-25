package com.example.todofin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity {
    //variable
    private TextView tvTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //variable
        tvTexto = (TextView)findViewById(R.id.tvTexto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnOpc1: {
                tvTexto.setText("Opción 1 seleccionada");
                return true;
            }


            case R.id.mnOpc2: {
                tvTexto.setText("Opción 2 seleccionada");
                return true;
            }

            case R.id.mnOpc3: {
                tvTexto.setText("Opción 3 seleccionada");
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }


}