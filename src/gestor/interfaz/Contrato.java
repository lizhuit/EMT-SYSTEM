package gestor.interfaz;
//importamos paquetes para que funcione el codigo
import gestor.empresarial.datos.DatosEmpresariales;
import gestor.empresarial.datos.DatosPersonales;
import gestor.empresarial.empleados.Empleados;

//librerias a utilizar de JAVA
import javax.swing.*;
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
    private JLabel labelPuesto;

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
        tablaC.getTableHeader().setResizingAllowed(false);
        tablaC.getTableHeader().setReorderingAllowed(false);
        tablaC.setModel(dtm);
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
                    indice=emple.findEmpleado(idBuscado);

                    //verifica si se encontro el ID
                    if(indice != -1){
                        DatosPersonales datosPersonales=emple.getInfoPersonal(indice);
                        DatosEmpresariales datosEmpresariales=emple.getInfoEmpresarial(indice);

                        //onteniendo la info relacionada al ID
                        String nombre=datosPersonales.getNombre();
                        String adscripcion=datosEmpresariales.getAdscripcion();
                        String puesto=datosEmpresariales.getPuesto();

                        //muestra en la interfaz
                        labeId.setText("ID:" +idBuscado);
                        /*// Mostrando la información en la ventana
                        labeIId.setText("ID: "+ idBuscado);
                        labelName.setText("Nombre: " + nombre);
                        labelAdscripcion.setText("Adscripcion: " + adscripcion);
                        labelPuesto.setText("Puesto: " + puesto);
                        fieldBuscador.setText("");*/

                    }















                }
            }
        });
    }

}

