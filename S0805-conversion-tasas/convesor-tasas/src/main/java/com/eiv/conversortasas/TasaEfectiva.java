package com.eiv.conversortasas;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.apache.commons.math3.analysis.function.Power;
import org.springframework.stereotype.Component;

@Component 
public class TasaEfectiva extends Tasa {

    @Override
    public Tasa convertiraTasaEfectiva(Integer moduloDestino) {

        BigDecimal tasa = getValor();
        BigDecimal modDestino = new BigDecimal(moduloDestino);
        BigDecimal moduloOrigen = new BigDecimal(super.getModulo());
        
        BigDecimal exponente = 
                modDestino.divide(moduloOrigen,
                        Tasa.ESCALA_ROUND, RoundingMode.HALF_UP);
                
        
        BigDecimal base = 
                BigDecimal.ONE.add(
                tasa.multiply(moduloOrigen)
                .divide(Tasa.CIEN.multiply(moduloOrigen),
                20, RoundingMode.HALF_UP));
                
        Power p = new Power(exponente.doubleValue());
    
        return new TasaEfectiva(BigDecimal.valueOf(p.value(base.doubleValue()))
               .subtract(BigDecimal.ONE).multiply(Tasa.CIEN), moduloDestino);
    }

    @Override
    public Tasa convertiraTasaNominalVencida(Integer moduloDestino, Integer dias) {


        BigDecimal tasa = super.getValor();
        BigDecimal modDestino = new BigDecimal(moduloDestino);
        BigDecimal moduloOrigen = new BigDecimal(super.getModulo());
        BigDecimal calcdias = new BigDecimal(dias);
        
        BigDecimal exponente = 
                calcdias.divide(moduloOrigen,20, RoundingMode.HALF_UP);
                
        
        BigDecimal base = 
                tasa
                .divide(Tasa.CIEN)
                .add(BigDecimal.ONE);
                
        Power p = new Power(exponente.doubleValue());
    

        MathContext mc = new MathContext(Tasa.ESCALA_ROUND);
       
        
        return new TasaNominalVencida(BigDecimal.valueOf(p.value(base.doubleValue()))
               .subtract(BigDecimal.ONE).multiply(modDestino.multiply(Tasa.CIEN)
               .divide(calcdias,20, RoundingMode.HALF_UP),mc), 
               moduloDestino, dias);
    }

    public TasaEfectiva() {
        super();
    }

    public TasaEfectiva(BigDecimal valor, Integer modulo) {
        super(valor, modulo, 0);
    }

    @Override
    public Tasa convertiraTasaNominalAdelantada(Integer moduloDestino, Integer dias) {
        BigDecimal tasa = super.getValor();
        BigDecimal modDestino = new BigDecimal(moduloDestino);
        BigDecimal moduloOrigen = new BigDecimal(super.getModulo());
        BigDecimal calcdias = new BigDecimal(dias);
        
        BigDecimal exponente = 
                calcdias.divide(moduloOrigen,20, RoundingMode.HALF_UP)
                .multiply(Tasa.MENOSUNO);
                
        
        BigDecimal base = 
                tasa.divide(Tasa.CIEN,20, RoundingMode.HALF_UP)
                .add(BigDecimal.ONE);
                
        MathContext mc = new MathContext(Tasa.ESCALA_ROUND);
                
        Power p = new Power(exponente.doubleValue());
        
        
        
        return new TasaNominalAdelantada(BigDecimal.ONE.subtract(
                BigDecimal.valueOf(p.value(base.doubleValue())))
               .multiply(modDestino.multiply(Tasa.CIEN)
               .divide(calcdias,20, RoundingMode.HALF_UP), mc),
               moduloDestino, dias);
               
    }

  
  
}
