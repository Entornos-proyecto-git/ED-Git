package Controlador;

import Modelo.Inmueble;
import Modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private ControladorVP cvp;
    private ControladorVAU cvau;
    private ControladorVAI cvai;
    private ControladorVC cvc;
    private ControladorVCA cvca;
    private ControladorVM cvm;
    private ControladorVB cvb;

    private List<Persona> listaPersonas;
    private List<Inmueble> listaInmuebles;

    public Controlador() {
        cvp = new ControladorVP(this);
        cvau = new ControladorVAU(this);
        cvai = new ControladorVAI(this);
        cvc = new ControladorVC(this);
        cvca = new ControladorVCA(this);
        cvm = new ControladorVM(this);
        cvb = new ControladorVB(this);

        listaPersonas = new ArrayList<>();
        listaInmuebles = new ArrayList<>();

        PasarListas(listaPersonas, listaInmuebles);

        cvp.mostrarPrincipal();
    }

    public void PasarListas(List<Persona> listaPersonas, List<Inmueble> listaInmuebles)
    {
        this.listaPersonas = listaPersonas;
        this.listaInmuebles = listaInmuebles;

        cvau.PasarListas(listaPersonas, listaInmuebles);
        cvai.PasarListas(listaPersonas, listaInmuebles);
        cvc.PasarListas(listaPersonas, listaInmuebles);
        cvca.PasarListas(listaPersonas, listaInmuebles);
        cvm.PasarListas(listaPersonas, listaInmuebles);
        cvb.PasarListas(listaPersonas, listaInmuebles);
    }

    public void distribucion (boolean modelo, int accion)
    {
        switch (accion)
        {
            case 1:
                if (modelo)
                    cvau.mostrarTodo();
                else
                    cvai.mostrarTodo();
                break;
            case 2:
                cvm.MostrarTodo(modelo);
                break;
            case 3:
                cvb.MostrarTodo(modelo);
                break;
            case 4:
                cvc.mostrarTodo();
                break;
            case 5:
                cvca.MostratTodo();
                break;
        }


    }
}
