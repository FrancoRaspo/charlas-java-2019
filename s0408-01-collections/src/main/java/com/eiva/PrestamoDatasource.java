package com.eiva;

import java.util.List;

public interface PrestamoDatasource {
    

    public List<PrestamoCuota> buscarPrestamo(Long prestamoId);
}