package gestor.errores;
//Se importa el paquete java.util.* para usar las clases y las interfaces que contiene, como Map.
//import gestor.archivos.ArchivoTexto;
import gestor.archivos.ArchivoTexto;


public class GestionErrores {
    //private HashMap<Integer, String> error;
    private MapaErrores mapaErrores;
    private ArchivoTexto archivoTexto;

    private String description;

    //Constructor GestionErrores
    public GestionErrores(){
        //Instancia
        //error = new HashMap<Integer, String>();
        mapaErrores=new MapaErrores();
        archivoTexto=new ArchivoTexto("ERRORES");
    }
    //Métodos

    public String getDescription(int noErrror){ //
        description=mapaErrores.MensajeError(noErrror);
        escribirEnArchivo(noErrror,description);
        return description;
    }



    private void escribirEnArchivo(int noError,String description){
        archivoTexto.AbrirModoEscritura();
        archivoTexto.Escribir("NUMERO DE ERROR: " +noError);
        archivoTexto.Escribir("ERROR: " +description);
        archivoTexto.Cerrar();
    }

}