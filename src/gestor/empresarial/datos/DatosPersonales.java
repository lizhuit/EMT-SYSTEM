package gestor.empresarial.datos;

public class DatosPersonales {
    //Atributos de la clase
    private int Id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String whatsapp;

    public DatosPersonales(String nombre,String whatsapp,String correo){//Constructor con parámetros
        //Asignar valores de los parámetros a las variables de instancia
        this.nombre=nombre;
        this.whatsapp=whatsapp;
        this.correo=correo;
        this.apellidos=apellidos;

    }


    //getId() y setId() permiten obtener y establecer su valor de la variable.
    protected int getId() {/*está publico para all archivo*/
        return Id;
    }
    protected void setId(int id) {
        this.Id = id;
    }
    //getNombre() y setNombre() permiten obtener y establecer su valor de la variable.
    public String getNombre() {
        return nombre;
    }
    protected void setNombre(String nombre) {
         this.nombre = nombre;
    }
    //getApellido() y setApellido() permiten obtener y establecer su valor de la variable.
    protected String getApellidos() {
        return apellidos;
    }
    protected void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //getWhatsapp() y setWhatsapp() permiten obtener y establecer su valor de la variable.
    public String getWhatsapp() {
        return whatsapp;
    }
    protected void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
    //getCorreo() y setCorreo() permiten obtener y establecer su valor de la variable.
    public String getCorreo() {
        return correo;
    }
    protected void setCorreo(String correo) {
       this.correo = correo;
    }
}
