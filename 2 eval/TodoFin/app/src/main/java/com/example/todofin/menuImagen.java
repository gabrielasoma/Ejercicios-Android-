package com.example.todofin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class menuImagen extends AppCompatActivity {
    private ImageView iv1;
    private static final int manzanas = 1;
    private static final int platanos = 2;
    private static final int peras = 3;
    private static final int golden = 11;
    private static final int doncella = 12;
    private static final int conferencia = 31;
    private static final int limonera = 32;
    private Menu smnu1, smnu2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_imagen);

        iv1 = (ImageView)findViewById(R.id.iv1);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //Submenu
        smnu1 = menu.addSubMenu(Menu.NONE,manzanas,Menu.NONE,"Manzanas");
        smnu1.add(Menu.NONE,golden,Menu.NONE,"Golden");
        smnu1.add(Menu.NONE,doncella,Menu.NONE,"Verde Doncella");

        //solo
        menu.add(Menu.NONE,platanos,Menu.NONE,"Plátanos");

        //Submenu
        smnu2 = menu.addSubMenu(Menu.NONE,peras,Menu.NONE,"Peras");
        smnu2.add(Menu.NONE,conferencia,Menu.NONE,"Conferencia");
        smnu2.add(Menu.NONE,limonera,Menu.NONE,"Limonera");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case golden: {
                iv1.setImageResource(R.drawable.a);
                return true;
            }


            case doncella: {
                iv1.setImageResource(R.drawable.b);
                return true;
            }

            case platanos: {
                iv1.setImageResource(R.drawable.c);
                return true;
            }

            case conferencia: {
                iv1.setImageResource(R.drawable.d);
                return true;
            }

            case limonera: {
                iv1.setImageResource(R.drawable.a);
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