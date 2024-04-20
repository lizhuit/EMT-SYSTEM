package gestor.empresarial.empresa;
//importar paquetes
import gestor.empresarial.empleados.Empleados;
import gestor.errores.GestionErrores;
//Declara la clase Empresa como final, lo que significa que no se puede heredar de ella.
public final class Empresa {
    //Atributos y algunos los inicializamos
    private String nombreEmpresa = "Itera Process"; //Nombre de la Empresa
    private String representanteLegal = "Roberto García"; //Nombre del representante
    private String telefono = "222 298 6412"; //Telefono
    private String rfc = "GARO280698P71"; //RFC
    public Empleados datosRH; //Atributo de tipo Empleados
    public GestionErrores error; //Atributo de tipo GestionErrores

    //Constructor de Empresa con paso de parámetros
    public Empresa (String a, String b){

    }

    //SET y GET para NombreEmpresa
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    //SET y GET para RepresentanteLegal
    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    //SET y GET para Telefono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //SET y GET para rfc
    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}
