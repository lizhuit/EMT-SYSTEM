package gestor.empresarial.contrato;

import gestor.interfaz.Contrato;
import java.util.List;
import java.util.ArrayList;

// Declaración de la clase Contrato
public final class Contrato {//final evita que sea heredada
    // Declaración de los atributos de la clase
    private int id;
    private int noContrato;
    private int anio;
    private String horario;
    private Cargos tipoCargo;

    // Constructor de la clase Contrato
    public Contrato(int id, int noContrato, int anio, String horario, Cargos tipoCargo){ // parámetros
        // Inicialización del tipo de cargo
        tipoCargo = Cargos.confianza;
        tipoCargo = Cargos.sindicalizado;
        tipoCargo = Cargos.temporal;

        this.tipoCargo = tipoCargo;
        this.horario = horario;
        this.noContrato = noContrato;
        this.anio = anio;
    }
    // Métodos setter y getter
    public void setTipoCargo(Cargos tipoCargo){
        this.tipoCargo = tipoCargo;
    }
    public void setNoContrato(int noContrato) {
        this.noContrato = noContrato;
    }
    public int getNoContrato() {
        return noContrato;//regresa noContrato
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

    public Cargos getTipoCargo() {
        return tipoCargo;
    }
}