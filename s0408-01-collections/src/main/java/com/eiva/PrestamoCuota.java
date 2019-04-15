package com.eiva;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrestamoCuota {
    private Long id;
    private Periodo periodo;
    private LocalDate vencimiento;
    private BigDecimal capital;
    private BigDecimal interes;
    private BigDecimal monto;

    public PrestamoCuota() {}
    
 

    public PrestamoCuota(Long id, Periodo periodo, LocalDate vencimiento, 
            BigDecimal capital, BigDecimal interes, BigDecimal monto  ) {
        super();

        this.id = id;
        this.periodo = periodo;
        this.vencimiento = vencimiento;
        this.capital = capital;
        this.interes = interes;
        this.monto = monto;
    }

    public PrestamoCuota(Long id, Periodo periodo, LocalDate vencimiento, 
            BigDecimal capital, BigDecimal interes ) {
        this(id, periodo, vencimiento, capital, interes, capital.add(interes));
    }
    
    public static class Periodo {

        public static enum MesEnum {
            ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, 
            NOVIEMBRE, DICIEMBRE
        }

        private MesEnum mes;
        private Integer anio;

        public Periodo() {
        }
       /* public Periodo(LocalDate vencimiento) {

            switch (vencimiento.getMonth()) {
            case JANUARY:
                mes=MesEnum.ENERO;
                break;
            case FEBRUARY:
                mes=MesEnum.FEBRERO;
                break;
            case MARCH:
                mes=MesEnum.MARZO;
                break;    
            case APRIL:
                mes=MesEnum.ABRIL;
                break;    
                
            case MAY:
                mes=MesEnum.MAYO;
                break;    
            default:
                mes=
                break;
            }s
             
            this.m
                
        }*/
        
        public static Periodo of(Integer anio, MesEnum mes)
        {
            return new Periodo(mes, anio);
            
        }
        
        public Periodo(MesEnum mes, Integer anio) {
            super();
            this.mes = mes;
            this.anio = anio;
        }

        public MesEnum getMes() {
            return mes;
        }

        public void setMes(MesEnum mes) {
            this.mes = mes;
        }

        public Integer getAnio() {
            return anio;
        }

        public void setAnio(Integer anio) {
            this.anio = anio;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((anio == null) ? 0 : anio.hashCode());
            result = prime * result + ((mes == null) ? 0 : mes.hashCode());
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
            Periodo other = (Periodo) obj;
            if (anio == null) {
                if (other.anio != null)
                    return false;
            } else if (!anio.equals(other.anio))
                return false;
            if (mes != other.mes)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return mes + "/" + anio;
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
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

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PrestamoCuota [id=" + id + ", periodo=" + periodo + ", monto=" + monto + "]";
    }

       
    
}
