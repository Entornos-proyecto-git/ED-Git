package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaConsultar extends JFrame{
    private JPanel jpPrinci;
    private JComboBox cbOpciones;
    private JButton jbSalir;
    private JTextArea taResultado;
    private JRadioButton rbLocalidad;
    private JRadioButton rbCalle;
    private JRadioButton rbHabitacion;
    private JRadioButton rbDesmarcar;
    private JRadioButton rbEstado;
    private JRadioButton rbTipo;

    public VentanaConsultar(){
        super("Ventana Busqueda");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setContentPane(jpPrinci);
    }

    public JComboBox getCbOpciones() {
        return cbOpciones;
    }

    public void setCbOpciones(JComboBox cbOpciones) {
        this.cbOpciones = cbOpciones;
    }

    public JButton getJbSalir() {
        return jbSalir;
    }

    public void setJbSalir(JButton jbSalir) {
        this.jbSalir = jbSalir;
    }

    public JTextArea getTaResultado() {
        return taResultado;
    }

    public void setTaResultado(JTextArea taResultado) {
        this.taResultado = taResultado;
    }

    public JRadioButton getRbLocalidad() {
        return rbLocalidad;
    }

    public void setRbLocalidad(JRadioButton rbLocalidad) {
        this.rbLocalidad = rbLocalidad;
    }

    public JRadioButton getRbCalle() {
        return rbCalle;
    }

    public void setRbCalle(JRadioButton rbCalle) {
        this.rbCalle = rbCalle;
    }

    public JRadioButton getRbHabitacion() {
        return rbHabitacion;
    }

    public void setRbHabitacion(JRadioButton rbHabitacion) {
        this.rbHabitacion = rbHabitacion;
    }

    public JRadioButton getRbDesmarcar() {
        return rbDesmarcar;
    }

    public void setRbDesmarcar(JRadioButton rbDesmarcar) {
        this.rbDesmarcar = rbDesmarcar;
    }

    public JRadioButton getRbEstado() {
        return rbEstado;
    }

    public void setRbEstado(JRadioButton rbEstado) {
        this.rbEstado = rbEstado;
    }

    public JRadioButton getRbTipo() {
        return rbTipo;
    }

    public void setRbTipo(JRadioButton rbTipo) {
        this.rbTipo = rbTipo;
    }

    public void addRbLocalidad(ActionListener al)
    {
        rbLocalidad.addActionListener(al);
    }
    public void addRbTipo(ActionListener al)
    {
        rbTipo.addActionListener(al);
    }
    public void addRbEstado(ActionListener al)
    {
        rbEstado.addActionListener(al);
    }
    public void addRbDesmarcar(ActionListener al)
    {
        rbDesmarcar.addActionListener(al);
    }
    public void addRbCalle(ActionListener al)
    {
        rbCalle.addActionListener(al);
    }
    public void addRbHabitacion(ActionListener al)
    {
        rbHabitacion.addActionListener(al);
    }
    public void addCbOpciones(ActionListener al)
    {
        cbOpciones.addActionListener(al);
    }
    public void addJbSalir(ActionListener al)
    {
        jbSalir.addActionListener(al);
    }

    public void MostratMensaje (String mensaje)
    {JOptionPane.showMessageDialog(null, mensaje);}
}
