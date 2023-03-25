package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class toggle extends AppCompatActivity {
    ToggleButton to1;
    TextView t1;
    ImageView im;

    RadioButton r1;
    RadioButton r2;

    CheckBox c1;
    CheckBox c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);


        to1 = (ToggleButton)findViewById(R.id.tog);
        t1 =(TextView) findViewById(R.id.to1);
        im=(ImageView) findViewById(R.id.img);

        r1 =(RadioButton) findViewById(R.id.rad1);
        r2 =(RadioButton) findViewById(R.id.rad2);





    }

    //togle
    public void mandar(View view) {
        if (view.getId() == R.id.tog) {
            if (to1.isChecked()) {
                t1.setText("Boton on");
                im.setImageResource(R.drawable.f1);
            } else {
                t1.setText("Boton off");
                im.setImageResource(R.drawable.f2);
            }
        }
    }

    //radios
    public void radios(View view){
            if (r1.isChecked()) {
                im.setImageResource(R.drawable.f1);
            } else {
                im.setImageResource(R.drawable.f2);
            }
    }
/*
    public void check(View view){

                if(c1.isChecked()){
                    im.setImageResource(R.drawable.f1);
                }else{
                    im.setImageResource(R.drawable.ic_launcher_background);
                }


                if(c2.isChecked()){
                    im.setImageResource(R.drawable.f2);
                }else{
                    im.setImageResource(R.drawable.ic_launcher_background);
                }


        */




    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);



    }
}