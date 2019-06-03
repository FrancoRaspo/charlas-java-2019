package com.eiva;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PrestamoAleman extends Prestamo {

    private static final long serialVersionUID = 1L;

    public PrestamoAleman() {
        super();
    }

    public PrestamoAleman(BigDecimal capital, Integer nroCuotas, BigDecimal tasa, LocalDate fecha) {
        super(capital, nroCuotas, tasa, fecha);
    }

    @Override
    public void calcularCuotas() {

        if (super.getCapital() == null) {
            throw new RuntimeException("Debe ingresar un valor para el capital");

        }

        if (super.getNroCuotas() == null || super.getNroCuotas() == 0) {
            throw new RuntimeException("Debe ingresar un valor de nro. de cuotas");

        }

        if (super.getTasa() == null) {
            throw new RuntimeException("Debe ingresar un valor para la tasa");

        }

        if (super.getFecha() == null) {
            throw new RuntimeException("Debe ingresar una fecha");

        }

        BigDecimal razon;
        BigDecimal valorCuota;

        if (super.getTasa().compareTo(BigDecimal.ZERO) == 0) {
            razon = BigDecimal.ZERO;
            valorCuota = super.getCapital().divide(BigDecimal.valueOf(super.getNroCuotas()), 9, BigDecimal.ROUND_UP);
        } else {
            razon = super.getTasa().multiply(BigDecimal.valueOf(Prestamo.PERIODO)).divide(
                    BigDecimal.valueOf(Prestamo.MODULO).multiply(BigDecimal.valueOf(100L)), 9,
                    BigDecimal.ROUND_HALF_UP);
            valorCuota = super.getCapital().multiply(razon)
                    .multiply(razon.add(BigDecimal.ONE).pow(super.getNroCuotas()))
                    .divide(razon.add(BigDecimal.ONE).pow(super.getNroCuotas()).subtract(BigDecimal.ONE), 9,
                            BigDecimal.ROUND_UP)
                    .setScale(2, BigDecimal.ROUND_UP);
        }

        BigDecimal capitalCuota = super.getCapital().divide(BigDecimal.valueOf(super.getNroCuotas()),  BigDecimal.ROUND_UP);
        BigDecimal interesCuota = valorCuota.subtract(capitalCuota);
        
        for (Integer nroCuota = 1; nroCuota <= super.getNroCuotas(); nroCuota++) {
            
            
            LocalDate vencimiento = super.getFecha().plusMonths(nroCuota);

            PrestamoCuota cuota = new PrestamoCuota(nroCuota, vencimiento, capitalCuota, interesCuota);

            super.addCuota(cuota);


        }
    }
}