package Controlador;

import Modelo.Inmueble;
import Modelo.Persona;
import Vista.VentanaAltaU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorVAU {
    private Controlador c;

    private VentanaAltaU vau;

    private List<Persona> listaPersonas;
    private List<Inmueble> listaInmuebles;

    public ControladorVAU(Controlador c) {
        this.c = c;
    }

    public void PasarListas(List<Persona> listaPersonas, List<Inmueble> listaInmuebles)
    {
        this.listaPersonas = listaPersonas;
        this.listaInmuebles = listaInmuebles;
    }

    public  void mostrarTodo()
    {
        vau = new VentanaAltaU();
        vau.setVisible(true);

        vau.addJbAceptar(new JbAceptarAL());
        vau.addJbSalir(new JbSalirAL());
    }

    public class JbAceptarAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if (vau.getTfDni().getText().isEmpty())
                    throw new Exception("El DNI no puede estar vacio");

                Pattern pat2 = Pattern.compile("^[0-9]{8}[A-Z]$");
                Matcher mat2 = pat2.matcher(vau.getTfDni().getText());
                if (!mat2.matches())
                    throw new Exception("El DNI no cumple el formato deseado (EJ: 12345678A)");

                boolean encontrado = true;
                for (int x = 0; listaPersonas.size() > x && encontrado; x++)
                {
                    if (listaPersonas.get(x).getDni().equals(vau.getTfDni().getText()))
                        encontrado = false;
                }

                if (encontrado == false)
                    throw new Exception("Ya existe un usuario con este DNI");

                if (vau.getTfNombre().getText().isEmpty())
                    throw new Exception("El nombre no puede estar vacio");

                Pattern pat4 = Pattern.compile("^[A-Z][a-z]+( [A-Z][a-z]+)*$");
                Matcher mat4 = pat4.matcher(vau.getTfNombre().getText());
                if (!mat4.matches())
                    throw new Exception("El nombre tiene que empezar por mayuscula");

                if (vau.getTfApellido().getText().isEmpty())
                    throw new Exception("El apellido no puede estar vacio");

                Pattern pat5 = Pattern.compile("^[A-Z][a-z]+( [A-Z][a-z]+)*$");
                Matcher mat5 = pat5.matcher(vau.getTfApellido().getText());
                if (!mat5.matches())
                    throw new Exception("El apellido tiene que empezar por mayuscula");

                List<Inmueble> listaInmueblePersona = new ArrayList<>();

                Persona p = new Persona(vau.getTfDni().getText(), vau.getTfNombre().getText(), vau.getTfApellido().getText(), listaInmueblePersona);
                listaPersonas.add(p);
                vau.limpiar();
            }
            catch (Exception ex)
            {
                vau.MostrarMensaje(ex.getMessage());
            }
        }
    }

    public class JbSalirAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            vau.dispose();
        }
    }
}
