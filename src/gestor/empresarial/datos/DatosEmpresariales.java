package gestor.empresarial.datos;

public final class DatosEmpresariales {
    //Atributos de la clase
    private String adscripcion;
    private String telefonoExterior;
    private String puesto;

    //Constructor
    public DatosEmpresariales(String adscripcion, String telefonoExterior, String puesto){
        this.adscripcion=adscripcion;
        this.telefonoExterior=telefonoExterior;
        this.puesto=puesto;
    }

    //getAdscripcion() y setAdscripcion() permiten obtener y establecer su valor de la variable.
    String getAdscripcion() {
        return adscripcion;
    }
    void setAdscripcion(String adscripcion) {
        this.adscripcion = adscripcion;
    }
    //getTelefonoExterior() y setTelefonoExterior() permiten obtener y establecer su valor de la variable.
    String getTelefonoExterior() {
        return telefonoExterior;
    }
    void setTelefonoExterior(String telefonoExterior) {
        this.telefonoExterior = telefonoExterior;
    }
    //getPuesto() y setPuesto() permiten obtener y establecer su valor de la variable.
    String getPuesto() {
        return puesto;
    }
    void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}