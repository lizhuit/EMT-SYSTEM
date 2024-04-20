package gestor.empresarial.contrato;

import gestor.empresarial.empleados.*;

// Declaración de la clase Contrato
public final class Contrato {//final evita que sea heredada
    // Declaración de los atributos de la clase
    private int id;
    private int noContrato;
    private int anio;
    private String horario;
    private Cargos tipoCargo;

    // Constructor de la clase Contrato
    public Contrato(int noContrato, int anio, Cargos tipoCargo){ // parámetros
        // Inicialización del tipo de cargo
        tipoCargo = Cargos.confianza;
        tipoCargo = Cargos.sindicalizado;
        tipoCargo = Cargos.temporal;

        this.noContrato = noContrato;
        this.anio = anio;
        this.horario = horario;
        this.tipoCargo = tipoCargo;

    }
    // Métodos setter y getter
    public int getNoContrato() {
        return noContrato;//regresa noContrato
    }
    public void setNoContrato(int noContrato) {
        this.noContrato = noContrato;
    }
    public void setAnnio(int anio) {
        this.anio = anio;
    }
    public int getAnnio() {
        return anio;//regresa año
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Cargos getTipoCargo() { /*Cargos(String nombre){//Constructor de Cargos
                                            this.nombre = nombre;
                                    }*/
        return tipoCargo;
    }
    public void setTipoCargo(Cargos tipoCargo){
        this.tipoCargo = tipoCargo;
    }
}