package com.unitri;

public class HexadecimalBinario {
    public String conversorHexadecimalBinario (String valorHexa) {
        HexadecimalDecimal hexadecimalDecimal = new HexadecimalDecimal();
        DecimalBinario decimalBinario = new DecimalBinario();
        int valorDecimal = Integer.parseInt(hexadecimalDecimal.conversorHexadecimalDecimal(valorHexa));
        return decimalBinario.conversorDecimalBinario(valorDecimal);
    }
}
