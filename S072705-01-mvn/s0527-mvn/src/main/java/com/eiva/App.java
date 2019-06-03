package com.eiva;

import org.apache.commons.codec.digest.DigestUtils;

public class App 
{
    public static void main( String[] args )
    {
        App app= new App();
        if (args.length!=0 ) {
            app.run(args[0]);
        }
        else {
            app.run("");    
        }
    }

    public void run(String msg) {
        System.out.println("Input message-> " + msg);
        System.out.println("Length->"+ msg.length());
        System.out.println("Sha256Hex->"+ DigestUtils.sha256Hex(msg));
        System.out.println("HashCode->"+ msg.hashCode());
    }
}
