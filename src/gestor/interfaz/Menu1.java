package gestor.interfaz;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu1 extends JFrame {
    private JButton btnDatosPer;
    private JButton btnContrato;
    private JButton btnCerrar;
    private JButton btnDatosEmpr;
    private JPanel panelM1;


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
