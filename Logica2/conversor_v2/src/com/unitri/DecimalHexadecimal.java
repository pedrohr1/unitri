package com.unitri;

public class DecimalHexadecimal {
    public String conversorDecimalHexadecimal (int valorDecimal) {
        String resultado = "";
        String digitos = "0123456789ABCDEF";
        if (valorDecimal <= 0) {
            return "0";
        } else if (valorDecimal > 0 && valorDecimal <= 9) {
            return Integer.toString(valorDecimal);
        }
        else {
            while (valorDecimal > 0) {
                int digito = valorDecimal % 16;
                resultado = digitos.charAt(digito) + resultado;
                System.out.println(digitos.charAt(digito));
                valorDecimal /= 16;
            }
            return resultado;
        }
    }
}
