package com.eiv.convesortasas;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.eiv.conversortasas.TasaEfectiva;

@RunWith(Parameterized.class)
public class TasaEfectivaTest {

        
    @Parameter(0) public BigDecimal tea;
    @Parameter(1) public Integer moduloOrigen;
    @Parameter(2) public Integer moduloDestino;
    @Parameter(3) public String tipoTasa;
    @Parameter(4) public Integer dias;
    @Parameter(5) public BigDecimal valorEsperado;
    

    @Parameters(
            name = "{index}: TEA: {0} - Módulo Origen:{1}"
                    + " Módulo destino:{2} Tipo tasa:{3} Dias:{4} Valor esperado:{5}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            { BigDecimal.valueOf(61.1532103158824800),365, 30, "tnv", 
                    30, BigDecimal.valueOf(4.00) },
            { BigDecimal.valueOf(64.3236216205492300),365, 30, "tna", 
                    30, BigDecimal.valueOf(4.00) },
            { BigDecimal.valueOf(81.0519216455433300), 
                    365, 30, "te", 30, BigDecimal.valueOf(5.00) },
            { BigDecimal.valueOf(5), 30, 365, "tnv", 
                    30, BigDecimal.valueOf(60.8333333333333333) },
            { BigDecimal.valueOf(5), 30, 365, "tna", 
                    30, BigDecimal.valueOf(57.9365079365080350) }
        });
    }
    
    @Test
    public void givenTasaEfectiva_whenConversion_thenTasaEsperada() {
        
        
        TasaEfectiva tasaefectiva = new TasaEfectiva(tea, moduloOrigen);
        BigDecimal resultado;
        
        
         
        switch (tipoTasa) {
            case "tnv":
                resultado = tasaefectiva.convertiraTasaNominalVencida(
                        moduloDestino, dias).getValor();
                break;
            case "tna":
                resultado = tasaefectiva.convertiraTasaNominalAdelantada(
                        moduloDestino, dias).getValor();
                break;

            case "te":
                resultado = tasaefectiva.convertiraTasaEfectiva(moduloDestino).getValor();
                break;
            default:
                resultado = null;
                break;
        }
        
       
                
        assertEquals(valorEsperado.longValue(), resultado.longValue());
        
    }
    
    
}
