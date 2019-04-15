package com.eiva;

public class Perro implements Comparable<Perro>  {

    String nombre;
    String raza;

    public Perro() {
    }

    public Perro(String nombre, String raza) {
        super();
        this.nombre = nombre;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Mi nombre es " + nombre + " y soy de raza " + raza;
    }

    @Override
    public int compareTo(Perro o) {
        return this.nombre.compareTo(o.getNombre());
    }

   
}
