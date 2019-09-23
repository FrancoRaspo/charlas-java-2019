package com.eiv.conversortasas;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.stereotype.Component;


@Component 
public abstract class Tasa {
    private BigDecimal valor = null;
    private Integer modulo = null;
    private Integer dias = null;
    static final Integer ESCALA_ROUND = 20;
    
    public static final BigDecimal CIEN = BigDecimal.valueOf(100L);
    public static final BigDecimal MENOSUNO = BigDecimal.valueOf(-1L);
    
    public Tasa() {}
    
    public Tasa(BigDecimal valor, Integer modulo, Integer dias) {
        super();
        this.valor = valor;
        this.modulo = modulo;
        this.dias = dias;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getModulo() {
        return modulo;
    }

    public void setModulo(Integer modulo) {
        this.modulo = modulo;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }
    
    public abstract Tasa convertiraTasaEfectiva(Integer moduloDestino);
    
    public abstract Tasa convertiraTasaNominalVencida(Integer moduloDestino, Integer dias);
    
    public abstract Tasa convertiraTasaNominalAdelantada(Integer moduloDestino, Integer dias);

        
    public BigDecimal getValorRedondeado(Integer redondeo) {
        
        MathContext mc = new MathContext(redondeo);
        return this.valor.round(mc);
    }
 
    
    
    
}
