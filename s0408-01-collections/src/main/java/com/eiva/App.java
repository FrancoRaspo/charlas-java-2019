package com.eiva;

import java.util.List;
import java.util.Optional;

public class App {

    private PrestamoDatasource datasource;
    
    public static void main(String[] args) {

        App app = new App();

        app.run();

    }

    public App() {
        datasource = new PrestamoDatasourceImpl();
        
    }

    /**
     * 
     */
    public void run() {
        Long prestamoId = 1L;
        List<PrestamoCuota> prestamo = datasource.buscarPrestamo(prestamoId);
        
        for (PrestamoCuota cuota: prestamo)
        {
            System.out.println("Cuota:" + cuota);
        } 
        
        
        prestamo.stream().forEach(
                cuota->System.out.println("Cuota:" + cuota)
                );
        
        //Optional<PrestamoCuota> optional =   
                prestamo.stream()
        .filter((cuota)-> 
                cuota.getPeriodo().getMes().equals(PrestamoCuota.Periodo.MesEnum.ABRIL) && 
                cuota.getPeriodo().getAnio().equals(2019)
                )   
        .findFirst()
        .ifPresent(cuota-> System.out.println("Encontrando la cuota: " + cuota));    
                    
        
        /*
        if (optional.isPresent()) {
            System.out.println("Encontrando la cuota: " + optional);
        }
        else
        {
            System.out.println("No encontre la cuota");
        }*/
    }

}
