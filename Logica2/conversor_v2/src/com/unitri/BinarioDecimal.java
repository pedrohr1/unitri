package com.unitri;

public class BinarioDecimal {
    public String conversorBinarioDecimal (String valorBinario) {
        int[] arrBinario = new int [100];
        int idx = 0;
        int resultado = 0;
        String resultadoString = "";
        int expoente = 0;
        int tamanhoArray = 0;
        int valbin = Integer.parseInt(valorBinario);
        int numeroValido = 1;
        int aux = Integer.parseInt(valorBinario);
        while (aux != 0 && numeroValido ==1) {
            if ((aux % 10) != 0 && (aux % 10) != 1) {
                numeroValido = 0;
            } else {
                numeroValido = 1;
            }
            aux /= 10;
        }
        if (numeroValido != 1) {
            return "O numero inserido nao esta na base 2";
        }
        while (valbin != 0) {
            int valTmp = valbin % 10;
            resultado += valTmp * Math.pow(2, idx);
            valbin /= 10;
            idx ++;
            resultadoString = Integer.toString(resultado);
        }
        return resultadoString;
    }
}