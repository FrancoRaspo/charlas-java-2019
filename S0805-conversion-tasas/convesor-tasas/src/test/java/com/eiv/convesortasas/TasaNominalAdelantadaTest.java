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

import com.eiv.conversortasas.TasaNominalAdelantada;

@RunWith(Parameterized.class)
public class TasaNominalAdelantadaTest {

        
    @Parameter(0) public BigDecimal tna;
    @Parameter(1) public Integer moduloOrigen;
    @Parameter(2) public Integer moduloDestino;
    @Parameter(3) public String tipoTasa;
    @Parameter(4) public Integer dias;
    @Parameter(5) public BigDecimal valorEsperado;
    

    @Parameters(
            name = "{index}: TNA: {0} - Módulo Origen:{1}"
                    + " Módulo destino:{2} Tipo tasa:{3} Dias:{4} Valor esperado:{5}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            { BigDecimal.valueOf(4.00), 30, 365, "te", 
                    30, BigDecimal.valueOf(64.3236216205492300) },
            { BigDecimal.valueOf(57.93650793650803), 365, 30, "tna", 
                    30, BigDecimal.valueOf(4.76190476190477) },
            { BigDecimal.valueOf(57.9365079365080350), 365, 365, "tnv", 
                    30, BigDecimal.valueOf(60.8333333333333333) }
        });
    }
    
    @Test
    public void givenTasaNominalAdelantada_whenConversion_thenTasaEsperada() {
        
        
        TasaNominalAdelantada tasaNominalAdelantada =
                    new TasaNominalAdelantada(tna,moduloOrigen,dias);
        
        BigDecimal resultado;
                
         
        switch (tipoTasa) {
            case "tnv":
                resultado = tasaNominalAdelantada
                            .convertiraTasaNominalVencida(moduloDestino, dias).getValor();
                break;
            case "tna":
                resultado = tasaNominalAdelantada
                            .convertiraTasaNominalAdelantada(moduloDestino, dias).getValor();
                break;

            case "te":
                resultado = tasaNominalAdelantada
                            .convertiraTasaEfectiva(moduloDestino).getValor();
                break;
            default:
                resultado = null;
                break;
        }
        
       
                
        assertEquals(valorEsperado.longValue(), resultado.longValue());
        
    }
    
    
}
