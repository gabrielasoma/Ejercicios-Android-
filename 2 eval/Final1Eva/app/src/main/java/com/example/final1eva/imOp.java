package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class imOp extends AppCompatActivity {

    ImageView ivCaceres, ivAvila, ivCordoba, ivZaragoza;
    RadioButton rbCaceres, rbAvila, rbCordoba, rbZaragoza;
    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_im_op);

        ivAvila = (ImageView)findViewById(R.id.ivAvila);
        ivCaceres = (ImageView)findViewById(R.id.ivCaceres);
        ivCordoba = (ImageView)findViewById(R.id.ivCordoba);
        ivZaragoza = (ImageView)findViewById(R.id.ivZaragoza);

        rbAvila = (RadioButton)findViewById(R.id.rbAvila);
        rbCaceres = (RadioButton)findViewById(R.id.rbCaceres);
        rbCordoba = (RadioButton)findViewById(R.id.rbCordoba);
        rbZaragoza = (RadioButton)findViewById(R.id.rbZaragoza);

        tv1 = (TextView)findViewById(R.id.tv1);
    }

    public void avila (View v) {
        if(rbAvila.isChecked()) {
            tv1.setText("¡Acierto!");
        }else {
            tv1.setText("¡Error!");
        }
    }

    public void caceres (View v) {
        if(rbCaceres.isChecked()) {
            tv1.setText("¡Acierto!");
        }else{
            tv1.setText("¡Error!");
        }
    }

    public void cordoba (View v) {
        if(rbCordoba.isChecked()) {
            tv1.setText("¡Acierto!");
        }else {
            tv1.setText("¡Error!");
        }
    }


    public void zaragoza (View v) {
        if(rbZaragoza.isChecked()) {
            tv1.setText("¡Acierto!");
        } else {
            tv1.setText("¡Error!");
        }
    }


    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}