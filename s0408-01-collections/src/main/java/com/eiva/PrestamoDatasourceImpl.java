package com.eiva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eiva.PrestamoCuota.Periodo.MesEnum;

public class PrestamoDatasourceImpl implements PrestamoDatasource {

    private Map<Long, List<PrestamoCuota>> prestamos;
    

    @Override
    public List<PrestamoCuota> buscarPrestamo(Long prestamoId) {

        return prestamos.get(prestamoId);
    }


    
    public PrestamoDatasourceImpl() {
        prestamos= new HashMap<>();
        
        List<PrestamoCuota> cuotas = new ArrayList<PrestamoCuota>();
        
        cuotas.add( new PrestamoCuota(1L,
                new PrestamoCuota.Periodo(MesEnum.ABRIL, 2019),
                LocalDate.of(2019, 4, 20),
                BigDecimal.valueOf(1000L) ,
                BigDecimal.valueOf(200L) 
                ));
        
        cuotas.add( new PrestamoCuota(2L,
                new PrestamoCuota.Periodo(MesEnum.MAYO, 2019),
                LocalDate.of(2019, 5, 20),
                BigDecimal.valueOf(1000L) ,
                BigDecimal.valueOf(200L) 
                ));
        
        cuotas.add( new PrestamoCuota(3L,
                new PrestamoCuota.Periodo(MesEnum.JUNIO, 2019),
                LocalDate.of(2019, 6, 20),
                BigDecimal.valueOf(1000L) ,
                BigDecimal.valueOf(200L) 
                ));
        
        prestamos.put(1L, cuotas);
        
    }

   

}
