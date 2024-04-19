package Controlador;

import Modelo.Inmueble;
import Modelo.Persona;
import Vista.VentanaConsultar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ControladorVC {
    private Controlador c;

    private VentanaConsultar vc;

    private List<Persona> listaPersonas;
    private List<Inmueble> listaInmuebles;
    private List<String> listaComodin;
    private List<Integer> listaComodin2;
    private int opcion;

    public ControladorVC(Controlador c) {
        this.c = c;
    }

    public void PasarListas(List<Persona> listaPersonas, List<Inmueble> listaInmuebles)
    {
        this.listaPersonas = listaPersonas;
        this.listaInmuebles = listaInmuebles;
    }

    public void mostrarTodo()
    {
        vc = new VentanaConsultar();
        vc.setVisible(true);

        listaComodin = new ArrayList<>();

        vc.addCbOpciones(new CbOpcionesAL());
        vc.addRbLocalidad(new RbLocalidadAL());
        vc.addRbCalle(new RbCalleAL());
        vc.addRbTipo(new RbTipoAL());
        vc.addRbEstado(new RbEstadoAL());
        vc.addRbHabitacion(new RbHabitacionAL());
        vc.addRbDesmarcar(new RbDesmarcarAL());
        vc.addJbSalir(new JbSalirAL());
    }

    public class CbOpcionesAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if (vc.getCbOpciones().getSelectedIndex() == 0)
                    throw new Exception("Elija alguna opcion");

                String txt = "";
                int elegido = vc.getCbOpciones().getSelectedIndex() -1;
                switch (opcion)
                {
                    case 1:
                        for(int x = 0; x < listaInmuebles.size(); x++)
                        {
                            if (listaComodin.get(elegido).equals(listaInmuebles.get(x).getLocalidad()))
                                txt = txt + listaInmuebles.get(x).toString() + "\n";
                        }
                        break;
                    case 2:
                        for(int x = 0; x < listaInmuebles.size(); x++)
                        {
                            if (listaComodin.get(elegido).equals(listaInmuebles.get(x).getTipo()))
                                txt = txt + listaInmuebles.get(x).toString() + "\n";
                        }
                        break;
                    case 3:
                        for(int x = 0; x < listaInmuebles.size(); x++)
                        {
                            if (listaComodin.get(elegido).equals(listaInmuebles.get(x).getEstado()))
                                txt = txt + listaInmuebles.get(x).toString() + "\n";
                        }
                        break;
                    case 4:
                        for(int x = 0; x < listaInmuebles.size(); x++)
                        {
                            if (listaComodin.get(elegido).equals(listaInmuebles.get(x).getCalle()))
                                txt = txt + listaInmuebles.get(x).toString() + "\n";
                        }
                        break;
                    case 5:
                        for(int x = 0; x < listaInmuebles.size(); x++)
                        {
                            if (listaComodin2.get(elegido)==(listaInmuebles.get(x).getnHabitaciones()))
                                txt = txt + listaInmuebles.get(x).toString() + "\n";
                        }
                        break;
                }
                vc.getTaResultado().setText(txt);
            }
            catch (Exception ex)
            {
                vc.MostratMensaje(ex.getMessage());
            }
        }
    }
    public class RbLocalidadAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            listaComodin.clear();
            vc.getCbOpciones().removeAllItems();
            vc.getCbOpciones().addItem("Elija un opción");
            for (int x = 0; x < listaInmuebles.size(); x++)
            {
                for (int y = 0; y < listaComodin.size(); y++)
                {
                    if (!listaInmuebles.get(x).getLocalidad().equals(listaComodin.get(y)))
                        listaComodin.add(listaInmuebles.get(x).getLocalidad());
                }
            }
            for (int z = 0; z < listaComodin.size(); z++)
            {
                vc.getCbOpciones().addItem(listaComodin.get(z));
            }
            opcion = 1;
        }
    }
    public class RbTipoAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            listaComodin.clear();
            vc.getCbOpciones().removeAllItems();
            vc.getCbOpciones().addItem("Elija un opción");
            vc.getCbOpciones().addItem("Oficina");
            vc.getCbOpciones().addItem("Vivienda");
            vc.getCbOpciones().addItem("Estudio");
            listaComodin.add("Oficina");
            listaComodin.add("Vivienda");
            listaComodin.add("Estudio");
            opcion = 2;
        }
    }
    public class RbEstadoAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            listaComodin.clear();
            vc.getCbOpciones().removeAllItems();
            vc.getCbOpciones().addItem("Elija un opción");
            vc.getCbOpciones().addItem("En venta");
            vc.getCbOpciones().addItem("Comprado");
            vc.getCbOpciones().addItem("Alquilado");
            listaComodin.add("En venta");
            listaComodin.add("Comprado");
            listaComodin.add("Alquilado");
            opcion = 3;
        }
    }
    public class RbCalleAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            listaComodin.clear();
            vc.getCbOpciones().removeAllItems();
            vc.getCbOpciones().addItem("Elija un opción");
            for (int x = 0; x < listaInmuebles.size(); x++)
            {
                for (int y = 0; y < listaComodin.size(); y++)
                {
                    if (!listaInmuebles.get(x).getCalle().equals(listaComodin.get(y)))
                        listaComodin.add(listaInmuebles.get(x).getCalle());
                }
            }
            for (int z = 0; z < listaComodin.size(); z++)
            {
                vc.getCbOpciones().addItem(listaComodin.get(z));
            }
            opcion = 4;
        }
    }
    public class RbHabitacionAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            listaComodin2.clear();
            vc.getCbOpciones().removeAllItems();
            vc.getCbOpciones().addItem("Elija un opción");
            for (int x = 0; x < listaInmuebles.size(); x++)
            {
                for (int y = 0; y < listaComodin2.size(); y++)
                {
                    if (!(listaInmuebles.get(x).getnHabitaciones() == listaComodin2.get(y)))
                        listaComodin2.add(listaInmuebles.get(x).getnHabitaciones());
                }
            }
            for (int z = 0; z < listaComodin.size(); z++)
            {
                vc.getCbOpciones().addItem(listaComodin2.get(z));
            }
            opcion = 5;
        }
    }
    public class RbDesmarcarAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            vc.getCbOpciones().removeAllItems();
            vc.getCbOpciones().setEnabled(false);
            String texto = "";
            for (int x = 0; x < listaInmuebles.size(); x++)
            {
                texto = texto + listaInmuebles.get(x).toString() + "\n";
            }
            vc.getTaResultado().setText(texto);
        }
    }
    public class JbSalirAL implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            vc.dispose();
        }
    }
}
