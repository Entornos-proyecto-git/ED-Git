package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaModificar extends JFrame{
    private JPanel jpPrinci;
    private JButton jbBuscar;
    private JButton jbModificar;
    private JButton jbSalir;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JLabel l6;

    public VentanaModificar(){
        super("Ventana Modificacion");
        setContentPane(jpPrinci);
        setSize(450,450);
        setLocationRelativeTo(null);
    }

    public JButton getJbBuscar() {
        return jbBuscar;
    }

    public void setJbBuscar(JButton jbBuscar) {
        this.jbBuscar = jbBuscar;
    }

    public JButton getJbModificar() {
        return jbModificar;
    }

    public void setJbModificar(JButton jbModificar) {
        this.jbModificar = jbModificar;
    }

    public JButton getJbSalir() {
        return jbSalir;
    }

    public void setJbSalir(JButton jbSalir) {
        this.jbSalir = jbSalir;
    }

    public JTextField getTf1() {
        return tf1;
    }

    public void setTf1(JTextField tf1) {
        this.tf1 = tf1;
    }

    public JTextField getTf2() {
        return tf2;
    }

    public void setTf2(JTextField tf2) {
        this.tf2 = tf2;
    }

    public JTextField getTf3() {
        return tf3;
    }

    public void setTf3(JTextField tf3) {
        this.tf3 = tf3;
    }

    public JTextField getTf4() {
        return tf4;
    }

    public void setTf4(JTextField tf4) {
        this.tf4 = tf4;
    }

    public JTextField getTf5() {
        return tf5;
    }

    public void setTf5(JTextField tf5) {
        this.tf5 = tf5;
    }

    public JTextField getTf6() {
        return tf6;
    }

    public void setTf6(JTextField tf6) {
        this.tf6 = tf6;
    }

    public JLabel getL1() {
        return l1;
    }

    public void setL1(JLabel l1) {
        this.l1 = l1;
    }

    public JLabel getL2() {
        return l2;
    }

    public void setL2(JLabel l2) {
        this.l2 = l2;
    }

    public JLabel getL3() {
        return l3;
    }

    public void setL3(JLabel l3) {
        this.l3 = l3;
    }

    public JLabel getL4() {
        return l4;
    }

    public void setL4(JLabel l4) {
        this.l4 = l4;
    }

    public JLabel getL5() {
        return l5;
    }

    public void setL5(JLabel l5) {
        this.l5 = l5;
    }

    public JLabel getL6() {
        return l6;
    }

    public void setL6(JLabel l6) {
        this.l6 = l6;
    }

    public void addJbBuscar(ActionListener al)
    {
        jbBuscar.addActionListener(al);
    }
    public void addJbModificar(ActionListener al)
    {
        jbModificar.addActionListener(al);
    }

    public void addJbSalir(ActionListener al)
    {
        jbSalir.addActionListener(al);
    }

    public void MostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void Limpiar()
    {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
    }
}
