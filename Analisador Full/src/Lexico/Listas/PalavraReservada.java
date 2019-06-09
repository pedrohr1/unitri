package Lexico.Listas;

import java.util.ArrayList;
import java.util.List;

public class PalavraReservada {

    public static final List<String> PalavrasReservadas = new ArrayList<String>();

    static {
        PalavrasReservadas.add("fun");
        PalavrasReservadas.add("int");
        PalavrasReservadas.add("real");
        PalavrasReservadas.add("texto");
        PalavrasReservadas.add("logico");
        PalavrasReservadas.add("nada");
        PalavrasReservadas.add("enquanto");
        PalavrasReservadas.add("se");
        PalavrasReservadas.add("senao");
        PalavrasReservadas.add("ret");
        PalavrasReservadas.add("mat");
    }
}
