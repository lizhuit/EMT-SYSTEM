package gestor.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loguin extends JFrame implements ActionListener {
    private JButton btnGuardar;
    private JButton btnReservar;
    private JButton btnCancelar;
    private JButton btnAbrir;
    private JPanel Contenedor;

    //public void getContenedor(){}

    public Loguin(){
        btnAbrir.addActionListener(this);//la supervisa la ventana principla
        btnGuardar.addActionListener(this);//this=login(clase)
        btnCancelar.addActionListener(this);
        btnReservar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {//captura todos los eventos que ocurren en el formulario
        if (e.getSource() == btnAbrir){//e.getSource() detecta el click
            JOptionPane.showMessageDialog(null,"Hola mundo");//muestra un cuadro de dílogo emergente
        }
        if (e.getSource() == btnReservar){//e.getSource() detecta el click
            System.out.println("Resrvado....");
            JOptionPane.showMessageDialog(null,"Reservado");//muestra un cuadro de dílogo emergente
        }

    }

}