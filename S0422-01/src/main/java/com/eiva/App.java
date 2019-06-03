package com.eiva;

import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        List<Persona> personas = Persona.personas();

        personas.forEach((persona) -> {
            if (persona.getNombre() == "Diego") {
                System.out.println(persona);
            }
        });

        List<String> apellidos = personas.stream()
                .map(persona -> persona.getApellido()).collect(Collectors.toList());

        System.out.println("----------------- Apellidos: -----------------");
        apellidos.forEach(apellido -> System.out.println(apellido));

        List<String> nombreApellido = personas.stream()
                .filter(persona -> persona.getApellido().equals("Raspo"))
                .map(persona -> persona.getNombre().concat(", ").concat(persona.getApellido()))
                .sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());

        System.out.println("----------------- Nombre y Apellidos: -----------------");

        nombreApellido.forEach(nombre -> System.out.println(nombre));

        String apellidoBusco = "Data";

        System.out.println("----------------- Algun " + apellidoBusco + ": -----------------");
        boolean hay = apellidos.stream().noneMatch(apellido -> apellido.contains(apellidoBusco));

        System.out.println((!hay ? "Hay " : "No hay ") + apellidoBusco + "/s");
        
                
        Long suma = personas.stream()
                //.map(p -> p.getEdad())
                .collect(Collectors.summingLong(p->p.getEdad()))
                        ;
            

        System.out.println("Suma edades: " + suma);
    }

}
