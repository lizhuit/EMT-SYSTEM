package gestor.empresarial.contrato;

//Enum es una manera de definir un tipo de datos que representa un conjunto fijo de constantes
// Declaración del enum llamado Cargos
public enum Cargos{
    // Definición de las constantes del enum
    confianza("Empleado (confianza)"),
    sindicalizado("Empleado (sindicalizado)"),
    temporal("Empleado (temporal)");
    private String nombre; //alamacena la descripcción asosiada a cada cargo

    Cargos(String nombre){//Constructor de Cargos
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return nombre;//devuelve el nombre de la constante emun
    }
}