package com.eiva;

import java.util.logging.Logger;

public class App {
    private static final Logger LOG = Logger.getLogger("App de prueba");
 
    // TODO Auto-generated method stub


    public static void main(String[] args) {

        
        LOG.info("Primer mensaje");
        LOG.info("Segundo mensaje");
        LOG.warning("Cuidado!!!");
        LOG.severe("I Kill you!!!");
        LOG.fine("Fine Cool!!!");

        // Log4J2 *standar*
        // LogBack
    }
}
