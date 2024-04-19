package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaComprar extends JFrame{
    private JPanel jpPrinci;
    private JButton jbAceptar;
    private JButton jbSalir;
    private JTextField tfCod;
    private JTextField tfDni;
    private JRadioButton rbComprar;
    private JRadioButton rbAlquilar;

    public VentanaComprar(){
        super("Ventana Comprar");
        setContentPane(jpPrinci);
        setSize(800, 500);
        setLocationRelativeTo(null);
    }

    public JButton getJbAceptar() {
        return jbAceptar;
    }

    public void setJbAceptar(JButton jbAceptar) {
        this.jbAceptar = jbAceptar;
    }

    public JButton getJbSalir() {
        return jbSalir;
    }

    public void setJbSalir(JButton jbSalir) {
        this.jbSalir = jbSalir;
    }

    public JTextField getTfCod() {
        return tfCod;
    }

    public void setTfCod(JTextField tfCod) {
        this.tfCod = tfCod;
    }

    public JTextField getTfDni() {
        return tfDni;
    }

    public void setTfDni(JTextField tfDni) {
        this.tfDni = tfDni;
    }

    public JRadioButton getRbComprar() {
        return rbComprar;
    }

    public void setRbComprar(JRadioButton rbComprar) {
        this.rbComprar = rbComprar;
    }

    public JRadioButton getRbAlquilar() {
        return rbAlquilar;
    }

    public void setRbAlquilar(JRadioButton rbAlquilar) {
        this.rbAlquilar = rbAlquilar;
    }

    public void addJbAceptar(ActionListener al)
    {
        jbAceptar.addActionListener(al);
    }
    public void addJbSalir(ActionListener al)
    {
        jbSalir.addActionListener(al);
    }

    public void Limpiar()
    {
        getTfCod().setText("");
        getTfDni().setText("");
    }

    public void MostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
