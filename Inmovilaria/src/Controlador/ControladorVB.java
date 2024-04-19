package Controlador;

import Modelo.Inmueble;
import Modelo.Persona;
import Vista.VentanaBaja;
import Vista.VentanaConsultar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorVB {

    private Controlador c;

    private VentanaBaja vb;

    private List<Persona> listaPersonas;
    private List<Inmueble> listaInmuebles;
    private boolean modelo;

    public ControladorVB(Controlador c) {
        this.c = c;
    }

    public void PasarListas(List<Persona> listaPersonas, List<Inmueble> listaInmuebles)
    {
        this.listaPersonas = listaPersonas;
        this.listaInmuebles = listaInmuebles;
    }

    public void MostrarTodo(boolean modelo)
    {
        this.modelo = modelo;
        vb = new VentanaBaja();

        if (modelo)
            vb.getL().setText("DNI");
        else
            vb.getL().setText("Código");

        vb.setVisible(true);
        vb.addJbBorrar(new JbBorrarAl());
        vb.addJbSalir(new JbSalirAl());
    }

    public class JbBorrarAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if (modelo)
                {
                    if (vb.getTf().getText().isEmpty())
                        throw new Exception("El DNI no puede estar vacio");

                    Pattern pat2 = Pattern.compile("^[0-9]{8}[A-Z]$");
                    Matcher mat2 = pat2.matcher(vb.getTf().getText());
                    if (!mat2.matches())
                        throw new Exception("El DNI no cumple el formato deseado (EJ: 12345678A)");

                    for (int x = 0; x < listaPersonas.size(); x++)
                    {
                        if (listaPersonas.get(x).getDni().equals(vb.getTf().getText()))
                            listaPersonas.remove(x);
                    }
                }
                else
                {
                    if (vb.getTf().getText().isEmpty())
                        throw new Exception("El código no puede estar vacio");

                    Pattern pat1 = Pattern.compile("^[0-9]{3}[A-Z]$");
                    Matcher mat1 = pat1.matcher(vb.getTf().getText());
                    if (!mat1.matches())
                        throw new Exception("El código no cumple el formato deseado (EJ: 123A)");

                    for (int x = 0; x < listaInmuebles.size(); x++)
                    {
                        if (listaInmuebles.get(x).getCodigo().equals(vb.getTf().getText()))
                            listaInmuebles.remove(x);
                    }
                }
                vb.getTf().setText("");
            }
            catch (Exception ex)
            {
                vb.MostrarMensaje(ex.getMessage());
            }
        }
    }

    public class JbSalirAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            vb.dispose();
            c.PasarListas(listaPersonas, listaInmuebles);
        }
    }
}
