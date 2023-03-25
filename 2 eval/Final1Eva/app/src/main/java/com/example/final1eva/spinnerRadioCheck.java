package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;

public class spinnerRadioCheck extends AppCompatActivity {
    Spinner spnImagenes;
    ImageView imgFoto;
    CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_radio_check);

        spnImagenes = findViewById(R.id.spnImg);
        imgFoto = findViewById(R.id.fotos);

        /*Spinner de imagenes, cuando pulsas un boton se carga una imagens*/
        spnImagenes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i){
                    case 0:
                        imgFoto.setImageResource(R.drawable.ic_launcher_background);
                        break;
                    case 1:
                        imgFoto.setImageResource(R.drawable.f1);
                        break;
                    case 2:
                        imgFoto.setImageResource(R.drawable.f2);
                        break;
                    case 3:
                        imgFoto.setImageResource(R.drawable.f3);
                        break;
                    case 4:
                        imgFoto.setImageResource(R.drawable.f4);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


    public void OpcionRadio(View view){
        switch(view.getId()){
            case R.id.radio1:
                imgFoto.setImageResource(R.drawable.f1);
                break;
            case R.id.radio2:
                imgFoto.setImageResource(R.drawable.f2);
                break;
            case R.id.radio3:
                imgFoto.setImageResource(R.drawable.f3);
                break;
            case R.id.radio4:
                imgFoto.setImageResource(R.drawable.f4);
                break;
        }
    }

    public void OpcionCheck(View view){

        switch(view.getId()){

            case R.id.ch1:
                check= findViewById(R.id.ch1);

                if(check.isChecked()){
                    imgFoto.setImageResource(R.drawable.f1);
                }else{
                    imgFoto.setImageResource(R.drawable.ic_launcher_background);
                }
                break;

            case R.id.ch2:
                check= findViewById(R.id.ch2);

                if(check.isChecked()){
                    imgFoto.setImageResource(R.drawable.f2);
                }else{
                    imgFoto.setImageResource(R.drawable.ic_launcher_background);
                }
                break;
            case R.id.ch3:
                check= findViewById(R.id.ch3);

                if(check.isChecked()){
                    imgFoto.setImageResource(R.drawable.f3);
                }else{
                    imgFoto.setImageResource(R.drawable.ic_launcher_background);
                }
                break;

            case R.id.ch4:
                check= findViewById(R.id.ch4);

                if(check.isChecked()){
                    imgFoto.setImageResource(R.drawable.f4);
                }else{
                    imgFoto.setImageResource(R.drawable.ic_launcher_background);
                }
                break;

        }
    }



    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }


}