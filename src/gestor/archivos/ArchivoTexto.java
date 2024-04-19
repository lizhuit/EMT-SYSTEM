package gestor.archivos;

import java.io.*;

public final class ArchivoTexto extends ControlArchivos implements iFileText{//el nombre de la implementacion debe ser igual al constructor
    //se declaran atributos:
    //abre el archivo
    private File file;//no es un atributo ordinario, es uno compuesto
    private FileReader fr;//lo abre y lo deja listo para lectura.
    /*Lo q contiene este, lo entrega al buffered*/

    private BufferedReader br;/*buffered, es un pedazo de memoria, y
     si necesita más pide más al procesador y va tomando de apocos.
     es practicamente un arreglo y puede cargar grandes masas de información*/

    private FileWriter fw;//prepara el archivo para escritura
    private BufferedWriter bw;/*comunicacion, de todoo lo qu esta en el reader, lo entrega/guarda al archivo*/
    private boolean archivoExistente;
    private boolean modoLectura;
    private boolean modoEscritura;


    public ArchivoTexto(String arc){//Constructor
        super();
        try{//Puede generar una exepicón
            file= new File(arc); //Crea un objeto "file"
            if(!file.exists())//Comprueba si un archivo especifico no existe
                file.createNewFile();//Sino existe, crea uno con ese nombre
            //Variables instanciadas
            this.archivoExistente=true;
            this.modoLectura=false;
            this.modoEscritura=false;
        }
        catch(Exception e){//Captura alguna excepción
            System.out.println("NO SE ENCUENTRA EL ARCHIVO"); //Si ocurre alguna excepción manda un mensaje
            this.archivoExistente=false;
        }
    }
    public ArchivoTexto(String b, boolean c){//constructor
    }
    public void AbrirModoLectura(){//Método AbrirModoLectura
        if(archivoExistente==true) { //Verifica que la variable es verdadera
            try {
                //con estas dos instancias el archivo esta en uso:
                fr = new FileReader(this.file.getAbsoluteFile());//objeto para leer el archivo como un secuencia de caracteres
                br = new BufferedReader(this.fr);//objeto que lee el archivo de una menera más eficiente utilizando un búfer
                this.modoLectura = true;// si el archivo se abre correctamente
                System.out.println("ARCHIVO ABIERTO EN MODO LECTURA");//indica que está en modo lectura
            } catch (Exception e) {//Captura excepciones
                System.out.println("ERROR: EL ARCHIVO NO SE PUEDE ABIRIR EN MODO LECTURA");//mensaj de error
            }
        }
    }
    public String Leer(){//Método Leer
        if(archivoExistente==true) {//Verifica que el archivo existe
            try {
                return this.br.readLine();//si no hay error retorna esto y ya no ejecuta lo que falta de la funcion
            } catch (Exception e) {

            }
        }
        return null;
    }
    public void AbrirModoEscritura(){//Método AbrirModoEscritura

        if(archivoExistente==true) {//Verifica que el archivo exista
            try {
                //con estas dos instancias el archivo esta en uso:
                fw = new FileWriter(this.file.getAbsoluteFile(),true);
                bw = new BufferedWriter(this.fw);

                modoEscritura = true;
                System.out.println("ARCHIVO ABIERTO EN MODO ESCRITURA");
            } catch (Exception e) {
                System.out.println("ERROR: EL ARCHIVO NO SE PUEDE ABIRIR EN MODO ESCRITURA");
            }
        }
    }
    public void Escribir(String texto){

        if(archivoExistente==true){//Verifica que exista
            try{
                this.bw.write(texto+"\n");//escribo en el buffered no en el archivo
            }catch(Exception e){
                System.out.println("EROOR: NO SE PUEDE ESCRIBIR INFORMACIÓN EN EL ARCHIVO");//Se imprime si existe alguna exception
            }
        }
    }
    public void Cerrar(){//Método Cerrar
        if(modoEscritura==true){//Verifica que esté en modo Escritura
            try{
                this.bw.close();//cerrar con el bufer
                this.fw.close();
            }catch(Exception e){ }
        }
        else if(modoLectura==true)
        {
            try{
                this.br.close();
                this.fr.close();
            }catch(Exception e){ }
        }
    }
}