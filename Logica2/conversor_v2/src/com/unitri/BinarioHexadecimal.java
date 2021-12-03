package com.unitri;

public class BinarioHexadecimal {
    public String convesorBinarioHexadecimal (String valorBinario) {
        BinarioDecimal binarioDecimal = new BinarioDecimal();
        DecimalHexadecimal decimalHexadecimal = new DecimalHexadecimal();
        int valorDecimal = Integer.parseInt(binarioDecimal.conversorBinarioDecimal(valorBinario));
        return decimalHexadecimal.conversorDecimalHexadecimal(valorDecimal);
    }
}