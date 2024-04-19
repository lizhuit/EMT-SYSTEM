package gestor.archivos;

import java.io.File;

class ControlArchivos{//clase padre
    private String archivo;//atributo

    public ControlArchivos(){//constructor
        this.archivo = archivo; //instanciar archivo
    }
    public boolean Crear(){//Método Crear
        File file = new File(archivo); //objeto file
        try{
            if (file.exists()){// si el archivo ya exist, se imprime el mensaje
                System.out.println("El archivo ya existe.");
                return false;
            }
            else {
                if (file.createNewFile()){ //Si no existe, se inteta crear e imprime mensaje
                    System.out.println("Se ha creado el archivo exitosamente.");
                    return false;
                } else{//No se puede crear
                    System.out.println("No se puede crear el archivo.");
                    return false;
                }
            }
        } catch (Exception e){//Si hay errores, lo muestra
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
    public boolean Eliminar(){//Método Eliminar
        File file = new File(archivo); //Objeto file
        try {
            if (file.exists()){
                if (file.delete()) {//si el archivo existe lo elimina y muestra mensaje
                    System.out.println("El archivo ha sido eliminado exitosamente.");
                    return true;
                }
                else {//existe, pero no se puede eliminar
                    System.out.println("El archivo no puede ser eliminado.");
                    return false;
                }
            }
            else {//No existe el archivo
                System.out.println("El archivo no es existente.");
                return false;
            }
        } catch (Exception e) {//Si hay errores los imprime
            System.out.println("ERRROR: " + e.getMessage());
            return false;
        }
    }

    public boolean Cambiar(String archivo){//Método Cambiar
        //creamos un objeto de ArchivoTexto
        ArchivoTexto objAT = new ArchivoTexto(archivo);
        objAT.AbrirModoEscritura();
        return true;
    }

    public boolean Mover(String archivo){//Método Mover
        File file = new File(archivo);//Objeto file
        try{
            String ubiNew = null;
            File ubiNewArc = new File(ubiNew);
            if(file.exists()) {
                if (file.renameTo(ubiNewArc)) {//Si el archivo existe, lo mueve
                    System.out.println("El archivo se ha movido exitosamente");
                    return true;
                } else {//Existe, pero no se puede mover
                    System.out.println("No se puede mover el archivo.");
                    return false;
                }
            }
                else{//El archivo no existe
                    System.out.println("El archivo no es existente.");
                    return false;
                }
            }catch (Exception e){//Muestra errores
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
}