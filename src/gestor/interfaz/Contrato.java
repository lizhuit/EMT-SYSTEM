package gestor.interfaz;
//importamos paquetes para que funcione el codigo
import gestor.empresarial.contrato.*;
import gestor.empresarial.datos.DatosEmpresariales;
import gestor.empresarial.datos.DatosPersonales;
import gestor.empresarial.empleados.Empleados;

//librerias a utilizar de JAVA
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contrato extends JFrame{
    private JPanel panel1;
    private JTextField txtIdEmple;
    private JTextField txtNumContrato;
    private JTextField txtHorario;
    private JTextField txtAnio;
    private JButton btnAgregar;
    private JTable lista;
    private JButton btnCerrar;
    private JComboBox comBoxCargo;
    private JLabel labId;
    private JLabel labName;
    private JLabel labAdscripcion;
    private JLabel labPuesto;
    private JTable tbCon;

    DefaultTableModel dtm=new DefaultTableModel();//se crea la tabla
    private Empleados emple;
    private int indice=-1;

    public Contrato(){
        emple=emple.getInstancia();
        ventana();//se ajusta la ventana

        //se utiliza la clase enum cargos, sale como lista de seleccion
        comBoxCargo.setModel(new DefaultComboBoxModel<>(Cargos.values()));


        startComp();
        funcBotones();

    }
    private void ventana(){
        setTitle("EMT-SYSTEM"); //Estabalecemos el titulo de la ventana
        this.setSize(300, 300); //Establecemos el tamaño de la ventana
        this.setResizable(false);
        this.setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana en el centro
        this.getContentPane().add(panel1);
        this.setVisible(true); //Volvemos nuestra ventana visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Indicamos que termine la ejecucion del programa al cerrar la ventana

    }

    private void startComp(){
        String encabezados[]={"ID empleado","Nombre Completo","No.Contrato","Fecha","Cargo"};
        dtm.setColumnIdentifiers(encabezados);
        tbCon.getTableHeader().setResizingAllowed(false);
        tbCon.getTableHeader().setReorderingAllowed(false);
        tbCon.setModel(dtm);
        if(emple.datosContratoVacios()==false){
            actualizarTablaDesdeContrato();
        }
    }

    private void obtenerYGuardarContrato(){
        int noContrato = Integer.parseInt(txtNumContrato.getText());
        int anio=Integer.parseInt(txtAnio.getText());
        String horario=txtHorario.getText();
        Cargos tipoCargo=(Cargos) comBoxCargo.getSelectedItem();

        Contrato obj=new Contrato(noContrato,anio,horario,tipoCargo);//se gardan datos en el contrato

        //guarda el objeto en empleados
        emple.addContrato(indice,obj);
        emple.imprimirDatos();
    }

    private void actualizarTablaDesdeContrato(){
        //se limpia la tabla
        //dtm.setRowCount(0);*****************************************

        //se agregan datos a la tabla:
        for(int i=0;i<50;i++){
            Contrato obj=emple.getInfoContrato(i);
            DatosPersonales objDP=emple.getInfoPersonal(i);
            if(obj !=null){
                int id=emple.getID(i);
                String nombre=objDP.getNombre();
                int noContrato=obj.getNoContrato();
                int anio=obj.getAnio();
                String horario=obj.getHorario();
                Cargos cargo=obj.getTipoCargo();
                dtm.addRow(new Object[]{id,nombre,noContrato,anio,horario,cargo});

            }
        }
    }

    public void funcBotones(){
        txtIdEmple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda=txtIdEmple.getText();
                if(textoBusqueda != null){
                    //busca el id de la lista de empleados
                    int idBuscando=Integer.parseInt(textoBusqueda);//se va a int
                    indice=emple.findEmpleado(idBuscando);

                    //verifica si se encontro el ID
                    if(indice != -1){
                        DatosPersonales datosPersonales=emple.getInfoPersonal(indice);
                        DatosEmpresariales datosEmpresariales=emple.getInfoEmpresarial(indice);

                        //onteniendo la info relacionada al ID
                        String nombre=datosPersonales.getNombre();
                        String adscripcion=datosEmpresariales.getAdscripcion();
                        String puesto=datosEmpresariales.getPuesto();

                        //muestra en la interfaz
                        labId.setText("ID:" +idBuscando);
                        labName.setText("Nombre:"+nombre);
                        labAdscripcion.setText("Adscripción"+adscripcion);
                        labPuesto.setText("Puesto"+puesto);
                        txtIdEmple.setText("");
                    }else{
                        //sms de error
                        JOptionPane.showMessageDialog(Contrato.this, "ID NO ENCONTRADO", "Error",JOptionPane.ERROR_MESSAGE);

                    }
                }
                else{
                    JOptionPane.showMessageDialog(Contrato.this,"ID VACIO","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //agregamos a la lista
        tbCon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){//no habra selección multiple
                    int selectedRow=tbCon.getSelectedRow();
                    if(selectedRow !=-1){
                        //obtenemos datos de la fila seleccionada
                        Object noContrato=tbCon.getValueAt(selectedRow,2);
                        Object anio=tbCon.getValueAt(selectedRow,3);
                        Object horario=tbCon.getValueAt(selectedRow,4);
                        Object tipoCargo=tbCon.getValueAt(selectedRow,5);

                        //regresa datos en los cuadros de escritura
                        txtNumContrato.setText(noContrato.toString());
                        txtAnio.setText(anio.toString());
                        txtHorario.setText(horario.toString());
                        comBoxCargo.setSelectedItem(tipoCargo);
                    }
                }
            }
        });


        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(indice != -1){
                    String noContrato=txtNumContrato.getText();
                    String anio=txtAnio.getText();
                    String horario=txtHorario.getText();
                    Cargos tipoCargo =(Cargos) comBoxCargo.getSelectedItem();
                    //ve que hayan 0 campos vacios
                    if(noContrato.isEmpty() || anio.isEmpty() || horario.isEmpty() || tipoCargo==null){
                        //sms error diciendo q campo esta vacio
                        String mensaje="COMPLETE TODOS LOS CAMPOS \n";
                        if(noContrato.isEmpty()){
                            mensaje = mensaje + "Némero de Contrato \n";
                        }
                        if(anio.isEmpty()){
                            mensaje = mensaje + "Año \n";
                        }
                        if(tipoCargo==null){
                            mensaje = mensaje + "Tipo de Cargo \n";
                        }
                        JOptionPane.showMessageDialog(null,mensaje,"CAMPOS VACÍOS",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //agregamos a las filas
                        obtenerYGuardarContrato();
                        actualizarTablaDesdeContrato();

                        //clear txt after add
                        txtNumContrato.setText("");
                        txtAnio.setText("");
                        txtHorario.setText("");
                        comBoxCargo.setSelectedItem(null);
                        labId.setText("");
                        labName.setText("");
                        labAdscripcion.setText("");
                        labPuesto.setText("");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"SELECCIONA UN EMPLEADO","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu1 onjm=new Menu1();
                dispose();
            }
        });




















    }

}

