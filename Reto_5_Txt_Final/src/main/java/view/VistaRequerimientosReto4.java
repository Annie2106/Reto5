package view;

import controller.ControladorRequerimientosReto4;

import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;
import useful.Useful;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VistaRequerimientosReto4 extends JFrame{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public VistaRequerimientosReto4(){
        setTitle("Query Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 800,650);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setLocationRelativeTo(null);
		//setLayout(new BorderLayout());
        setContentPane(contentPane);
        contentPane.setLayout(null);

        setIconImage(Useful.getImage("queryWindow.png"));

        JLabel lbltitulo = new JLabel("Reto 5, Viviana Catelblanco");
        lbltitulo.setBounds(28, 6, 500, 16);
        contentPane.add(lbltitulo);

        // Dimensiona el contenido dentro de la ventana
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 737, 455);
        contentPane.add(scrollPane);

        // Proporciona una vista desplazable de un componente en una ventana grafica
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsuta1 = new JButton("Requerimiento 1");
        btnConsuta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsuta1.setBounds(20, 537, 133, 29);
        contentPane.add(btnConsuta1);

        JButton btnConsuta2 = new JButton("Requerimiento 2");
        btnConsuta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsuta2.setBounds(157, 537, 133, 29);
        contentPane.add(btnConsuta2);

        JButton btnConsuta3 = new JButton("Requerimiento 3");
        btnConsuta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsuta3.setBounds(294, 537, 133, 29);
        contentPane.add(btnConsuta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648, 537, 117, 29);
        contentPane.add(btnLimpiar);

    }

    public void requerimiento1(){
        try{
            ArrayList<Requerimiento_1Vo> resultado_requerimiento1 = controlador.consultarRequerimiento1();
            String salida = "*** Requerimiento 1 *** \n\nCiudad Residencia\t\tPromedio\n\n";
            for (Requerimiento_1Vo requerimiento_1Vo : resultado_requerimiento1){
                salida += requerimiento_1Vo.getCiudadResidencia();
                salida += "\t\t\t";
                salida += Math.round(requerimiento_1Vo.getPromedio());
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento2(){
        try{
            ArrayList<Requerimiento_2Vo> resultado_requerimiento2 = controlador.consultarRequerimiento2();  
            String salida = "*** Requerimiento 2 *** \n\nID_Proyecto\tProveedor\n\n";
            for (Requerimiento_2Vo requerimiento_2Vo : resultado_requerimiento2){
                salida += requerimiento_2Vo.getIdProyecto();
                salida += "\t";
                salida += requerimiento_2Vo.getProveedor();
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento3(){
        try{
            ArrayList<Requerimiento_3Vo> resultado_requerimiento3 = controlador.consultarRequerimiento3();
            String salida = "*** Requerimiento 3 *** \n\nID_Proyecto\tMaterial\n\n";
            for (Requerimiento_3Vo requerimiento_3Vo : resultado_requerimiento3){
                salida += requerimiento_3Vo.getIdProyecto();
                salida += "\t \t";
                salida += requerimiento_3Vo.getNombreMaterial();
                salida += "\n";
            } 
            textArea.setText(salida);   
        
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
}
