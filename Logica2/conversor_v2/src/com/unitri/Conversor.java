package com.unitri;

public class Conversor {
    public String Conversor (String valorEntrada, int tipoEntrada, int tipoSaida) {
        if (tipoEntrada == 1) {
            int intValorEntrada = Integer.parseInt(valorEntrada);
            switch (tipoSaida) {
                case 2:
                    //Decimal para binario
                    DecimalBinario decimalBinario = new DecimalBinario();
                    return decimalBinario.conversorDecimalBinario(intValorEntrada);
                case 3:
                    //Decimal para octal
                    //Conversão de base 10 para base 8
                    DecimalOctal decimalOctal = new DecimalOctal();
                    return decimalOctal.conversorDecimalOctal(intValorEntrada);
                case 4:
                    //Decimal para hexadecimal
                    DecimalHexadecimal decimalHexadecimal = new DecimalHexadecimal();
                    return decimalHexadecimal.conversorDecimalHexadecimal(intValorEntrada);
            }
        }
        else if (tipoEntrada == 2) {
            switch (tipoSaida) {
                case 1:
                    //Binaro para decimal
                    BinarioDecimal binarioDecimal = new BinarioDecimal();
                    return binarioDecimal.conversorBinarioDecimal(valorEntrada);
                case 3:
                    //Binario para octal
                    BinarioOctal binarioOctal = new BinarioOctal();
                    return binarioOctal.convesorBinarioOctal(valorEntrada);
                case 4:
                    //Binaro para hexadecimal
                    BinarioHexadecimal binarioHexadecimal = new BinarioHexadecimal();
                    return binarioHexadecimal.convesorBinarioHexadecimal(valorEntrada);
            }
        }
        else if (tipoEntrada == 3) {
            int intValorEntrada = Integer.parseInt(valorEntrada);
            switch (tipoSaida) {
                case 1:
                    //Octal para decimal
                    OctalDecimal octalDecimal = new OctalDecimal();
                    return octalDecimal.conversorOctalDecimal(intValorEntrada);
                case 2:
                    //Octal para binario
                    OctalBinario octalBinario = new OctalBinario();
                    return octalBinario.conversorOctalBinario(intValorEntrada);
                case 4:
                    //Octal para hexadecimal
                    OctalHexadecimal octalHexadecimal = new OctalHexadecimal();
                    return octalHexadecimal.conversorOctalHexadecimal(intValorEntrada);
            }
        }
        else if (tipoEntrada == 4) {
            switch (tipoSaida) {
                case 1:
                    //Hexadecimal para decimal
                    HexadecimalDecimal hexadecimalDecimal = new HexadecimalDecimal();
                    return hexadecimalDecimal.conversorHexadecimalDecimal(valorEntrada);
                case 2:
                    //Hexadecimal para binario
                    HexadecimalBinario hexadecimalBinario = new HexadecimalBinario();
                    return hexadecimalBinario.conversorHexadecimalBinario(valorEntrada);
                case 3:
                    //Hexadecimal para octal
                    HexadecimalOctal hexadecimalOctal = new HexadecimalOctal();
                    return hexadecimalOctal.conversorHexadecimalOctal(valorEntrada);
            }
        }
        else {
            return "Opcao invalida!!";
        }
        return "Proximo calculo!";
    }
}