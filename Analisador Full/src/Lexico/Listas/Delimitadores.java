package Lexico.Listas;

import java.util.ArrayList;
import java.util.List;

public class Delimitadores {

    public static final List<String> Delimitadores = new ArrayList<String>();

    static {
        Delimitadores.add("(");
        Delimitadores.add(")");
        Delimitadores.add("[");
        Delimitadores.add("]");
        Delimitadores.add(":");
        Delimitadores.add(";");
        Delimitadores.add(",");
    }
}
