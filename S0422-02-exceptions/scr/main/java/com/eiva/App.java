package com.eiva;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        

        Scanner scanner=new Scanner(System.in);
        
        System.out.println("Ingrese un número:");
        
        String in = scanner.next();
        
        try {
            Integer numero=Integer.valueOf(in);
            
            Integer numero2=numero/0;
            
            System.out.println("número --> "+ numero);
            System.out.println("número/2 --> "+ numero2);
        }
        
        catch(Exception e) {
            System.out.println( in + " <-- ¿te parece un número? ".concat( e.getMessage() ));
            
        } finally {
            System.out.println( "Bye Bye");
            
            scanner.close();
        }                
        
    }

}
