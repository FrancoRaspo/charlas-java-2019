package com.eiva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); ;
        
        BigDecimal capital = null;
        Integer nroCuotas = null;
        BigDecimal tasa = null;
        LocalDate fecha = null;

        
        Double inCapital = 0D;
        Double inTasa = 0D;
        String inFecha;

        try {
            scanner = new Scanner(System.in);
            System.out.println("Ingrese monto de capital:");
            inCapital = scanner.nextDouble();
            capital = BigDecimal.valueOf(inCapital);
            
        } catch (Exception e) {
            System.out.println("Ingrese un valor correcto para capital");
        }

            if (capital!=null && capital.compareTo(BigDecimal.ZERO)>0) {
                try {
                    scanner = new Scanner(System.in);
                    System.out.println("Ingrese la cantidad de cuotas:");
                    nroCuotas = scanner.nextInt();
                    
                } catch (Exception e) {
                    System.out.println("Ingrese un valor correcto para cantidad de cuotas" + e.getMessage());
        
                }
            }
            
            if (nroCuotas!=null && nroCuotas>0){
                try {
                    scanner = new Scanner(System.in);
                    System.out.println("Ingrese la tasa:");
                    inTasa = scanner.nextDouble();
                    tasa = BigDecimal.valueOf(inTasa);
                    
                } catch (Exception e) {
                    System.out.println("Ingrese un valor correcto para la tasa");
                }
            }
            
            if (tasa != null) {
                try {
                    scanner = new Scanner(System.in);
                    System.out.println("Ingrese fecha (AAAA-MM-DD):");
                    inFecha = scanner.next();
                    fecha = LocalDate.parse(inFecha);
                    
        
                } catch (Exception e) {
                    System.out.println("Ingrese un valor correcto para fecha. AAAA-MM-DD");
                }
            }

            scanner.close();
            
            if (capital != null && capital.compareTo(BigDecimal.ZERO)==0) {
                System.out.println("El captial debe ser mayor a 0");
            }
            
            if (nroCuotas!=null && nroCuotas==0) {
                System.out.println("La cantidad de cuotas debe ser mayor a 0");
            }
            
        if (tasa!=null && capital!=null && nroCuotas != null && fecha != null) {
            try {
                PrestamoFrances prestamo = new PrestamoFrances(capital, nroCuotas, tasa, fecha);
    
                prestamo.CalcularCuotas();
    
                prestamo.getCuotas().forEach((nro, cuota) -> {
                    System.out.println(cuota);
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        
    }

}
