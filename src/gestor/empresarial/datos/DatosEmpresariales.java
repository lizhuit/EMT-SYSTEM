package gestor.empresarial.datos;

public final class DatosEmpresariales {
    //Atributos de la clase
    private String adscripcion;
    private String telefonoExterior;
    private String puesto;
    private String extension;


    //Constructor
    public DatosEmpresariales(String telefonoExterior,String extension,String adscripcion,String puesto){
        this.telefonoExterior=telefonoExterior;
        this.extension=extension;
        this.adscripcion=adscripcion;
        this.puesto=puesto;
    }

    //getAdscripcion() y setAdscripcion() permiten obtener y establecer su valor de la variable.
    public String getAdscripcion() {
        return adscripcion;
    }
    void setAdscripcion(String adscripcion) {
        this.adscripcion = adscripcion;
    }
    //getTelefonoExterior() y setTelefonoExterior() permiten obtener y establecer su valor de la variable.
    public String getTelefonoExterior() {
        return telefonoExterior;
    }
    void setTelefonoExterior(String telefonoExterior) {
        this.telefonoExterior = telefonoExterior;
    }
    //getPuesto() y setPuesto() permiten obtener y establecer su valor de la variable.
    public String getPuesto() {
        return puesto;
    }
    void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}