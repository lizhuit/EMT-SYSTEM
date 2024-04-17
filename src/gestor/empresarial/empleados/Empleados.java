package gestor.empresarial.empleados;//Declara que esta clase pertenece al paquete gestor.empresarial

//Importa dos clases de otros paquetes
import gestor.empresarial.contrato.Cargos;
import gestor.empresarial.contrato.Contrato;
import gestor.empresarial.datos.DatosEmpresariales;
import gestor.empresarial.datos.DatosPersonales;
import gestor.errores.GestionErrores;
import gestor.interfaz.*;

import java.time.Year;

//Declara una clase abstracta Empleados que implementa la interfaz iEmpleados.
// Al ser abstracta, esta clase no puede ser instanciada
public final class Empleados implements iEmpleados {
    //Atibutos
    private DatosEmpresariales empreDatos[];
    private DatosPersonales persoDatos[];
    private Contrato contraDatos[];
        private int[] guard = new int[50];
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

    //Método addContrato con pas de parámetros
    public void addContrato(int indice, Contrato contrato) {
        this.contraDatos[indice] = contrato;
    }

    public void addDatosEmpresariales(int indice, DatosEmpresariales datosEmpresariales) {
        this.empreDatos[indice] = datosEmpresariales;
    }

    public void addContrato(int indice, Contrato contrato) {
        this.contraDatos[indice] = contrato;
    }


    //Método findEmpleado
    private int findEmpleado(int id) {
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
}






