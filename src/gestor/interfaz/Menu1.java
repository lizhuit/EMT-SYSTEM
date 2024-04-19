package gestor.interfaz;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestor.interfaz.*;
import gestor.empresarial.datos.*;
import gestor.empresarial.contrato.*;
import gestor.empresarial.empleados.Empleados;

public class Menu1 extends JFrame {
    private JButton btnDatosPer;
    private JButton btnContrato;
    private JButton btnCerrar;
    private JButton btnDatosEmpr;
    private JPanel panelM1;
    private JPanel panelDefault;

    Empleados emple;

    public Menu1(){
        emple = emple.getInstancia();
        setTitle("Menu EMT-System"); //Establecemos el titulo de la ventana
        this.setSize(800,400); //Establecemos el tamaño de la ventana
        this.setResizable(false);
        this.setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana en el centro
        this.getContentPane().add(panelDefault);
        this.setVisible(true); //Volvemos nuestra ventana visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Indicamos que termine la ejecucion del programa al cerrar la ventana
        habilitarBtn();
        funcBtn();
    }

    public void habilitarBtn(){
        if(emple.datosPerVacios() == true){
            btnDatosEmpr.setEnabled(false);
            btnContrato.setEnabled(false);
        } else if(emple.datosEmpVacios()){
            btnContrato.setEnabled(false);
        }
    }

    public void funcBtn() {
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
                Menu2 objm2 = new Menu2();
                dispose();
            }
        });

        btnDatosEmpr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu3 objm3 = new Menu3();
                dispose();
            }
        });

        btnContrato.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Contrato1 objcon=new Contrato1();
                dispose();
            }
        });
    }
}
