package gestor.interfaz;

import gestor.empresarial.datos.DatosPersonales;
import gestor.empresarial.empleados.Empleados;
import gestor.errores.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Menu2 extends JFrame{
    private JPanel panel1;
    private JPanel panelM2;
    private JTextField txtIdDP;
    private JTextField txtNombre;
    private JTextField txtWats;
    private JTextField txtCorreo;
    private JButton btnAgregar;
    private JButton btnCerrar;
    private JTable tabM2;

    DefaultTableModel dtm=new DefaultTableModel();
    private Empleados emple;
    private GestionErrores gestionErrores;

    public Menu2(){
        emple=emple.getInstancia();
        gestionErrores=new GestionErrores();

        ajustesVentana();

        initComponents();
        funcionesBotones();
    }

    public void ajustesVentana(){
        setTitle("EMT-SYSTEM Menu2"); //Estabalecemos el titulo de la ventana
        this.setSize(300, 300); //Establecemos el tamaño de la ventana
        //this.setResizable(false);
        this.setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana en el centro
        this.getContentPane().add(panel1);
        this.setVisible(true); //Volvemos nuestra ventana visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Indicamos que termine la ejecucion del programa al cerrar la ventana

    }

    private void initComponents(){
        String ids[]={"ID","Nombre","WhatsApp","Correo"};
        dtm.setColumnIdentifiers(ids);
        tabM2.getTableHeader().setResizingAllowed(false);
        tabM2.getTableHeader().setReorderingAllowed(false);
        tabM2.setModel(dtm);
        if(emple.datosPerVacios()==false){
            actualizarTablaDesdeDatosPersonales();//si los datos no estan vacios, muestra datos
        }
    }
    private void obtenerYGuardarDatosPersonales(){
        //Obtenemos los datos de los txt
        String nombre=txtNombre.getText();
        String wats=txtWats.getText();
        String correo=txtCorreo.getText();

        //guarda datos en DatosPesonales
        DatosPersonales objDP=new DatosPersonales(nombre,wats,correo);

        //giardamos objDP en Emple
        emple.addDatosPersonales(objDP);
        emple.imprimirDatos();
    }

    private void actualizarTablaDesdeDatosPersonales(){
        //clear table
        //*****************************
        dtm.setRowCount(0);

        //add table
        for(int i=0;i<50;i++){
            DatosPersonales objDP=emple.getInfoPersonal(i);
            if(objDP !=null){
                int id=emple.getId(i);
                String nombre=objDP.getNombre();
                String whatsapp=objDP.getWhatsapp();
                String correo=objDP.getCorreo();
                dtm.addRow(new Object[]{id,nombre,whatsapp,correo});
            }
        }
    }


















}
