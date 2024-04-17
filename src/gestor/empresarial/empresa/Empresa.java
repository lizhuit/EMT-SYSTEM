package gestor.empresarial.empresa;
//importar paquetes
import gestor.empresarial.empleados.Empleados;
import gestor.errores.GestionErrores;
//Declara la clase Empresa como final, lo que significa que no se puede heredar de ella.
public final class Empresa {
    //Atributos
    private String nombreEmpresa = "Itera Process";
    private String representanteLegal = "Roberto García";
    private String telefono = "222 298 6412";
    private String rfc = "GARO280698P71";
    public Empleados datosRH;
    public GestionErrores error;

    //Constructor de Empresa con paso de parámetros
    public Empresa (String a, String b){

    }
    //Método setRepresentanteLegal

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
    //Método getRepresentanteLegal, regresa representanteLegal
    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}
