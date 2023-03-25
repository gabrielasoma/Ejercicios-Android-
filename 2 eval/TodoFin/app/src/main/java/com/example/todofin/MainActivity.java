package com.example.todofin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void primero(View view){
        Intent back = new Intent(this,MenuPrincipal.class);
        startActivity(back);
    }

    public void dos(View view){
        Intent back = new Intent(this,menu1.class);
        startActivity(back);
    }
    public void Tres(View view){
        Intent back = new Intent(this,menuSub.class);
        startActivity(back);
    }
    public void Cuatro(View view){
        Intent back = new Intent(this,menuImagen.class);
        startActivity(back);
    }

    public void Cinco(View view){
        Intent back = new Intent(this,framentoUno.class);
        startActivity(back);
    }
}