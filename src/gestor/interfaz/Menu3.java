package gestor.interfaz;

import gestor.errores.GestionErrores;

import javax.swing.*;


public class Menu3 {
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

    private Empleados emple;
    private int indice=-1;
    private GestionErrores gestionErrores;

    public Menu3(){
        emple=emple.getInstancia();
        gestionErrores=new GestionErrores();

        ajustesVentana();
        initComponents();
        funcionesBotones();
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
        dtm.
        tablaM3
    }
}
