package Controlador;

import Modelo.Inmueble;
import Modelo.Persona;
import Vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorVP {
    private Controlador c;

    private VentanaPrincipal vp;

    public ControladorVP(Controlador c) {
        this.c = c;
    }

    public void mostrarPrincipal()
    {
        vp = new VentanaPrincipal();
        vp.setVisible(true);

        vp.addJmAltaU(new jmAltaUAl());
        vp.addJmAltaI(new jmAltaIAl());
        vp.addJmModiU(new jmModiUAl());
        vp.addJmModiI(new jmModiIAl());
        vp.addJmBajaU(new jmBajaUAl());
        vp.addJmBajaI(new jmBajaIAl());
        vp.addJmConsultar(new jmConsultarAl());
        vp.addJmComprar(new jmComprarAl());
        vp.addJbSalir(new jbSalirAl());
    }

    public class jmAltaUAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean modelo = true;
            int accion = 1;
            c.distribucion(modelo, accion);
        }
    }
    public class jmAltaIAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean modelo = false;
            int accion = 1;
            c.distribucion(modelo, accion);
        }
    }
    public class jmModiUAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean modelo = true;
            int accion = 2;
            c.distribucion(modelo, accion);
        }
    }

    public class jmModiIAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean modelo = false;
            int accion = 2;
            c.distribucion(modelo, accion);
        }
    }
    public class jmBajaUAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean modelo = true;
            int accion = 3;
            c.distribucion(modelo, accion);
        }
    }
    public class jmBajaIAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean modelo = false;
            int accion = 3;
            c.distribucion(modelo, accion);
        }
    }

    public class jmConsultarAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean modelo = false;
            int accion = 4;
            c.distribucion(modelo, accion);
        }
    }

    public class jmComprarAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean modelo = false;
            int accion = 5;
            c.distribucion(modelo, accion);
        }
    }

    public class jbSalirAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            vp.dispose();
        }
    }
}
