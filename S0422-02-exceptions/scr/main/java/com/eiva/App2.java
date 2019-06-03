package com.eiva;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App2 {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Ingrese un número a:");

            Integer numeroA = scanner.nextInt();

            System.out.println("Ingrese un número b:");
            Integer numeroB = scanner.nextInt();

            try {
                Suma suma = new Suma(numeroA, numeroB);
                System.out.println(suma.resultado());
            }  catch (SumaException e) {

                if (e.getCodigo()==SumaException.A_MAYOR_B) 
                        {
                            System.out.println("Asi que a es mayor que b. Sos chistoso?");    
                        }
                else  
                    if (e.getCodigo()==SumaException.A_MAS_B_MAYOR_10)
                    {
                        System.out.println("No se puede si la suma es mayor que 10. Es lo que hay...");    
                    }
                       else {
                           System.out.println("Se rompio, que se la va a hacer." + e.getMessage() );   
                       };

               
            }
           
        } 
        catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Pusiste bien los datos? " + e.getMessage());
        } finally {
            System.out.println("Bye Bye");
        }

    }

}
