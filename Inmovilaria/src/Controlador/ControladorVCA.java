package Controlador;

import Modelo.Inmueble;
import Modelo.Persona;
import Vista.VentanaComprar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorVCA {
    private Controlador c;
    private VentanaComprar vc;

    private List<Persona> listaPersonas;
    private List<Inmueble> listaInmuebles;

    public ControladorVCA(Controlador c) {
        this.c = c;
    }

    public void PasarListas(List<Persona> listaPersonas, List<Inmueble> listaInmuebles)
    {
        this.listaPersonas = listaPersonas;
        this.listaInmuebles = listaInmuebles;
    }

    public void MostratTodo()
    {
        vc = new VentanaComprar();
        vc.setVisible(true);

        vc.addJbAceptar(new JbAceptarAl());
        vc.addJbSalir(new JbSalirAl());
    }

    public class JbAceptarAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if (vc.getTfCod().getText().isEmpty())
                    throw new Exception("El código no puede estar vacio");

                Pattern pat1 = Pattern.compile("^[0-9]{3}[A-Z]$");
                Matcher mat1 = pat1.matcher(vc.getTfCod().getText());
                if (!mat1.matches())
                    throw new Exception("El código no cumple el formato deseado (EJ: 123A)");

                boolean encontradoI = true;
                for (int x = 0; listaInmuebles.size() > x && encontradoI; x++)
                {
                    if (listaInmuebles.get(x).getCodigo().equals(vc.getTfCod().getText()))
                        encontradoI = false;
                }

                if (encontradoI == true)
                    throw new Exception("No existe un inmueble con este codigo");

                if (vc.getTfDni().getText().isEmpty())
                    throw new Exception("El DNI no puede estar vacio");

                Pattern pat2 = Pattern.compile("^[0-9]{8}[A-Z]$");
                Matcher mat2 = pat2.matcher(vc.getTfDni().getText());
                if (!mat2.matches())
                    throw new Exception("El DNI no cumple el formato deseado (EJ: 12345678A)");

                boolean encontrado = true;
                for (int x = 0; listaPersonas.size() > x && encontrado; x++)
                {
                    if (listaPersonas.get(x).getDni().equals(vc.getTfDni().getText()))
                        encontrado = false;
                }

                if (encontrado)
                    throw new Exception("No exite ningún usuario con este DNI, asi que dese de alta antes de dar de alat un inmueble");

                String estado = "";
                if (vc.getRbComprar().isSelected())
                    estado = "Comprado";
                else
                    if (vc.getRbAlquilar().isSelected())
                        estado = "Alquilado";
                    else
                        throw new Exception("Seleccione la opción de comparar o alquilar");

                Inmueble i = null;

                for(int x = 0; x < listaInmuebles.size(); x++)
                {
                    if (listaInmuebles.get(x).getCodigo().equals(vc.getTfCod().getText()))
                        i = listaInmuebles.get(x);
                    i.setEstado(estado);
                }
                for (int y = 0; y < listaPersonas.size(); y++)
                {
                    if (listaPersonas.get(y).getDni().equals(vc.getTfDni().getText()))
                        listaPersonas.get(y).getListaImuebles().add(i);
                }
                for (int y = 0; y < listaPersonas.size(); y++)
                {
                    for (int z = 0; z < listaPersonas.get(y).getListaImuebles().size(); z++)
                    {
                        if (listaPersonas.get(y).getListaImuebles().get(z).getCodigo().equals(vc.getTfCod().getText()))
                            listaPersonas.get(y).getListaImuebles().remove(z);
                    }
                }
            }
            catch (Exception ex)
            {
                vc.MostrarMensaje(ex.getMessage());
            }
        }
    }

    public class JbSalirAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            vc.dispose();
            c.PasarListas(listaPersonas, listaInmuebles);
        }
    }
}
