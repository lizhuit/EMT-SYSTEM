//Autor: Lizbeth Huitzil Leal
//Proyecto: Gestor Empresarial
//Fecha de inicio: 28/02/2024
//Ultima actualización: 01/02/2024

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;


class Principal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio de Sesión");//crea una ventana nueva con un título
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();//obtiene las dimensiones ancho y alto de monitor
        int x = (pantalla.width/2)-300;//calcula el centro, del largo del monitor
        int y = (pantalla.height/2)-200;//calcula el centro, del alto del monitor


        // frame.setContentPane(new Loguin().getContenedor());//agregar el panel de Loguin al Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//activan el boton
        frame.pack();//refresh
        frame.setSize(600,400);//tamaño del formulario
        frame.setLocation(x,y);//ubica la ventana en las coordenadas establecidas

        frame.setVisible(true);

        System.out.println("Prueba");
    }
}