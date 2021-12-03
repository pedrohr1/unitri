package com.unitri;

public class HexadecimalDecimal {
    public String conversorHexadecimalDecimal (String valorHexa) {
        String vals = "0123456789ABCDEF";
        valorHexa = valorHexa.toUpperCase();
        int valorDecimal = 0;
        for (int i = 0; i < valorHexa.length(); i++) {
            char c = valorHexa.charAt(i);
            int vls = vals.indexOf(c);
            valorDecimal = 16 * valorDecimal + vls;
        }
        return Integer.toString(valorDecimal);
    }
}
