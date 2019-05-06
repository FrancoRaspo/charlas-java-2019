package com.eiva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Prestamo extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final long MODULO = 30L;
    public static final long PERIODO = 30L;

    private BigDecimal capital;
    private BigDecimal interes;
    private Integer nroCuotas;
    private BigDecimal tasa;
    private LocalDate fecha;
    private Map<Integer, PrestamoCuota> cuotas;

    public Prestamo() {}
 

    public Prestamo(BigDecimal capital, Integer nroCuotas, BigDecimal tasa, LocalDate fecha) {
        super();
        this.capital = capital;
        this.nroCuotas = nroCuotas;
        this.tasa = tasa;
        this.fecha = fecha;
        this.cuotas = new HashMap<>();
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

    public Integer getNroCuotas() {
        return nroCuotas;
    }

    public void setNroCuotas(Integer nroCuotas) {
        this.nroCuotas = nroCuotas;
    }

    public Map<Integer, PrestamoCuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(Map<Integer, PrestamoCuota> cuotas) {
        this.cuotas = cuotas;
    }

    public BigDecimal getTasa() {
        return tasa;
    }

    public void setTasa(BigDecimal tasa) {
        this.tasa = tasa;
    }
    
    

    public LocalDate getFecha() {
        return fecha;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void addCuota(PrestamoCuota cuota)
    {
        this.cuotas.put(cuota.getNro_cuota(), cuota);
    }
    
    public abstract void CalcularCuotas();

}
