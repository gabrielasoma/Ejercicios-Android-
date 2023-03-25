package com.example.bitacorafichero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_bitacora);

        //para que la info se quede cuando se cierre la app

        //devuelve array de fichero almacenado en la app, busca todos los ficheros que hayas creado y una vez que se recuperen se ponen en el array de archivos
        String archivos[] = fileList();

        //condicional si lo encuentra o no
        if (ArchivoExiste(archivos, "bitacora.txt")) {
            try {//es obligatorio poner el try catch
                //Esta clase nos permite abrir un archivo para leerlo, openFileInput es un metodo que nos permite indicar cual es el archivo que queremos abrir
                InputStreamReader archivo = new InputStreamReader(openFileInput("bitacora.txt"));
                //buffer nos permite leer que abrimos previamente
                BufferedReader br = new BufferedReader(archivo);//le mandamos el archivo que hemos abierto

                //indicamos linea por linea todo el texto que contiene nuestro archivo
                String linea = br.readLine();

                //GUarda todo el texto que vaya encontrando en el archivo bitacora
                String bitacoraCompleta = "";

                while (linea != null) {
                    bitacoraCompleta = bitacoraCompleta + linea + "\n";
                    linea = br.readLine();//cada que lea una linea va a seguir agregando linea hasta que no encuentre ninguna
                }
                br.close();
                archivo.close();

                et1.setText(bitacoraCompleta);

            } catch (IOException e) {

            }
        }

    }

    private boolean ArchivoExiste(String archivos [], String NombreArchivo) {
        //metodo booleano permite no usar metodos de apertura y cierre
        for(int i =0; i< archivos.length; i++)
            //recorre hasta que encuentra el nombre de nuestro archivo pitacora.txt
            if(NombreArchivo.equals(archivos[i]))
                return true;
            return false;
    }

    //metodo para boton guardar
    public void Guardar(View view){
        try {
            //sirve para indicar que mandamos texto de un archivo que vamos a escribir
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));

            //metodo que permite escribir en bitacura.txt desde el plain
            archivo.write(et1.getText().toString());

            //con flush limpiamos
            archivo.flush();

            archivo.close();



        }catch (IOException e){

        }
        Toast.makeText(this,"Bitacora guardada correctamente",Toast.LENGTH_SHORT).show();
        finish();
    }
}