package Controlador;

import Modelo.Inmueble;
import Modelo.Persona;
import Vista.VentanaModificar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorVM {
    private Controlador c;
    private VentanaModificar vm;

    private List<Persona> listaPersonas;
    private List<Inmueble> listaInmuebles;
    private Boolean modelo;

    public ControladorVM(Controlador c) {
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
        vm = new VentanaModificar();
        empezar();
    }
    public void empezar()
    {

        if (modelo)
        {
            vm.getTf1().setEnabled(false);
            vm.getL2().setText("DNI");
            vm.getL3().setText("Nombre");
            vm.getL4().setText("Apellido");
        }
        else
        {
            vm.getTf2().setEnabled(false);
            vm.getL1().setText("Código");
            vm.getL2().setText("Localidad");
            vm.getL3().setText("Calle");
            vm.getL4().setText("Nº de habitaciones");
        }


        vm.setVisible(true);
        vm.addJbBuscar(new JbBuscarAl());
        vm.addJbModificar(new JbModificarAl());
        vm.addJbSalir(new JbSalirAl());
    }
    public class JbBuscarAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if (modelo)
                {
                    if (vm.getTf2().getText().isEmpty())
                        throw new Exception("El DNI no puede estar vacio");

                    Pattern pat2 = Pattern.compile("^[0-9]{8}[A-Z]$");
                    Matcher mat2 = pat2.matcher(vm.getTf2().getText());
                    if (!mat2.matches())
                        throw new Exception("El DNI no cumple el formato deseado (EJ: 12345678A)");

                    for (int x = 0; x < listaPersonas.size(); x++)
                    {
                        if (listaPersonas.get(x).getDni().equals(vm.getTf2().getText()))
                        {
                            vm.getTf2().setEnabled(false);
                            vm.getTf3().setEnabled(true);
                            vm.getTf4().setEnabled(true);
                            vm.getTf3().setText(listaPersonas.get(x).getNombre());
                            vm.getTf4().setText(listaPersonas.get(x).getApellido());
                        }
                        else
                        {
                            throw new Exception("Este DNI no esta registrado");
                        }
                    }
                }
                else
                {
                    if (vm.getTf1().getText().isEmpty())
                        throw new Exception("El código no puede estar vacio");

                    Pattern pat1 = Pattern.compile("^[0-9]{3}[A-Z]$");
                    Matcher mat1 = pat1.matcher(vm.getTf1().getText());
                    if (!mat1.matches())
                        throw new Exception("El código no cumple el formato deseado (EJ: 123A)");

                    for (int x = 0; x < listaInmuebles.size(); x++)
                    {
                        if (listaInmuebles.get(x).getCodigo().equals(vm.getTf1().getText()))
                        {
                            vm.getTf1().setEnabled(false);
                            vm.getTf2().setEnabled(true);
                            vm.getTf3().setEnabled(true);
                            vm.getTf4().setEnabled(true);
                            vm.getTf2().setText(listaInmuebles.get(x).getLocalidad());
                            vm.getTf3().setText(listaInmuebles.get(x).getCalle());
                            vm.getTf4().setText(String.valueOf(listaInmuebles.get(x).getnHabitaciones()));
                        }
                        else
                        {
                            throw new Exception("Este inmuebele no esta registrado");
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                vm.MostrarMensaje(ex.getMessage());
            }

        }
    }
    public class JbModificarAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                if (modelo)
                {
                    if (vm.getTf3().getText().isEmpty())
                        throw new Exception("El nombre no puede estar vacio");

                    Pattern pat4 = Pattern.compile("^[A-Z][a-z]+( [A-Z][a-z]+)*$");
                    Matcher mat4 = pat4.matcher(vm.getTf3().getText());
                    if (!mat4.matches())
                        throw new Exception("El nombre tiene que empezar por mayuscula");

                    if (vm.getTf4().getText().isEmpty())
                        throw new Exception("El apellido no puede estar vacio");

                    Pattern pat5 = Pattern.compile("^[A-Z][a-z]+( [A-Z][a-z]+)*$");
                    Matcher mat5 = pat5.matcher(vm.getTf4().getText());
                    if (!mat5.matches())
                        throw new Exception("El apellido tiene que empezar por mayuscula");

                    for (int x = 0; x < listaPersonas.size(); x++)
                    {
                        if (listaPersonas.get(x).getDni().equals(vm.getTf2().getText()))
                        {
                            listaPersonas.get(x).setNombre(vm.getTf3().getText());
                            listaPersonas.get(x).setApellido(vm.getTf4().getText());
                        }
                    }
                }
                else
                {

                    if (vm.getTf2().getText().isEmpty())
                        throw new Exception("La localidad no puede estar vacio");

                    if (vm.getTf3().getText().isEmpty())
                        throw new Exception("La calle no puede estar vacio");

                    if (vm.getTf4().getText().isEmpty())
                        throw new Exception("El número de habitaciones no puede estar vacio");
                }
                for (int x = 0; x < listaInmuebles.size(); x++)
                {
                    if (listaInmuebles.get(x).getCodigo().equals(vm.getTf1().getText()))
                    {
                        listaInmuebles.get(x).setLocalidad(vm.getTf2().getText());
                        listaInmuebles.get(x).setCalle(vm.getTf3().getText());
                        listaInmuebles.get(x).setnHabitaciones(Integer.parseInt(vm.getTf4().getText()));
                    }
                }
                vm.Limpiar();
            }
            catch (Exception ex)
            {
                vm.MostrarMensaje(ex.getMessage());
            }
        }
    }
    public class JbSalirAl implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            vm.dispose();
            c.PasarListas(listaPersonas, listaInmuebles);
        }
    }
}
