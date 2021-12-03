package com.unitri;

public class OctalBinario {
    public String conversorOctalBinario (int valorOctal) {
        OctalDecimal octalDecimal = new OctalDecimal();
        DecimalBinario decimalBinario = new DecimalBinario();
        int valorDecimal = Integer.parseInt(octalDecimal.conversorOctalDecimal(valorOctal));
        return decimalBinario.conversorDecimalBinario(valorDecimal);
    }
}
