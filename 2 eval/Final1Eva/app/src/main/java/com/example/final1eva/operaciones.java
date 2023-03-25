package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class operaciones extends AppCompatActivity {
    EditText num1;
    EditText num2;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    TextView sol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);

        num1 =(EditText)findViewById(R.id.edit1);
        num2 =(EditText)findViewById(R.id.edit2);

        btn1=(Button)findViewById(R.id.suma);
        btn2=(Button)findViewById(R.id.resta);
        btn3=(Button)findViewById(R.id.multiplicar);
        btn4=(Button)findViewById(R.id.dividir);

        sol= (TextView) findViewById(R.id.textSol);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suma();
            }

            public void suma(){
                double x;
                double y;
                double total;

                x= Integer.parseInt(num1.getText().toString());
                y= Integer.parseInt(num2.getText().toString());

                total = x+y;
                sol.setText(String.valueOf(total));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resta();
            }
            public void resta(){
                double x;
                double y;
                double total;

                x= Integer.parseInt(num1.getText().toString());
                y= Integer.parseInt(num2.getText().toString());

                total = x-y;
                sol.setText(String.valueOf(total));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mult();
            }
            public void mult(){
                double x;
                double y;
                double total;

                x= Integer.parseInt(num1.getText().toString());
                y= Integer.parseInt(num2.getText().toString());

                total = x*y;
                sol.setText(String.valueOf(total));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                div();
            }
            public void div(){
                double x;
                double y;
                double total;

                x= Integer.parseInt(num1.getText().toString());
                y= Integer.parseInt(num2.getText().toString());

                total = x/y;
                sol.setText(String.valueOf(total));
            }
        });

    }



    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}