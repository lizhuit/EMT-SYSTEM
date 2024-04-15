package gestor.empresarial.empleados;//Declara que esta clase pertenece al paquete gestor.empresarial
//Importa dos clases de otros paquetes
import gestor.empresarial.contrato.Cargos;
import gestor.empresarial.datos.DatosEmpresariales;
import gestor.errores.GestionErrores;
//Declara una clase abstracta Empleados que implementa la interfaz iEmpleados.
// Al ser abstracta, esta clase no puede ser instanciada
public abstract class Empleados implements iEmpleados {
    //Atibutos
    private DatosEmpresariales empleados[];
    private int i;
    public GestionErrores error;
    //Constructor sin parámetros
    public Empleados(){
        empleados = new DatosEmpresariales[10];
        i=0;
    }

    /*public void addEmpleados(String adscripcion, String telefonoExterior, String puesto, int idEmpleado)
    {
        empleados[i]=new DatosEmpresariales();
        empleados[i].setAdscripcion(adscripcion);
        empleados[i].setTelefonoExterior(telefonoExterior);
        empleados[i].setPuesto(puesto);
        empleados[i].setIdEmpleado(idEmpleado);
        i++;
    }

    public String getEmpleado(int i){
        String ads = empleados[i].getAdscripcion();
        String tel=  empleados[i].getTelefonoExterior();
        String pue= empleados[i].getPuesto();
        int id = empleados[i].getIdEmpleado();
        return ads + " - " + tel + " - " + pue + " - " + id;
    }*/



    //Método addDatosPersonales con paso de parámetros
    public void addDatosPersonales (String z, String y, String x){

    }
    //Método addContrato con pas de parámetros
    public void addContrato(int a, int b, Cargos c){

    }
    //Método findEmpleado que regresa un entero
    private int findEmpleado (int s){
        return s;
    }
    //Método  findEmpleado que regresa 0
    private int findEmpleado (String e){
        return 0;
    }
    //Método setWhatsApp con parámetros
    public void setWhatsApp (int h, String t){

    }
    //Metódo datosPersonales con parámetro y regresa null
    private String datosPersonales (int u){
        return null;
    }
    //Metódo getInfoEmpleado con parámetro y regresa null
    public String getInfoEmpleado (int a){
        return null;
    }
    //Metódo getInfoEmpleado con parámetro y regresa null
    public String getInfoEmpleado (String a){
        return null;
    }
    //Metódo setAdscripcion con parámetro
    public void setAdscripcion (int a, String b){

    }
    //Metódo setTelefonoExtension con parámetros
    public void setTelefonoExtension (int c, String s){

    }
    //Metódo setPuesto con parámetros
    public void setPuesto (int g, String t){

    }
    //Mostrar datos del empleado
    public void showDatosEmpleados(){

    }
    //Mostrar contratos
    public void showContradosEmpleados (int x){

    }
    //Método getAntiguedad que regresa w
    public int getAntiguedad (int w){
        return w;
    }
    //Método setCargo con paso de parámetro
    public void setCargo(Cargos r){

    }
}
