package gestor.interfaz;

//importamos librerías a utilizar
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestor.empresarial.empleados.Empleados;//importamos paquetes

public class Menu1 extends JFrame {
    //Declaración de atributos
    private JButton btnDatosPer;
    private JButton btnContrato;
    private JButton btnCerrar;
    private JButton btnDatosEmpr;
    private JPanel panelM1;
    private JPanel panelDefault;

    Empleados emple;

    public Menu1(){//constructor
        emple = emple.getInstancia();//se pide el método que eta en Empleados "get.Instamcia"
        setTitle("Menu EMT-System"); //Establecemos el titulo de la ventana
        this.setSize(800,400); //Establecemos el tamaño de la ventana
        this.setResizable(false);
        this.setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana en el centro
        this.getContentPane().add(panelDefault);
        this.setVisible(true); //Volvemos nuestra ventana visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Indicamos que termine la ejecucion del programa al cerrar la ventana
        startBtn();
        funcBtn();
    }


    public void startBtn(){//habilitamos botones
        if(emple.datosPerVacios() == true){
            btnDatosEmpr.setEnabled(false);
            btnContrato.setEnabled(false);
        } else if(emple.datosEmpVacios()){
            btnContrato.setEnabled(false);
        }
    }

    //losbotones que estan, les damos funcionalidad
    public void funcBtn() { //Método donde hacemos funcionar a los botones
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loguin objlog = new Loguin();
                dispose();
            }
        });
        btnDatosPer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDP objm2 = new MenuDP();
                dispose();
            }
        });

        btnDatosEmpr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDE objm3 = new MenuDE();
                dispose();
            }
        });

        btnContrato.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MenuCon objcon=new MenuCon();
                dispose();
            }
        });
    }
}
