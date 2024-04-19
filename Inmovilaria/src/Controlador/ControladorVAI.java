package Controlador;

import Modelo.Inmueble;
import Modelo.Persona;
import Vista.VentanaAltaI;
import Vista.VentanaAltaU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorVAI {
    private Controlador c;

    private VentanaAltaI vai;

    private List<Persona> listaPersonas;
    private List<Inmueble> listaInmuebles;

    public ControladorVAI(Controlador c) {
        this.c = c;
    }

    public void PasarListas(List<Persona> listaPersonas, List<Inmueble> listaInmuebles)
    {
        this.listaPersonas = listaPersonas;
        this.listaInmuebles = listaInmuebles;
    }

    public  void mostrarTodo()
    {
        vai = new VentanaAltaI();
        vai.setVisible(true);

        vai.addJbAceptar(new JbAceptarAL());
        vai.addJbSalir(new JbSalirAL());
    }

    public class JbAceptarAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if (vai.getTfCodigo().getText().isEmpty())
                    throw new Exception("El código no puede estar vacio");

                Pattern pat1 = Pattern.compile("^[0-9]{3}[A-Z]$");
                Matcher mat1 = pat1.matcher(vai.getTfCodigo().getText());
                if (!mat1.matches())
                    throw new Exception("El código no cumple el formato deseado (EJ: 123A)");

                boolean encontradoI = true;
                for (int x = 0; listaInmuebles.size() > x && encontradoI; x++)
                {
                    if (listaInmuebles.get(x).getCodigo().equals(vai.getTfCodigo().getText()))
                        encontradoI = false;
                }

                if (encontradoI == false)
                    throw new Exception("Ya existe un inmueble con este codigo");

                if (vai.getTfDni().getText().isEmpty())
                    throw new Exception("El DNI no puede estar vacio");

                Pattern pat2 = Pattern.compile("^[0-9]{8}[A-Z]$");
                Matcher mat2 = pat2.matcher(vai.getTfDni().getText());
                if (!mat2.matches())
                    throw new Exception("El DNI no cumple el formato deseado (EJ: 12345678A)");

                if (vai.getTfLocalidad().getText().isEmpty())
                    throw new Exception("La localidad no puede estar vacio");

                if (vai.getTfCalle().getText().isEmpty())
                    throw new Exception("La calle no puede estar vacio");

                if (vai.getTfHabitacion().getText().isEmpty())
                    throw new Exception("El número de habitaciones no puede estar vacio");

                int habitaciones = Integer.parseInt(vai.getTfHabitacion().getText());

                boolean encontrado = true;
                for (int x = 0; listaPersonas.size() > x && encontrado; x++)
                {
                    if (listaPersonas.get(x).getDni().equals(vai.getTfDni().getText()))
                        encontrado = false;
                }

                if (encontrado)
                    throw new Exception("No exite ningún usuario con este DNI, asi que dese de alta antes de dar de alat un inmueble");

                String tipo;
                if (vai.getRbVivienda().isSelected())
                    tipo = "Vivienda";
                else if (vai.getRbComercio().isSelected())
                    tipo = "Comercio";
                else if (vai.getRbOficina().isSelected())
                    tipo = "Oficina";
                else
                    throw  new Exception("Seleccione el tipo de inmueble que es");

                Inmueble i = new Inmueble(vai.getTfCodigo().getText(), vai.getTfLocalidad().getText(), vai.getTfCalle().getText(), habitaciones, tipo, "En venta");
                listaInmuebles.add(i);

                boolean encontrado2 = true;
                for (int x = 0; listaPersonas.size() > x && encontrado2; x++)
                {
                    if (listaPersonas.get(x).getDni().equals(vai.getTfDni().getText()))
                    {
                        encontrado2 = false;
                        listaPersonas.get(x).getListaImuebles().add(i);
                    }
                }

            }
            catch (Exception ex)
            {
                vai.MostrarMensaje(ex.getMessage());
            }
        }
    }

    public class JbSalirAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            vai.dispose();
        }
    }
}
