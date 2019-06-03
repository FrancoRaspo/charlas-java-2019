package com.eiva;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.eiva.sub.SubApp;

public class App2 {

    private static final Logger LOG = LogManager.getLogger(App2.class);

    public static void main(String[] args) {

        LOG.trace("Tracenado");
        LOG.debug("Debugueando");
        LOG.info("Info message");
        LOG.warn("Mensaje de advertencia");

        LOG.error("Ups error"); // el nivel de logger esta desde acá
        LOG.fatal("Fatality error");

        SubApp.run(null);

        try {
            SubApp.dividir(100, 0);
        } catch (RuntimeException e) {

               LOG.info("LOG.isDebugEnabled()->" + LOG.isDebugEnabled());
            
            if (LOG.isDebugEnabled()) {
                LOG.error("Division por 0",e);
            } else {
                LOG.error("Division por 0");
            }

        }

    }

}
