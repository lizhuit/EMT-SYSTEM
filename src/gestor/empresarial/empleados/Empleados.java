package gestor.empresarial.empleados;//Importa dos clases de otros paquetes
import gestor.empresarial.contrato.*;
import gestor.empresarial.datos.*;
import gestor.empresarial.empleados.iEmpleados;
import gestor.errores.GestionErrores;
import java.time.Year;

//Declara una clase abstracta Empleados que implementa la interfaz iEmpleados.
// Al ser abstracta, esta clase no puede ser instanciada
public final class Empleados implements iEmpleados {
    //Atibutos
    private DatosEmpresariales empreDatos[];
    private DatosPersonales persoDatos[];
    private Contrato contraDatos[];
    public int[] guard = new int[50];
    private static Empleados instancia;
    private int i;
    public GestionErrores error;

    //Constructor sin parámetros
    public Empleados() {
        i = 0;
        instancia = null;
        empreDatos = new DatosEmpresariales[50];
        persoDatos = new DatosPersonales[50];
        contraDatos = new Contrato[50];
    }

    //Mantener datos
    public static Empleados getInstancia() {
        if (instancia == null) {
            instancia = new Empleados();
        }
        return instancia;
    }

    //Método addDatosPersonales con paso de parámetros
    public void addDatosPersonales(DatosPersonales datosPersonales) {
        this.persoDatos[this.i] = datosPersonales;
        guard[i] = i + 1;
        this.i++;
    }

    public void imprimirDatos(){
        if(datosPerVacios() == false){
            for(int j=0; j<50; j++){
                if (persoDatos[j] != null){
                    String nombre = persoDatos[j].getNombre();
                    String correo = persoDatos[j].getCorreo();
                    String whatsapp = persoDatos[j].getWhatsapp();
                    System.out.println("Id: "+guard[j]+"\tNombre: "+nombre + "\tCorreo: "+correo + "\tWhatsapp: "+whatsapp);
                }
            }
        }
        if (datosEmpVacios() == false){
            for(int j=0; j<100; j++){
                if (empreDatos[j] != null){
                    String telefono = empreDatos[j].getTelefonoExterior();
                    String extencion = empreDatos[j].getExtension();
                    String adscripcion = empreDatos[j].getAdscripcion();
                    String puesto = empreDatos[j].getPuesto();
                    System.out.println("ID:" + guard[j] + "\tTelefono:" + telefono + "\tExtension:" + extencion + "\tAdscripcion:" + adscripcion + "\tPuesto:" + puesto);
                }
            }
        }

        if (datosContratoVacios() == false){
            for(int j=0; j<100; j++){
                if (contraDatos[j] != null){
                    int noContrato = contraDatos[j].getNoContrato();
                    int annio = contraDatos[j].getAnnio();
                    String horario = contraDatos[j].getHorario();
                    Cargos tipoCargo = contraDatos[j].getTipoCargo();
                    System.out.println("ID:" + guard[j] + "\tNoConctato:" + noContrato + "\tAnnio:" + annio + "\tHorario:" + horario + "\tCargo:" + tipoCargo);
                }
            }
        }
    }

    //Método addContrato con pas de parámetros
    /*public void addContrato(int indice, Contrato contrato) {

        this.contraDatos[indice] = contrato;
    }*/

    public void addDatosEmpresariales(int indice, DatosEmpresariales datosEmpresariales) {
        this.empreDatos[indice] = datosEmpresariales;
    }

    public void addContrato(int indice, Contrato contrato) {
        this.contraDatos[indice] = contrato;
    }


    //Método findEmpleado
    public int findEmpleado(int id) {
        int indice = -1;
        for (int j = 0; j < 50; j++) {
            if (guard[j] == id) {
                indice = j;
                break;
            }
        }
        return indice;
    }

    //Método  findEmpleado
    private int findEmpleado(String nombre) {
        int indice = -1;
        for (int j = 0; j < 50; j++) {
            if (persoDatos[j] != null && persoDatos[j].getNombre().equals(nombre)) {
                indice = j;
                break;
            }
        }
        return indice;
    }

    public int getId(int indice){

        return guard[indice];
    }

    public DatosPersonales getInfoPersonal(int indice) {
        DatosPersonales datosPersonales = this.persoDatos[indice];
        return datosPersonales;
    }

    public DatosEmpresariales getInfoEmpresarial(int indice) {
        DatosEmpresariales datosEmpresariales = this.empreDatos[indice];
        return datosEmpresariales;
    }

    public Contrato getInfoContrato(int indice) {
        Contrato contrato = this.contraDatos[indice];
        return contrato;
    }

    //Mostrar datos del empleado
    public void showDatosEmpleados() {

    }

    //Mostrar contratos
    public void showContradosEmpleados(int x) {

    }

    //Método getAntiguedad que regresa w
    public int getAntiguedad(int annio) {
        int antiguedad = Year.now().getValue() - annio;
        return 0;
    }

    //Método setCargo con paso de parámetro
    public void setCargo(Cargos r) {

    }



    public boolean datosPerVacios(){
        int suma=0;
        boolean vacio;
        for(int j=0; j<50; j++){
            if(persoDatos[j] != null){
                suma += 1;
            }
        }
        if (suma>0){
            vacio = false;
        }else{
            vacio = true;
        }
        return vacio;
    }

    public boolean datosEmpVacios(){
        int suma=0;
        boolean vacio;
        for(int j=0; j<50; j++){
            if(empreDatos[j] != null){
                suma += 1;
            }
        }
        if (suma>0){
            vacio = false;
        }else{
            vacio = true;
        }
        return vacio;
    }

    public boolean datosContratoVacios(){
        int suma=0;
        boolean vacio;
        for(int j=0; j<50; j++){
            if(contraDatos[j] != null){
                suma += 1;
            }
        }
        if (suma>0){
            vacio = false;
        }else{
            vacio = true;
        }
        return vacio;
    }


    @Override
    public String getInfoEmpleado(int a) {
        return null;
    }

    @Override
    public String getInfoEmpleado(String a) {
        return null;
    }

    @Override
    public void showDatosEmpleado() {

    }

    @Override
    public int getAntiguedad() {
        return 0;
    }

    //metodo duplicado de datos
    public boolean buscarDuplicadosP(int id, String nombre, String whatsapp, String correo){
        boolean hayDuplicados = false;
        for(int j=0; j<50; j++){
            DatosPersonales obj = getInfoPersonal(j);
            if (obj != null){
                int idP = guard[j];
                String nombreP = obj.getNombre();
                String whatsP = obj.getWhatsapp();
                String correoP = obj.getCorreo();
                if(idP == id || nombreP.equals(nombre) || whatsP.equals(whatsapp) || correoP.equals(correo)){
                    hayDuplicados = true;
                    break;
                }
            }
        }
        return hayDuplicados;
    }
}




