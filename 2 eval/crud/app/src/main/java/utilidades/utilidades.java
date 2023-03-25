package utilidades;

//Constantes
public class utilidades {
    //Constantes campos tabla usuario
    public static String TABLA_USUARIO = "usuario";
    public static String CAMPO_ID= "id";
    public static String CAMPO_NOMBRE = "nombre";
    public static String CAMPO_TELEFONO= "telefono";


    //La linea de abajo deberia ir en la conexion
    //mirar el tipo de variable
    public static final String CREAR_TABLA_USUARIO ="CREATE TABLE "+ TABLA_USUARIO+" ("+CAMPO_ID+" Integer, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_TELEFONO+" TEXT)";


}
