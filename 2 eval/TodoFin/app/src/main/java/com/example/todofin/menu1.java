package com.example.todofin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class menu1 extends AppCompatActivity {
    private TextView tvTexto;
    private static final int MnuOpc1=1;
    private static final int MnuOpc2=2;
    private static final int MnuOpc3=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);
        tvTexto = (TextView)findViewById(R.id.txTexto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE,MnuOpc1,Menu.NONE,"Opcion 1");
        menu.add(Menu.NONE,MnuOpc2,Menu.NONE,"Opcion 2");
        menu.add(Menu.NONE,MnuOpc3,Menu.NONE,"Opcion 3");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MnuOpc1: {
                tvTexto.setText("Menu2 : Opción 1 seleccionada");
                return true;
            }

            case MnuOpc2: {
                tvTexto.setText("Menu2 : Opción 2 seleccionada");
                return true;
            }
            case MnuOpc3: {
                tvTexto.setText("Menu2 : Opción 3 seleccionada");
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}