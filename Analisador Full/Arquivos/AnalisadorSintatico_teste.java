package SRP;

import Lexico.Token;

import java.util.ArrayList;
import java.util.List;

public class AnalisadorSintatico {

    private List<Token> tokens;
    private Token token;
    private int pToken;
    private List<String> erros = new ArrayList<String>();

    public AnalisadorSintatico(List<Token> tokens){

        if(tokens == null){

            throw new RuntimeException("Lista de tokens inválida!");
        }

        this.tokens = tokens;
    }

    public void analisar(){

        pToken = 0;
        nextToken();
        decl();

        if(!token.getClasse().equals("$")){

            addErro("Esperado $, recebido: ", token);
        }

    }

    // <decl> ::= <listaid> ':' <tipo>
    private void decl() {

        listaid();
        if(token.getImagem().equals(":")) {

            nextToken();
            tipo();
        } else {
            addErro("Esperado ':', recebido: ", token);
        }
    }

    // <tipo: ::= <simple> | <agregado>
    private void tipo() {

        if(token.getImagem().equals("int") || token.getImagem().equals("real") ) {

            simples();
        } else if(token.getImagem().equals("mat") || token.getImagem().equals("conj")) {

            agregado();
        } else {
            addErro("Esperado 'int', 'real', 'mat' ou 'conj', recebido:", token);
        }
    }

    // <agregado> ::= 'mat' <dim> <simples> | 'conj' <simples>
    private void agregado() {
        if(token.getImagem().equals("mat")) {
            nextToken();
            dim();
            simples();
        } else if(token.getImagem().equals("conj")) {
            nextToken();
            simples();
        } else {
            addErro("Esperado 'mat' ou 'conj', recebido:", token);
        }
    }

    // <dim> ::= '[' num ']'
    private void dim(){

        if(token.getImagem().equals("[")) {

            nextToken();
            if(token.getClasse().equals("CLI")) {

                nextToken();
                if(token.getImagem().equals("]")) {

                    nextToken();
                } else {
                    addErro("Esperado ']'", token);
                }
            } else {
                addErro("Esperado CLI, recebido:", token);
            }
        } else {
            addErro("Esperado '[', recebido:", token);
        }
    }

    // <simples> ::= 'int' | 'real'
    private void simples() {
        if(token.getImagem().equals("int")) {
            nextToken();
        } else if(token.getImagem().equals("real")) {
            nextToken();
        } else {
            addErro("Esperado 'int' ou 'real', recebido:", token);
        }
    }

    // <listaid> ::= id <listaid2>
    private void listaid() {
        if(token.getClasse().equals("ID")) {
            nextToken();
            listaid2();
        } else {
            addErro("Esperado ID, recebido:", token);
        }
    }

    // <listaid2> ::= ',' id <listaid2> |
    private void listaid2() {
        if(token.getImagem().equals(",")) {
            nextToken();
            if(token.getClasse().equals("ID")) {
                nextToken();
                listaid2();
            } else {
                addErro("Esperado ID, recebido:", token);
            }
        } //else
    }

    public boolean temErros() {

        return !erros.isEmpty();
    }

    public void mostraErros() {

        for(String erro: erros) {

            System.out.println(erro);
        }
    }

    private void addErro(String erro, Token tok){

        erros.add(erro + ". "+tok.toString());
    }

    private void nextToken() {

        token = tokens.get(pToken++);
    }

}
