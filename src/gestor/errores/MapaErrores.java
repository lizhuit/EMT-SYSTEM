package gestor.errores;

//se utilizan para manejar la estructura de datos del mapa.
import java.util.Map;
import java.util.HashMap;

//creamos la clase MapaErrores y dentro de esta se encuentra el constructor
public class MapaErrores {

    //Se declara un mapa llamado error que mapea enteros a texto.
    private Map<Integer, String> error;

    //se inicializa el mapa error como un nuevo objeto HashMap y se llama al método listaErrores()
    //para poblar el mapa con los mensajes de error correspondientes a los códigos.
    public MapaErrores(){
        error=new HashMap<>();
        listaErrores();
    }
    //función en donde colocamos los mensajes de error para usarlos en el progrma:
    private void listaErrores(){
        error.put(1, "Hay campos incompletos:");
        error.put(2, "Contraseña o Usuario incorrectos");
        error.put(3, "¡UPS! hay campos vacíos");
        error.put(4, "Seleccione un empleado");
        error.put(5, "Datos repetidos");
        error.put(6, "Error 404");
        error.put(7, "Error capa 8 :)");
    }

    //recibe el número del error como paso de parametros
    public String MensajeError(int errorCodigo) {
        return error.get(errorCodigo);
    }

}
