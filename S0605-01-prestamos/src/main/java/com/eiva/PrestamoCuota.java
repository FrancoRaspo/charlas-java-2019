package com.eiva;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrestamoCuota {

    private Integer nro_cuota=null;
    private LocalDate vencimiento=null;
    private BigDecimal capital=null;
    private BigDecimal interes=null;
    
    public PrestamoCuota() {}
            
    public PrestamoCuota(Integer nro_cuota, LocalDate vencimiento, BigDecimal capital, BigDecimal interes) {
        
        this.nro_cuota = nro_cuota;
        this.vencimiento = vencimiento;
        this.capital = capital;
        this.interes = interes;
    }

    public Integer getNro_cuota() {
        return nro_cuota;
    }

    public void setNro_cuota(Integer nro_cuota) {
        this.nro_cuota = nro_cuota;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }
    public BigDecimal getTotal() {
        return capital.add( interes);
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nro_cuota == null) ? 0 : nro_cuota.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrestamoCuota other = (PrestamoCuota) obj;
        if (nro_cuota == null) {
            if (other.nro_cuota != null)
                return false;
        } else if (!nro_cuota.equals(other.nro_cuota))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PrestamoCuota [nro_cuota=" + nro_cuota + ", vencimiento=" + vencimiento + ", capital=" + capital.setScale(2,BigDecimal.ROUND_UP)
                + ", interes=" + interes.setScale(2,BigDecimal.ROUND_UP) + ", total="+ this.getTotal().setScale(2,BigDecimal.ROUND_UP) + "]";
    }
    
    
    
    
    
    
}
