package com.unitri;

public class OctalDecimal {
    public String conversorOctalDecimal (int valorOctal) {
        int resultado = 0;
        int numeroValido = 1;
        int i = 0;
        int aux = valorOctal;
        while (aux != 0 && numeroValido == 1) {
            if (aux % 10 < 0 || aux % 10 > 7) {
                numeroValido = 0;
            } else {
                numeroValido = 1;
            }
            aux /= 10;
        }
        if (numeroValido == 1) {
            while (valorOctal != 0) {
                resultado += (valorOctal % 10) * (int) Math.pow(8, i++);
                valorOctal /= 10;
            }
        }
        return Integer.toString(resultado);
    }
}