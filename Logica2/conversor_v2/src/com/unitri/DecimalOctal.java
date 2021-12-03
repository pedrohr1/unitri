package com.unitri;

public class DecimalOctal {
    public String conversorDecimalOctal (int valorDecimal) {
        int i = 1;
        int resultado = 0;
        while (valorDecimal != 0) {
            resultado += (valorDecimal % 8) * i;
            valorDecimal /= 8;
            i *= 10;
        }
        return Integer.toString(resultado);
    }
}
