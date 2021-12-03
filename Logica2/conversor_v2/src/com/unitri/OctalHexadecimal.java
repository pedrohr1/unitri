package com.unitri;

public class OctalHexadecimal {
    public String conversorOctalHexadecimal (int valorOctal) {
        OctalDecimal octalDecimal = new OctalDecimal();
        DecimalHexadecimal decimalHexadecimal = new DecimalHexadecimal();
        int valorDecimal = Integer.parseInt(octalDecimal.conversorOctalDecimal(valorOctal));
        return decimalHexadecimal.conversorDecimalHexadecimal(valorDecimal);
    }
}
