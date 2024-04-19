package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaAltaU extends JFrame{
    private JPanel jpPrinci;
    private JButton jbAceptar;
    private JButton jbSalir;
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellido;

    public VentanaAltaU(){
        super("Ventana alta usuario");
        setContentPane(jpPrinci);
        setSize(500, 500);
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

    public JTextField getTfDni() {
        return tfDni;
    }

    public void setTfDni(JTextField tfDni) {
        this.tfDni = tfDni;
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public void setTfNombre(JTextField tfNombre) {
        this.tfNombre = tfNombre;
    }

    public JTextField getTfApellido() {
        return tfApellido;
    }

    public void setTfApellido(JTextField tfApellido) {
        this.tfApellido = tfApellido;
    }

    public void addJbAceptar(ActionListener al)
    {
        jbAceptar.addActionListener(al);
    }

    public void addJbSalir(ActionListener al)
    {
        jbSalir.addActionListener(al);
    }

    public void MostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void limpiar()
    {
        tfDni.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
    }
}
