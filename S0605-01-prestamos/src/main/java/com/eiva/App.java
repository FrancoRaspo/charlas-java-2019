package com.eiva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {
    private static final Logger LOG = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        App app = new App();
        LOG.info("Incializando prestamos...");
        app.run();

    }
 

    private class PrestamosDatos {
        private BigDecimal capital = null;
        private Integer nroCuotas = null;
        private BigDecimal tasa = null;
        private LocalDate fecha = null;
       
        public PrestamosDatos(BigDecimal capital, Integer nroCuotas, BigDecimal tasa, LocalDate fecha) {
            super();
            this.capital = capital;
            this.nroCuotas = nroCuotas;
            this.tasa = tasa;
            this.fecha = fecha;
        }

        public BigDecimal getCapital() {
            return capital;
        }

        public Integer getNroCuotas() {
            return nroCuotas;
        }

        public BigDecimal getTasa() {
            return tasa;
        }

        public LocalDate getFecha() {
            return fecha;
        }

    }

    public Optional<PrestamosDatos> tomarDatosPrestamo() {

        BigDecimal capital = null;
        Integer nroCuotas = null;
        BigDecimal tasa = null;
        LocalDate fecha = null;
        String inFecha= null;

        try (Scanner scanner = new Scanner(System.in)) {

            try {   
                System.out.println("Ingrese monto de capital:");
                capital = scanner.nextBigDecimal();
            } catch (Exception e) {
                LOG.error("Ingrese un valor correcto para capital->"+capital);
                throw new InputMismatchException("Ingrese un valor correcto para capital");
            }

            try {
                System.out.println("Ingrese la cantidad de cuotas:");
                nroCuotas = scanner.nextInt();

            } catch (Exception e) {
                LOG.error("Ingrese un valor correcto para cantidad de cuotas->"+nroCuotas);
                throw new InputMismatchException("Ingrese un valor correcto para cantidad de cuotas");
            }

            try {
                System.out.println("Ingrese la tasa:");
                tasa = scanner.nextBigDecimal();

            } catch (Exception e) {
                LOG.error("Ingrese un valor correcto para la tasa->"+tasa);
                throw new InputMismatchException("Ingrese un valor correcto para la tasa");
            }

            try {
                
                System.out.println("Ingrese fecha (AAAA-MM-DD):");
                inFecha = scanner.next();
                fecha = LocalDate.parse(inFecha);

            } catch (Exception e) {
                LOG.error("Ingrese un valor correcto para la tasa->"+inFecha);
                throw new InputMismatchException("Ingrese un valor correcto para fecha. AAAA-MM-DD");
            }

            if (capital.compareTo(BigDecimal.ZERO) == 0) {
                LOG.error("El captial debe ser mayor a 0");
                throw new InputMismatchException("El captial debe ser mayor a 0");
            }

            if (nroCuotas != null && nroCuotas == 0) {
                LOG.error("La cantidad de cuotas debe ser mayor a 0");
                throw new InputMismatchException("La cantidad de cuotas debe ser mayor a 0");
            }

            return (Optional.of(new PrestamosDatos(capital, nroCuotas, tasa, fecha)));

        } catch (InputMismatchException e) {
            LOG.error(e.getMessage());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            LOG.error("No se pudieron cargar los datos.");
            System.out.println("No se pudieron cargar los datos.");
        }

        return (Optional.empty());

    }

    public void run() {

        Optional<PrestamosDatos> prestamosDatos = tomarDatosPrestamo();

        prestamosDatos.ifPresent((prestamoDato) -> {
            try {
                /*PrestamoFrances prestamo = new PrestamoFrances(prestamoDato.getCapital(), prestamoDato.getNroCuotas(),
                        prestamoDato.getTasa(), prestamoDato.getFecha());*/
                
                PrestamoAleman prestamo = new PrestamoAleman(prestamoDato.getCapital(), prestamoDato.getNroCuotas(),
                        prestamoDato.getTasa(), prestamoDato.getFecha());
                
                LOG.trace("Calculando cuotas");
                prestamo.calcularCuotas();

                prestamo.getCuotas().forEach((nro, cuota) -> {
                    System.out.println(cuota);
                });
            } catch (Exception e) {
                LOG.error(e.getMessage());
                System.out.println(e.getMessage());
            }
        });

    }

}
