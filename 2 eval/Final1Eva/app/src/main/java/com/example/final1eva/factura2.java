package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class factura2 extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TextView t3;
    TextView total;

    String b_s;
    String p_s;
    String m_s;

    Integer b_i;
    Integer p_i;
    Integer m_i;
    Integer t_i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura2);

        t1=(TextView) findViewById(R.id.tBici);
        t2=(TextView) findViewById(R.id.tPatin);
        t3=(TextView) findViewById(R.id.tMono);
        total=(TextView) findViewById(R.id.tTotal);

        Bundle bundle = getIntent().getExtras();
        b_s =  bundle.getString("bicicleta");
        p_s =  bundle.getString("patin");
        m_s =  bundle.getString("moto");

        b_i = bundle.getInt("prebici",0);
        p_i = bundle.getInt("prepatin",0);
        m_i = bundle.getInt("premono",0);

        calcular();
    }

    public void calcular(){
        if(b_i !=0){
            t1.setText(String.valueOf(b_i) + "€");
        }
        if(p_i !=0){
            t2.setText(String.valueOf(p_i) + "€");
        }
        if(m_i !=0){
            t3.setText(String.valueOf(m_i) + "€");
        }
        t_i = b_i + p_i + m_i;
        total.setText(String.valueOf(t_i) + "€");
    }

    public void Atras(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}
