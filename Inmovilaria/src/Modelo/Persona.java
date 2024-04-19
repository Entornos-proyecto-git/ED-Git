package Modelo;

import java.util.List;

public class Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private List<Inmueble> listaImuebles;

    public Persona(String dni, String nombre, String apellido, List<Inmueble> listaImuebles) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaImuebles = listaImuebles;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Inmueble> getListaImuebles() {
        return listaImuebles;
    }

    public void setListaImuebles(List<Inmueble> listaImuebles) {
        this.listaImuebles = listaImuebles;
    }
}
