package gestor.archivos;

import java.io.*;

public class ArchivoTexto extends ControlArchivos implements iFileText{//el nombre de la implementacion debe ser igual al constructor
    //se declaran atributos:
    //abre el archivo
    private File file;//no es un atributo ordinario, es uno compuesto
    private FileReader fr;//lo abre y lo deja listo para lectura.
    /*Lo q contiene este, lo entrega al buffered*/

    private BufferedReader br;/*buffered, es un pedazo de memoria, y
     si necesita más pide más al procesador y va toamndo de apocos.
     es practicamente un arreglo y puede cargar grandes masas de info*/

    private FileWriter fw;//prepara el archivo para escritura
    private BufferedWriter bw;/*comunicacion, de todoo lo qu eesta en el reader, lo entrega/guarda al archivo*/
    private boolean archivoExistente;
    private boolean modoLectura;
    private boolean modoEscritura;


    public ArchivoTexto(String arc){
        super();//constructor
        try{
            file= new File(arc);
            if(!file.exists())
                file.createNewFile();

            this.archivoExistente=true;
            this.modoLectura=false;
            this.modoEscritura=false;
        }
        catch(Exception e){
            System.out.println("Error al intentar buscar el archivo");
            this.archivoExistente=false;
        }
    }
    public ArchivoTexto(String b, boolean c){//constructor
    }
    public void AbrirModoLectura(){
        if(archivoExistente==true) {
            try {
                //con estas dos instancias el archivo esta en uso:
                fr = new FileReader(this.file.getAbsoluteFile());
                br = new BufferedReader(this.fr);

                this.modoLectura = true;
                System.out.println("ARCHIVO ABIERTO EN MODO LECTURA");
            } catch (Exception e) {
                System.out.println("ERROR: EL ARCHIVO NO SE PUEDE ABIRIR EN MODO LECTURA");
            }
        }
    }
    public String Leer(){
        if(archivoExistente==true) {
            try {
                return this.br.readLine();//si no hay error retorna esto y ya no ejecuta lo que falta de la funcion
            } catch (Exception e) {

            }
        }
        return null;
    }
    public void AbrirModoEscritura(){

        if(archivoExistente==true) {
            try {
                //con estas dos instancias el archivo esta en uso:
                fw = new FileWriter(this.file.getAbsoluteFile(),true);
                bw = new BufferedWriter(this.fw);

                this.modoEscritura = true;
                System.out.println("ARCHIVO ABIERTO EN MODO ESCRITURA");
            } catch (Exception e) {
                System.out.println("ERROR: EL ARCHIVO NO SE PUEDE ABIRIR EN MODO ESCRITURA");
            }
        }
    }
    public void Escribir(String texto){

        if(archivoExistente==true){
            try{
                this.bw.write(texto+"\n");//escribo en el buffered no en el archivo
            }catch(Exception e){
                System.out.println("EROOR: NO SE PUEDE ESCRIBIR INFORMACIÓN EN EL ARCHIVO");
            }
        }
    }
    public void Cerrar(){

        if(modoEscritura==true){
            try{
                this.bw.close();
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