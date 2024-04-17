package gestor.archivos;

import java.io.File;

class ControlArchivos{//clase padre
    private String archivo;//atributo

    public ControlArchivos(){//constructor
        this.archivo = archivo; //instanciar archivo
    }
    public boolean Crear(){//Para crear un archivo nuevo
        File file = new File(archivo);
        try{
            if (file.exists()){
                System.out.println("El archivo ya existe.");
                return false;
            }
            else {
                if (file.createNewFile()){
                    System.out.println("Se ha creado el archivo exitosamente.");
                    return false;
                } else{
                    System.out.println("No se puede crear el archivo.");
                    return false;
                }
            }
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
    public boolean Eliminar() {
        File file = new File(archivo);
        try {
            if (file.exists()) {//si el archivo existe se hará lo siguiente:
                if (file.delete()) {
                    System.out.println("El archivo ha sido eliminado exitosamente.");
                    return true;
                }
                else {
                    System.out.println("El archivo no puede ser eliminado.");
                    return false;
                }
            }
            else {
                System.out.println("El archivo no es existente.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("ERRROR: " + e.getMessage());
            return false;
        }
    }

    public boolean Cambiar(String archivo){
        //creamos un objeto de ArchivoTexto
        ArchivoTexto objAT = new ArchivoTexto(archivo);
        objAT.AbrirModoEscritura();
        return true;
    }

    public boolean Mover(String archivo){
        File file = new File(archivo);
        try{
            String ubiNew = null;
            File ubiNewArc = new File(ubiNew);
            if(file.exists()) {
                if (file.renameTo(ubiNewArc)) {
                    System.out.println("El archivo se ha movido exitosamente");
                    return true;
                } else {
                    System.out.println("No se puede mover el archivo.");
                    return false;
                }
            }
                else{
                    System.out.println("El archivo no es existente.");
                    return false;
                }
            }catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
}