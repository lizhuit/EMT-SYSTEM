package gestor.interfaz;

import gestor.errores.GestionErrores;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loguin extends JFrame {

    private JPanel Contenedor;
    private JTextField txtUsuario;
    private JButton btnCerrar;
    private JButton btnIngresar;
    private JPasswordField txtPassContra;
    private GestionErrores gestionErrores;


    //public void getContenedor(){}

    public Loguin() {
        /*btnAbrir.addActionListener(this);//la supervisa la ventana principla
        btnGuardar.addActionListener(this);//this=login(clase)
        btnCancelar.addActionListener(this);
        btnReservar.addActionListener(this);*/

        gestionErrores = new GestionErrores();
        setTitle("EMT-SYSTEM"); //Estabalecemos el titulo de la ventana
        this.setSize(300, 300); //Establecemos el tamaño de la ventana
        //this.setResizable(false);
        this.setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana en el centro
        this.getContentPane().add(Contenedor);
        this.setVisible(true); //Volvemos nuestra ventana visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Indicamos que termine la ejecucion del programa al cerrar la ventana

        btnCerrar.addActionListener(e -> System.exit(0));

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String password = txtPassContra.getText();
                if (!usuario.isEmpty() && !txtPassContra.isEmpty()) {
                    if (usuario.equals("cisco") && password.equals("cisco123")) {
                        Menu1 obj = new Menu1();
                        dispose();
                    } else {
                        String mensaje = gestionErrores.getDescripcionTecnica(2);
                        JOptionPane.showMessageDialog(null, mensaje, "DATOS INCORRECTOS", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    String mensaje = gestionErrores.getDescripcionTecnica(3);
                    JOptionPane.showMessageDialog(null, mensaje, "FALTAN DATOS POR LLENAR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
