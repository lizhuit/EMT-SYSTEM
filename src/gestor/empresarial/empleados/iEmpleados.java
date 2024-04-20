package gestor.empresarial.empleados;
//Inteface iEmpleados
//Solo se arma esqueleto para utilizarlo en la clase Derivada(Empleados)
public interface iEmpleados {//Contarto con la clase que implementa la  interfaz
    public String getInfoEmpleado(int emple);//sobre carga de métodos
    public String getInfoEmpleado (String a); //sobre carga de métodos
    public void showDatosEmpleado(); //no toma ningún parámetro y no retorna nada
    public int getAntiguedad();
}
