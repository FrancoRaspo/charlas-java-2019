package com.eiv.conversortasas;

public enum TipoTasaEnum {
    TE("Tasa Efectiva",1),
    TNV("Tasa Nominal Vencida",2),
    TNA("Tasa Nominal Adelantada",3);

    private String tipoTasa;
    private Integer codigo;
    
    private TipoTasaEnum() {}
    
    private TipoTasaEnum(String tipoTasa, Integer codigo) {
        this.tipoTasa = tipoTasa;
        this.codigo = codigo;
    }

    public String getTipoTasa() {
        return tipoTasa;
    }

    public void setTipoTasa(String tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    } 
    
    
}
