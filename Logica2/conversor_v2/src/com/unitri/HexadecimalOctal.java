package com.unitri;

public class HexadecimalOctal {
    public String conversorHexadecimalOctal (String valorHexa) {
        HexadecimalDecimal hexadecimalDecimal = new HexadecimalDecimal();
        DecimalOctal decimalOctal = new DecimalOctal();
        int valorDecimal = Integer.parseInt(hexadecimalDecimal.conversorHexadecimalDecimal(valorHexa));
        return decimalOctal.conversorDecimalOctal(valorDecimal);
    }
}
