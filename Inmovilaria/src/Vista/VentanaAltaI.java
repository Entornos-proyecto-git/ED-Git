package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaAltaI extends JFrame{
    private JPanel jpPrinci;
    private JButton jbAceptar;
    private JButton jbSalir;
    private JRadioButton rbVivienda;
    private JTextField tfCodigo;
    private JTextField tfDni;
    private JTextField tfLocalidad;
    private JTextField tfCalle;
    private JTextField tfHabitacion;
    private JRadioButton rbOficina;
    private JRadioButton rbComercio;

    public VentanaAltaI(){
        super("Ventana Alta Inmueble");
        setSize(600, 600);
        setContentPane(jpPrinci);
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

    public JRadioButton getRbVivienda() {
        return rbVivienda;
    }

    public void setRbVivienda(JRadioButton rbVivienda) {
        this.rbVivienda = rbVivienda;
    }

    public JTextField getTfCodigo() {
        return tfCodigo;
    }

    public void setTfCodigo(JTextField tfCodigo) {
        this.tfCodigo = tfCodigo;
    }

    public JTextField getTfDni() {
        return tfDni;
    }

    public void setTfDni(JTextField tfDni) {
        this.tfDni = tfDni;
    }

    public JTextField getTfLocalidad() {
        return tfLocalidad;
    }

    public void setTfLocalidad(JTextField tfLocalidad) {
        this.tfLocalidad = tfLocalidad;
    }

    public JTextField getTfCalle() {
        return tfCalle;
    }

    public void setTfCalle(JTextField tfCalle) {
        this.tfCalle = tfCalle;
    }

    public JTextField getTfHabitacion() {
        return tfHabitacion;
    }

    public void setTfHabitacion(JTextField tfHabitacion) {
        this.tfHabitacion = tfHabitacion;
    }

    public JRadioButton getRbOficina() {
        return rbOficina;
    }

    public void setRbOficina(JRadioButton rbOficina) {
        this.rbOficina = rbOficina;
    }

    public JRadioButton getRbComercio() {
        return rbComercio;
    }

    public void setRbComercio(JRadioButton rbComercio) {
        this.rbComercio = rbComercio;
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
}
