package gestor.interfaz;
//importamos paquetes
import gestor.empresarial.datos.*;
import gestor.empresarial.empleados.*;
import gestor.errores.GestionErrores;

//importamoslibrerias
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuDE extends JFrame{
    //atributos que tiene la ventana
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

    DefaultTableModel dtm=new DefaultTableModel();//creamos tabla

    private Empleados emple;
    private int start=-1;//lo podemos utilizar en cualquier lado
    private GestionErrores gestionErrores;

    public MenuDE(){
        emple=emple.getInstancia();
        gestionErrores=new GestionErrores();
        //funciones:
        ventana();
        initComponents();
        funcbtn();
    }

    public void ventana(){
        setTitle("EMT-SYSTEM <<Datos Empresariales>>"); //Estabalecemos el titulo de la ventana
        this.setSize(1000, 800); //Establecemos el tamaño de la ventana
        this.setResizable(false);
        this.setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana en el centro
        this.getContentPane().add(panel1);
        this.setVisible(true); //Volvemos nuestra ventana visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Indicamos que termine la ejecucion del programa al cerrar la ventana
    }
    private void initComponents(){
        String encabezados[]={"ID","Nombre","Telefono","Extension","Adscripción","Puesto"};
        dtm.setColumnIdentifiers(encabezados);
        tablaM3.getTableHeader().setResizingAllowed(false);//ventana estatica
        tablaM3.getTableHeader().setReorderingAllowed(false);
        tablaM3.setModel(dtm);
        if(emple.datosEmpVacios()==false){
            actTDE();//actualiza la tabal de DE
        }
    }

    private void obtDE(int indice){
        //tenemos los txt
        String telefono=txtTel.getText();
        String extension=txtExt.getText();
        String adscripcion=txtAds.getText();
        String puesto=txtPuesto.getText();

        //guarda en DE
        DatosEmpresariales objDE=new DatosEmpresariales(telefono,extension,adscripcion,puesto);

        //obj en Empleados
        emple.addDatosEmpresariales(indice,objDE);
        this.start=-1;
        emple.imprimirDatos();
    }

    private void actTDE(){
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
                dtm.addRow(new Object[]{id,nom,tel,ext,ads,puesto});
            }
        }
    }

    public void funcbtn(){//haceos funcionar btns
        txtId.addActionListener(new ActionListener() {
            @Override//sobreescribimosS
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda=txtId.getText();
                if(textoBusqueda != null){
                    //busca ID
                    int busquedaId=Integer.parseInt(textoBusqueda);//entero id
                    start=emple.findEmpleado(busquedaId);

                    //halló ID
                    if(start !=-1){
                        DatosPersonales datosPersonales=emple.getInfoPersonal(start);
                        //da info de ID
                        String nombre=datosPersonales.getNombre();
                        String whatsapp=datosPersonales.getWhatsapp();
                        String correo=datosPersonales.getCorreo();

                    }
                    else{
                        String sms=gestionErrores.getDescription(4);
                        JOptionPane.showMessageDialog(MenuDE.this,"NO SE ENCEUNTRA ID",sms,JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    String titulo=gestionErrores.getDescription(1);
                    JOptionPane.showMessageDialog(MenuDE.this,"VACIO",titulo,JOptionPane.ERROR_MESSAGE);
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
                        Object tel=tablaM3.getValueAt(selectedRow,2);
                        Object ext=tablaM3.getValueAt(selectedRow,3);
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
                dispose();
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(start != -1){
                    String telefono=txtTel.getText();
                    String extension=txtExt.getText();
                    String adscripcion=txtAds.getText();
                    String puesto=txtPuesto.getText();
                    //nada vacio??
                    if(telefono.isEmpty() || extension.isEmpty() || adscripcion.isEmpty() || puesto.isEmpty()){
                        //sms error
                        String sms=gestionErrores.getDescription(1);


                        JOptionPane.showMessageDialog(null,sms,"VACIO",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //agregamos a fila de tabla
                        obtDE(start);
                        actTDE();

                        //clear txt
                        txtTel.setText("");
                        txtExt.setText("");
                        txtAds.setText("");
                        txtPuesto.setText("");


                    }
                }
                else{
                    String sms=gestionErrores.getDescription(5);//manda a traer el error
                    JOptionPane.showMessageDialog(null,sms,"NO SE AGEGARON DATOS",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
