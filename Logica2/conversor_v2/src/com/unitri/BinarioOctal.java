package com.unitri;


public class BinarioOctal {
    public String convesorBinarioOctal (String valorBinario) {
        BinarioDecimal binarioDecimal = new BinarioDecimal();
        DecimalOctal decimalOctal = new DecimalOctal();
        int valorDecimal = Integer.parseInt(binarioDecimal.conversorBinarioDecimal(valorBinario));
        return decimalOctal.conversorDecimalOctal(valorDecimal);
    }
}
