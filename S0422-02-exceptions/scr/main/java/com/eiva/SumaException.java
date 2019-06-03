package com.eiva;

public class SumaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public static int A_MAYOR_B = 1;
    public static int A_MAS_B_MAYOR_10 = 2;

    private int codigo;

    public SumaException() {
        super();
    }

    public SumaException(int codigo, String message) {
        super(message);
        this.codigo = codigo;

    }

    public int getCodigo() {
        return codigo;
    }

}
