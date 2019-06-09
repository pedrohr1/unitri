package Lexico.Listas;

import java.util.ArrayList;
import java.util.List;

public class Operadores {

    public static final List<String> Operadores = new ArrayList<String>();

    static {
        Operadores.add("=");
        Operadores.add("+");
        Operadores.add("-");
        Operadores.add("*");
        Operadores.add("/");
        Operadores.add("&&");
        Operadores.add("||");
        Operadores.add(".");
        Operadores.add("==");
        Operadores.add("<");
        Operadores.add(">");
        Operadores.add(">=");
        Operadores.add("<=");
        Operadores.add("!=");

    }
}
