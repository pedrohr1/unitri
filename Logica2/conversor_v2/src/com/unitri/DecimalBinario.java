package com.unitri;

public class DecimalBinario {
    public String conversorDecimalBinario (int valorDecimal) {
        int i = 1;
        int resultado = 0;
        while (valorDecimal != 0) {
            resultado += (valorDecimal % 2) * i;
            valorDecimal /= 2;
            i *= 10;
        }
        return Integer.toString(resultado);
    }
}
