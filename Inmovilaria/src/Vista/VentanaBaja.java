package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaBaja extends JFrame{
    private JPanel jpPrinci;
    private JButton jbBorrar;
    private JButton jbSalir;
    private JTextField tf;
    private JLabel l;

    public VentanaBaja(){
        super("Ventana Baja");
        setContentPane(jpPrinci);
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public JButton getJbBorrar() {
        return jbBorrar;
    }

    public void setJbBorrar(JButton jbBorrar) {
        this.jbBorrar = jbBorrar;
    }

    public JButton getJbSalir() {
        return jbSalir;
    }

    public void setJbSalir(JButton jbSalir) {
        this.jbSalir = jbSalir;
    }

    public JTextField getTf() {
        return tf;
    }

    public void setTf(JTextField tf) {
        this.tf = tf;
    }

    public JLabel getL() {
        return l;
    }

    public void setL(JLabel l) {
        this.l = l;
    }
    public void addJbBorrar(ActionListener al)
    {
        jbBorrar.addActionListener(al);
    }
    public void addJbSalir(ActionListener al)
    {
        jbSalir.addActionListener(al);
    }

    public void MostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
