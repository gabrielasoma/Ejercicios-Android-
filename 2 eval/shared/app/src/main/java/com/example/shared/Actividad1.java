package com.example.shared;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;



public class Actividad1 extends AppCompatActivity {
    private EditText et1;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        et1 = (EditText) findViewById(R.id.etIntentos);

    }

    @Override
    protected void onPause()
    {
        super.onPause();

        bundle.putInt("Intentos", Integer.parseInt(et1.getText().toString()));

        Intent i = new Intent(this, MainActivity.class);
        i.putExtras(bundle);
        startActivity(i);
    }
}
