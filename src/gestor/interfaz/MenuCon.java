package gestor.interfaz;
//importamos paquetes para que funcione el codigo
import gestor.empresarial.contrato.*;
import gestor.empresarial.datos.*;
import gestor.empresarial.empleados.*;
import gestor.errores.*;

//librerias a utilizar de JAVA
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCon extends JFrame{
    private JPanel panel1;
    private JTextField txtIdEmple;
    private JTextField txtNumContrato;
    private JTextField txtHorario;
    private JTextField txtAnio;
    private JButton btnAgregar;
    private JTable lista;
    private JButton btnCerrar;
    private JComboBox comBoxCargo;
    private JTable tbCon;

    DefaultTableModel dtm=new DefaultTableModel();//se crea la tabla
    private Empleados emple;
    private int start=-1;

    public MenuCon(){
        emple=emple.getInstancia();
        ventana();//se ajusta la ventana

        //se utiliza la clase enum cargos, sale como lista de seleccion
        comBoxCargo.setModel(new DefaultComboBoxModel<>(Cargos.values()));


        startComp();
        funcBotones();

    }
    private void ventana(){
        setTitle("EMT-SYSTEM <<CONTRATO>>"); //Estabalecemos el titulo de la ventana
        this.setSize(800, 900); //Establecemos el tamaño de la ventana
        this.setResizable(false);
        this.setLocationRelativeTo(null); //Establecemos la posicion inicial de la ventana en el centro
        this.getContentPane().add(panel1);
        this.setVisible(true); //Volvemos nuestra ventana visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Indicamos que termine la ejecucion del programa al cerrar la ventana

    }

    private void startComp(){
        String encabezados[]={"ID empleado","Nombre","No.Contrato","Año","Cargo"};
        dtm.setColumnIdentifiers(encabezados);
        lista.getTableHeader().setResizingAllowed(false);
        lista.getTableHeader().setReorderingAllowed(false);
        lista.setModel(dtm);
        if(emple.datosContratoVacios()==false){
            actTC();
        }
    }

    private void obtYguarC(){
        int noContrato = Integer.parseInt(txtNumContrato.getText());
        int anio=Integer.parseInt(txtAnio.getText());
        //String horario=txtHorario.getText();
        Cargos tipoCargo=(Cargos) comBoxCargo.getSelectedItem();

        Contrato obj=new Contrato(noContrato,anio,tipoCargo);//se gardan datos en el contrato

        //guarda el objeto en empleados
        emple.addContrato(start,obj);
        emple.imprimirDatos();
    }

    private void actTC(){
        //se limpia la tabla
        dtm.setRowCount(0);

        //se agregan datos a la tabla:
        for(int i=0;i<50;i++){
            Contrato obj=emple.getInfoContrato(i);
            DatosPersonales objDP=emple.getInfoPersonal(i);
            if(obj !=null){
                int id=emple.getId(i);
                String nombre=objDP.getNombre();
                int noContrato=obj.getNoContrato();
                int anio=obj.getAnnio();
                String horario=obj.getHorario();
                Cargos cargo=obj.getTipoCargo();
                dtm.addRow(new Object[]{id,nombre,noContrato,anio,cargo});

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
                    start=emple.findEmpleado(idBuscando);

                    //verifica si se encontro el ID
                    if(start != -1){
                        DatosPersonales datosPersonales=emple.getInfoPersonal(start);
                        DatosEmpresariales datosEmpresariales=emple.getInfoEmpresarial(start);

                        //onteniendo la info relacionada al ID
                        String nombre=datosPersonales.getNombre();
                        String adscripcion=datosEmpresariales.getAdscripcion();
                        String puesto=datosEmpresariales.getPuesto();

                    }else{
                        //sms de error
                        JOptionPane.showMessageDialog(MenuCon.this, "ID NO ENCONTRADO", "Error",JOptionPane.ERROR_MESSAGE);

                    }
                }
                else{
                    JOptionPane.showMessageDialog(MenuCon.this,"ID VACIO","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //agregamos a la lista
        lista.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){//no habra selección multiple
                    int selectedRow=lista.getSelectedRow();
                    if(selectedRow !=-1){
                        //obtenemos datos de la fila seleccionada
                        Object noContrato=lista.getValueAt(selectedRow,2);
                        Object anio=lista.getValueAt(selectedRow,3);
                        //Object horario=lista.getValueAt(selectedRow,4);
                        Object tipoCargo=lista.getValueAt(selectedRow,5);

                        //regresa datos en los cuadros de escritura
                        txtNumContrato.setText(noContrato.toString());
                        txtAnio.setText(anio.toString());
                        //txtHorario.setText(horario.toString());
                        comBoxCargo.setSelectedItem(tipoCargo);
                    }
                }
            }
        });


        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(start != -1){
                    String noContrato=txtNumContrato.getText();
                    String anio=txtAnio.getText();
                    //String horario=txtHorario.getText();
                    Cargos tipoCargo =(Cargos) comBoxCargo.getSelectedItem();

                    //ve que hayan 0 campos vacios
                    if(noContrato.isEmpty() || anio.isEmpty() || tipoCargo==null){
                        //sms error diciendo q campo esta vacio
                        String sms="COMPLETE TODOS LOS CAMPOS \n";

                        JOptionPane.showMessageDialog(null,sms,"CAMPOS VACÍOS",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        //agregamos a las filas
                        obtYguarC();
                        actTC();

                        //clear txt after add
                        txtNumContrato.setText("");
                        txtAnio.setText("");
                        //txtHorario.setText("");
                        comBoxCargo.setSelectedItem(null);

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
                Menu1 objm=new Menu1();
                dispose();
            }
        });






















    }

}

