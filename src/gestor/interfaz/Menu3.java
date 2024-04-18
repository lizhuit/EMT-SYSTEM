package gestor.interfaz;
import gestor.empresarial.datos.*;
import gestor.interfaz.Menu1;
import gestor.empresarial.empleados.*;
import gestor.errores.GestionErrores;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;




public class Menu3 extends JFrame{
    private JPanel panel1;
    private JPanel PanelM3;
    private JTextField txtId;//buscador
    private JTextField txtTel;
    private JTextField txtExt;
    private JTextField txtAds;
    private JTextField txtPuesto;
    private JTable tablaM3;
    private JButton btnAgregar;
    private JButton btnCerrar;
    private JLabel idEmple;
    private JLabel nomEmple;
    private JLabel watsEmple;
    private JLabel correoEmple;

    DefaultTableModel dtm=new DefaultTableModel();//creamos tabla

    private Empleados emple;
    private int indice=-1;
    private GestionErrores gestionErrores;

    public Menu3(){
        emple=emple.getInstancia();
        gestionErrores=new GestionErrores();

        ajustesVentana();
        initComponents();
        funcbtn();
    }

    public void ajustesVentana(){
        setTitle("EMT-SYSTEM Menu3"); //Estabalecemos el titulo de la ventana
        this.setSize(300, 300); //Establecemos el tamaño de la ventana
        //this.setResizable(false);
        this.setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana en el centro
        this.getContentPane().add(panel1);
        this.setVisible(true); //Volvemos nuestra ventana visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Indicamos que termine la ejecucion del programa al cerrar la ventana
    }
    private void initComponents(){
        String encabezados[]={"ID","Nombre","Extension","Telefono","Adscripción","Puesto"};
        dtm.setColumnIdentifiers(encabezados);
        tablaM3.getTableHeader().setResizingAllowed(false);//ventana estatica
        tablaM3.getTableHeader().setReorderingAllowed(false);
        tablaM3.setModel(dtm);
        if(emple.datosEmpVacios()==false){
            actualizarTablaDesdeDatosEmpresariales();
        }
    }

    private void obtenerYGuardarDatosEmpresariales(int indice){
        //tenemos los txt
        String telefono=txtTel.getText();
        String extension=txtExt.getText();
        String adscripcion=txtAds.getText();
        String puesto=txtPuesto.getText();

        //guarda en DE
        DatosEmpresariales objDE=new DatosEmpresariales(telefono,extension,adscripcion,puesto);

        //obj en Empleados
        emple.addDatosEmpresariales(indice,objDE);
        this.indice=-1;
        emple.imprimirDatos();
    }

    private void actualizarTablaDesdeDatosEmpresariales(){
        //clear ventana
        dtm.setRowCount(0);

        //add a tabla
        for(int i=0;i<50;i++){
            DatosEmpresariales objDE =emple.getInfoEmpresarial(i);
            DatosPersonales objDP= emple.getInfoPersonal(i);
            if(objDE!= null){
                int id=emple.getId(i);
                String nom=objDP.getNombre();
                String tel=objDE.getTelefonoExterior();
                String ext=objDE.getExtension();
                String ads=objDE.getAdscripcion();
                String puesto=objDE.getPuesto();
                dtm.addRow(new Object[]{id,nom,ext,tel,ads,puesto});
            }
        }
    }

    public void funcbtn(){
        txtId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda=txtId.getText();
                if(textoBusqueda != null){
                    //busca ID
                    int busquedaId=Integer.parseInt(textoBusqueda);//entero id
                    indice=emple.findEmpleado(busquedaId);

                    //halló ID
                    if(indice !=-1){
                        DatosPersonales datosPersonales=emple.getInfoPersonal(indice);
                        //da info de ID
                        String nombre=datosPersonales.getNombre();
                        String whatsapp=datosPersonales.getWhatsapp();
                        String correo=datosPersonales.getCorreo();

                        //vemos info
                        idEmple.setText("ID" + busquedaId);
                        nomEmple.setText("Nombre" +nombre);
                        watsEmple.setText("WhatsApp" +whatsapp);
                        correoEmple.setText("Correo" + correoEmple);
                        txtId.setText("");
                    }
                    else{
                        String sms=gestionErrores.getDescription(4);
                        JOptionPane.showMessageDialog(Menu3.this,"NO SE ENCEUNTRA ID",sms,JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    String titulo=gestionErrores.getDescription(1);
                    JOptionPane.showMessageDialog(Menu3.this,"VACIO",titulo,JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tablaM3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){//no seleccionamuchos
                    int selectedRow= tablaM3.getSelectedRow();
                    if(selectedRow !=-1){//selecciona fila???
                        //tenemos datos de la fila
                        Object tel=tablaM3.getValueAt(selectedRow,3);
                        Object ext=tablaM3.getValueAt(selectedRow,2);
                        Object ads=tablaM3.getValueAt(selectedRow,4);
                        Object puesto=tablaM3.getValueAt(selectedRow,5);

                        //muestra txt
                        txtTel.setText(tel.toString());
                        txtExt.setText(ext.toString());
                        txtAds.setText(ads.toString());
                        txtPuesto.setText(puesto.toString());
                    }
                }
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu1 objM1=new Menu1();
                dispose;
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(indice != -1){
                    String telefono=txtTel.getText();
                    String extension=txtExt.getText();
                    String adscripcion=txtAds.getText();
                    String puesto=txtPuesto.getText();
                    //nada vacio??
                    if(telefono.isEmpty() || extension.isEmpty() || adscripcion.isEmpty() || puesto.isEmpty()){
                        //sms error
                        String sms=gestionErrores.getDescription(1);
                        if(telefono.isEmpty()){
                            sms=sms+"Telefono";
                        }
                        if(extension.isEmpty()){
                            sms=sms+"Extension";
                        }
                        if(adscripcion.isEmpty()){
                            sms=sms+"Adscripcion";
                        }
                        if(puesto.isEmpty()){
                            sms=sms+"Puesto";
                        }
                        JOptionPane.showMessageDialog(null,sms,"VACIO",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //agregamos a tabla
                        obtenerYGuardarDatosEmpresariales(indice);
                        actualizarTablaDesdeDatosEmpresariales();

                        //clear txt
                        txtTel.setText("");
                        txtExt.setText("");
                        txtAds.setText("");
                        txtPuesto.setText("");
                        idEmple.setText("");
                        nomEmple.setText("");
                        watsEmple.setText("");
                        correoEmple.setText("");
                    }
                }
                else{
                    String sms=gestionErrores.getDescription(5);
                    JOptionPane.showMessageDialog(null,sms,"NO SE AGEGARON DATOS",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
