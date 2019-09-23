package com.eiv.conversortasas;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.apache.commons.math3.analysis.function.Power;
import org.springframework.stereotype.Component;

@Component
public class TasaNominalAdelantada extends Tasa {

    @Override
    public Tasa convertiraTasaEfectiva(Integer moduloDestino) {

        BigDecimal tasa = super.getValor();
        BigDecimal modDestino = new BigDecimal(moduloDestino);
        BigDecimal moduloOrigen = new BigDecimal(super.getModulo());
        BigDecimal dias = new BigDecimal(super.getDias());
        
        BigDecimal exponente = 
                modDestino.divide(dias,20, RoundingMode.HALF_UP)
                .multiply(BigDecimal.ONE.multiply(Tasa.MENOSUNO));
        
        BigDecimal base = 
                BigDecimal.ONE.subtract(
                tasa.multiply(dias)
                .divide(Tasa.CIEN.multiply(moduloOrigen),
                20, RoundingMode.HALF_UP));
                
        Power p = new Power(exponente.doubleValue());
    
        return new TasaEfectiva(BigDecimal.valueOf(p.value(base.doubleValue()))
               .subtract(BigDecimal.ONE).multiply(Tasa.CIEN), moduloDestino);
    }

    @Override
    public Tasa convertiraTasaNominalAdelantada(Integer moduloDestino, Integer dias) {

        BigDecimal tasa = super.getValor();
        BigDecimal modDestino = new BigDecimal(moduloDestino);
        BigDecimal moduloOrigen = new BigDecimal(super.getModulo());
        
        MathContext mc = new MathContext(Tasa.ESCALA_ROUND);
        
        return new TasaNominalAdelantada(
                tasa.divide(moduloOrigen, 
                        Tasa.ESCALA_ROUND, RoundingMode.HALF_UP)
                .multiply(modDestino,mc),
                moduloDestino, dias);
    }

    public TasaNominalAdelantada() {
        super();
    }

    public TasaNominalAdelantada(BigDecimal valor, Integer modulo, Integer dias) {
        super(valor, modulo, dias);
    }

    @Override
    public Tasa convertiraTasaNominalVencida(Integer moduloDestino, Integer dias) {
        TasaEfectiva te = 
                new TasaEfectiva(
                        this.convertiraTasaEfectiva(super.getModulo()).getValor(),
                        super.getModulo()); 
        
        return new TasaNominalVencida(
                te.convertiraTasaNominalVencida(super.getModulo(), dias).getValor(),
                 moduloDestino, dias);
    }

  

  
  
}
