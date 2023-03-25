package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class arraysNum extends AppCompatActivity {

    int num [] =new int [10];
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrays_num);

        b= findViewById(R.id.btnd);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<num.length;i++){
                    num[i]=(i+1);
                }
                Intent i =new Intent(arraysNum.this,arraysNum2.class);
                i.putExtra("num",num);
                startActivity(i);
            }
        });

    }



    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}