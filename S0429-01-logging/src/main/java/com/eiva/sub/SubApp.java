package com.eiva.sub;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SubApp  {

    private static final Logger LOG = LogManager.getLogger(SubApp.class);  
    
    
    public static void run(String[] args) {
        LOG.info("Subinfo log");
        LOG.fatal("Fatality !!");

    }

    
    public static int dividir(int dividendo , int divisor)
    {
        if (divisor==0)
        {
            throw new RuntimeException("Division por 0.");
        }
        
        
        return (dividendo/divisor);        
    }
    
    
}
