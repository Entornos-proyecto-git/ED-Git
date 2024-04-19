package Vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame{
    private JPanel jpPrinci;
    private JButton jbSalir;
    private JMenuItem jmAltaU;
    private JMenuItem jmBajaU;
    private JMenuItem jmModiU;
    private JMenuItem jmAltaI;
    private JMenuItem jmBajaI;
    private JMenuItem jmModiI;
    private JMenuItem jmConsultar;
    private JMenuItem jmComprar;

    public VentanaPrincipal(){
        super("Ventana Princi");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setContentPane(jpPrinci);
    }

    public JButton getJbSalir() {
        return jbSalir;
    }

    public void setJbSalir(JButton jbSalir) {
        this.jbSalir = jbSalir;
    }

    public JMenuItem getJmAltaU() {
        return jmAltaU;
    }

    public void setJmAltaU(JMenuItem jmAltaU) {
        this.jmAltaU = jmAltaU;
    }

    public JMenuItem getJmBajaU() {
        return jmBajaU;
    }

    public void setJmBajaU(JMenuItem jmBajaU) {
        this.jmBajaU = jmBajaU;
    }

    public JMenuItem getJmModiU() {
        return jmModiU;
    }

    public void setJmModiU(JMenuItem jmModiU) {
        this.jmModiU = jmModiU;
    }

    public JMenuItem getJmAltaI() {
        return jmAltaI;
    }

    public void setJmAltaI(JMenuItem jmAltaI) {
        this.jmAltaI = jmAltaI;
    }

    public JMenuItem getJmBajaI() {
        return jmBajaI;
    }

    public void setJmBajaI(JMenuItem jmBajaI) {
        this.jmBajaI = jmBajaI;
    }

    public JMenuItem getJmModiI() {
        return jmModiI;
    }

    public JMenuItem getJmConsultar() {
        return jmConsultar;
    }

    public void setJmConsultar(JMenuItem jmConsultar) {
        this.jmConsultar = jmConsultar;
    }

    public JMenuItem getJmComprar() {
        return jmComprar;
    }

    public void setJmComprar(JMenuItem jmComprar) {
        this.jmComprar = jmComprar;
    }

    public void setJmModiI(JMenuItem jmModiI) {
        this.jmModiI = jmModiI;
    }

    public void addJmAltaU(ActionListener al)
    {
        jmAltaU.addActionListener(al);
    }
    public void addJmAltaI(ActionListener al)
    {
        jmAltaI.addActionListener(al);
    }
    public void addJmBajaU(ActionListener al)
    {
        jmBajaU.addActionListener(al);
    }
    public void addJmBajaI(ActionListener al)
    {
        jmBajaI.addActionListener(al);
    }
    public void addJmModiU(ActionListener al)
    {
        jmModiU.addActionListener(al);
    }
    public void addJmModiI(ActionListener al)
    {
        jmModiI.addActionListener(al);
    }
    public void addJmConsultar(ActionListener al)
    {
        jmConsultar.addActionListener(al);
    }
    public void addJmComprar(ActionListener al)
    {
        jmComprar.addActionListener(al);
    }
    public void addJbSalir(ActionListener al)
    {
        jbSalir.addActionListener(al);
    }
}
