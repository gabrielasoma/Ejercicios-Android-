package com.example.crudcompletoultimo.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudcompletoultimo.MainActivity;
import com.example.crudcompletoultimo.R;

public class NuevoActivity extends AppCompatActivity {
    EditText txtNombre, txtTelefono, txtCorreo;
    Button bGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre =(EditText) findViewById(R.id.txtNombre);
        txtTelefono =(EditText) findViewById(R.id.txtTelefono);
        txtTelefono =(EditText) findViewById(R.id.txtCorreo);
        bGuardar =(Button)findViewById(R.id.btnGuardar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbContactos dbContactos = new DbContactos(NuevoActivity.this);

                long id= dbContactos.insertarContacto(txtNombre.getText().toString(),txtTelefono.getText().toString(),txtCorreo.getText().toString());

                if(id > 0){
                    Toast.makeText(NuevoActivity.this, "Registro guardado",Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(NuevoActivity.this, "Error al guardar registro",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void limpiar(){
        txtNombre.setText(" ");
        txtTelefono.setText(" ");
        txtCorreo.setText(" ");
    }

}