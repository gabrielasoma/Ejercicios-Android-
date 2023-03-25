package com.example.todofin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class menuSub extends AppCompatActivity {
    private TextView tvTexto;
    private static final int MnuOpc1=1;
    private static final int MnuOpc2=2;
    private static final int MnuOpc3=3;

    //Submenu del apartado 3
    private  static final int MNU_OPC3=4;
    private  static final int SMNU_OPC2=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sub);
        tvTexto = (TextView)findViewById(R.id.txTexto);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menuSub) {
        super.onCreateOptionsMenu(menuSub);
        menuSub.add(Menu.NONE,MnuOpc1,Menu.NONE,"Opcion 1");
        menuSub.add(Menu.NONE,MnuOpc2,Menu.NONE,"Opcion 2");
        menuSub.add(Menu.NONE,MnuOpc3,Menu.NONE,"Opcion 3");
        SubMenu smnu=menuSub.addSubMenu(Menu.NONE,MnuOpc3,Menu.NONE,"Opcion3");
        smnu.add(Menu.NONE,MNU_OPC3,Menu.NONE,"Opcion3.1"). setIcon(android.R.drawable.ic_menu_preferences);
        smnu.add(Menu.NONE,SMNU_OPC2,Menu.NONE,"Opcion3.2"). setIcon(android.R.drawable.ic_menu_agenda);

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
            case MNU_OPC3: {
                tvTexto.setText("Menu2 : Opción 3.1 seleccionada");
                return true;
            }
            case SMNU_OPC2: {
                tvTexto.setText("Menu2 : Opción 3.2 seleccionada");
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