package gestor.interfaz;

import gestor.interfaz.*;
import gestor.empresarial.datos.DatosPersonales;
import gestor.empresarial.empleados.*;
import gestor.errores.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;

public class Menu2 extends JFrame {
    private JPanel panel1;
    private JPanel panelM2;
    private JTextField txtIdDP;
    private JTextField txtNombre;
    private JTextField txtWats;
    private JTextField txtCorreo;
    private JButton btnAgregar;
    private JButton btnCerrar;
    private JTable tabM2;


    DefaultTableModel dtm = new DefaultTableModel();
    private Empleados emple;
    private GestionErrores gestionErrores;

    public Menu2() {
        emple = emple.getInstancia();
        gestionErrores = new GestionErrores();

        ajustesVentana();

        initComponents();
        funcbtn();
    }

    public void ajustesVentana() {
        setTitle("EMT-SYSTEM Menu2"); //Estabalecemos el titulo de la ventana
        this.setSize(300, 300); //Establecemos el tamaño de la ventana
        //this.setResizable(false);
        this.setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana en el centro
        this.getContentPane().add(panel1);
        this.setVisible(true); //Volvemos nuestra ventana visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Indicamos que termine la ejecucion del programa al cerrar la ventana

    }

    private void initComponents() {
        String ids[] = {"ID", "Nombre", "WhatsApp", "Correo"};
        dtm.setColumnIdentifiers(ids);
        tabM2.getTableHeader().setResizingAllowed(false);
        tabM2.getTableHeader().setReorderingAllowed(false);
        tabM2.setModel(dtm);
        if (emple.datosPerVacios() == false) {
            actualizarTablaDesdeDatosPersonales();//si los datos no estan vacios, muestra datos
        }
    }

    private void obtenerYGuardarDatosPersonales() {
        //Obtenemos los datos de los txt
        String nombre = txtNombre.getText();
        String wats = txtWats.getText();
        String correo = txtCorreo.getText();

        //guarda datos en DatosPesonales
        DatosPersonales objDP = new DatosPersonales(nombre, wats, correo);

        //giardamos objDP en Emple
        emple.addDatosPersonales(objDP);
        emple.imprimirDatos();
    }

    private void actualizarTablaDesdeDatosPersonales() {
        //clear table
        //*****************************
        dtm.setRowCount(0);

        //add table
        for (int i = 0; i < 50; i++) {
            DatosPersonales objDP = emple.getInfoPersonal(i);
            if (objDP != null) {
                int id = emple.getId(i);
                String nombre = objDP.getNombre();
                String whatsapp = objDP.getWhatsapp();
                String correo = objDP.getCorreo();
                dtm.addRow(new Object[]{id, nombre, whatsapp, correo});
            }
        }
    }

    public boolean verificarCampos() {
        boolean camposCorectos = true;
        String titulo;
        if (txtIdDP.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                txtWats.getText().isEmpty() || txtCorreo.getText().isEmpty()) {

            //mustra sms de errror
            titulo = gestionErrores.getDescription(1);
            String sms = "COMPLETE TODOS LOS CAMPOS:";
            if (txtIdDP.getText().isEmpty()) {
                sms = sms + "ID\n";
            }
            if (txtNombre.getText().isEmpty()) {
                sms = sms + "Nombre\n";
            }
            if (txtWats.getText().isEmpty()) {
                sms = sms + "WhatsApp\n";
            }
            if (txtCorreo.getText().isEmpty()) {
                sms = sms + "Correo\n";
            }
            JOptionPane.showMessageDialog(null, sms, titulo, JOptionPane.ERROR_MESSAGE);
            camposCorectos = false;
        } else {
            boolean hayDuplicados = emple.buscarDuplicadosP(Integer.parseInt(txtIdDP.getText()), txtNombre.getText(), txtWats.getText(), txtCorreo.getText());
            if (hayDuplicados) {
                titulo = gestionErrores.getDescription(6);
                JOptionPane.showMessageDialog(null, "No se pueden duplicar Empleados", titulo, JOptionPane.ERROR_MESSAGE);
                camposCorectos = false;
            }
        }
        return camposCorectos;
    }

    public void funcbtn() {
        tabM2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {//no hay events de varia seleccion
                    int selectRow = tabM2.getSelectedRow();
                    if (selectRow != -1) { //si se selecciono fila
                        //date of fila select
                        Object id = tabM2.getValueAt(selectRow, 0);
                        Object nombre = tabM2.getValueAt(selectRow, 1);
                        Object wtapp = tabM2.getValueAt(selectRow, 2);
                        Object correo = tabM2.getValueAt(selectRow, 3);

                        //muestra datos de txt
                        txtIdDP.setText(id.toString());
                        txtNombre.setText(nombre.toString());
                        txtWats.setText(wtapp.toString());
                        txtCorreo.setText(correo.toString());
                    }
                }
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu1 obj = new Menu1();
                dispose();
            }
        });


        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtIdDP.getText();
                String nom = txtNombre.getText();
                String wats = txtWats.getText();
                String correo = txtCorreo.getText();
                boolean camposCorrect = verificarCampos();//ningun campo vacio/repetido
                if (camposCorrect == true) {
                    //true y agrega
                    obtenerYGuardarDatosPersonales();
                    actualizarTablaDesdeDatosPersonales();
                    //clear y add
                    txtIdDP.setText("");
                    txtNombre.setText("");
                    txtWats.setText("");
                    txtCorreo.setText("");
                }
            }
        });
    }
}
















