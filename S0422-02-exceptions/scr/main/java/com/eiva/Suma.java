package com.eiva;

public class Suma {

    
    private Integer a;
    private Integer b;
    
    public Suma(Integer a, Integer b) {
        
        if (a>b) {
            throw new SumaException(SumaException.A_MAYOR_B, "B debe ser mayor que A. capisce!");
        }
        
        this.a=a;
        this.b=b;
    }
    
    public Integer resultado() throws Exception    {
        Integer c=a+b;
        if(c>10) {
            throw new SumaException(SumaException.A_MAS_B_MAYOR_10,"a+b no puede ser mayor a 10 por que quiero");
        }
        return (c);
         
    }
    
}
