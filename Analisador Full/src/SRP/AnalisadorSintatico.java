package SRP;

import Lexico.Listas.Operadores;
import Lexico.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalisadorSintatico {

    private List<Token> tokens;
    private Token token;
    private int pToken;
    private List<String> erros = new ArrayList<String>();

    public AnalisadorSintatico(List<Token> tokens) {

        if (tokens == null) {

            throw new RuntimeException("Erro código L21: Lista de tokens vazia!");
        }

        this.tokens = tokens;
    }

    public void analisar() {

        pToken = 0;

        nextToken();
        programa();

        if (!token.getClasse().equals("$")) {

            addErro("Erro código L36: Esperado '$', recebido: ", token);
        }
    }

    // <decl> ::= <listaid> ':' <tipo>
    private void decl() {

        tipo();
        listaid();
    }

    private void listaid() {

        if (token.getClasse().equals("ID")) {

            nextToken();
            listaid2();
        } else {

            addErro("Erro código L55: Esperado 'ID', recebido: ", token);
        }
    }

    // <listaid2> ::= ',' id <listaid2> |
    private void listaid2() {

        if (token.getClasse().equals("ID")) {

            nextToken();
            listaid2();
        }
    }

    //<programa> ::= <comando> <programa> | <funcao> <programa> |
    private void programa() {

        if (token.getImagem().equals("(")) {        //validacao de first

            if (lookAhead(1).getImagem().equals("fun")) {

                funcao();
                programa();
            } else {

                comando();
                programa();
            }
        }
    }

    //<funcao> ::= '(' <funcao-interna> ')'
    public void funcao() {

        if (token.getImagem().equals("(")) {

            nextToken();
            funcaoInterna();

            if (token.getImagem().equals(")")) {

                nextToken();
            } else {

                addErro("Erro código L99: Esperado ')', recebido: ", token);
            }
        } else {

            addErro("Erro código L103: Esperado '(', recebido: ", token);
        }
    }

    //<funcao-interna> ::= 'fun' id <params> ':' <tipo> <comandos>
    public void funcaoInterna() {

        if (token.getImagem().equals("fun")) {

            nextToken();

            if (token.getClasse().equals("ID")) {

                nextToken();
                params();

                if (token.getImagem().equals(":")) {

                    nextToken();
                    tipo();
                    comandos();
                } else {

                    addErro("Erro código L126: Esperado ':', recebido: ", token);
                }
            } else {

                addErro("Erro código L130: Esperado 'ID', receibdo: ", token);
            }
        } else {

            addErro("Erro código L134: Esperado 'fun', recebido", token);
        }
    }

    //<params> ::= <param> <params> |
    private void params() {

        if (token.getImagem().equals("(")) {        //if de first

            param();
            params();
        }
    }

    //<param> ::= '(' <tipo> id ')'
    private void param() {

        if (token.getImagem().equals("(")) {

            nextToken();
            tipo();

            if (token.getClasse().equals("ID")) {

                nextToken();

                if (token.getImagem().equals(")")) {

                    nextToken();
                } else {

                    addErro("Erro código L165: Esperado ')', recebido: ", token);
                }
            } else {

                addErro("Erro código L169: Esperado 'ID', recebido: ", token);
            }
        } else {

            addErro("Erro código L173: Esperado '(', recebido: ", token);
        }
    }

    //<tipo> ::= 'int' | 'real' | 'texto' | 'logico' | 'nada'
    private void tipo() {

        if (token.getImagem().equals("int")
                || token.getImagem().equals("real")
                || token.getImagem().equals("texto")
                || token.getImagem().equals("logico")
                || token.getImagem().equals("nada")) {

            nextToken();
        } else {

            addErro("Erro código L189: Esperado 'int', 'rel', 'texto', 'logico' ou 'nada', recebido: ", token);
        }
    }

    //<comandos> ::= <comando> <comandos> |
    private void comandos() {

        if (token.getImagem().equals("(")) {        //if de first

            comando();
            comandos();
        }
    }

    //<comando> ::= '(' <comando-interno> ')'
    private void comando() {

        if (token.getImagem().equals("(")) {

            nextToken();
            comandoInterno();

            if (token.getImagem().equals(")")) {        //if de first

                nextToken();
            } else {

                addErro("Erro código L216: Esperado ')', recebido: ", token);
            }
        } else {

            addErro("Erro código L220: Esperado '(', recebido: ", token);
        }
    }

    //<comando-interno> ::= <decl> | <atrib> | <invoca> | <se>
    // | <leitura> | <enquanto> | <para> | <retorno> | <mostrar>
    public void comandoInterno() {

        if (token.getImagem().equals("int")                        //first
                || token.getImagem().equals("real")
                || token.getImagem().equals("texto")
                || token.getImagem().equals("logico")
                || token.getImagem().equals("nada")) {

            decl();
        } else if (token.getImagem().equals("=")) {

            atrib();
        } else if (token.getClasse().equals("ID")) {

            invoca();
        } else if (token.getImagem().equals("se")) {

            se();
        } else if (token.getImagem().equals("le")) {

            leitura();
        } else if (token.getImagem().equals("enquanto")) {

            enquanto();
        } else if (token.getImagem().equals("para")) {

            para();
        } else if (token.getImagem().equals("ret")) {

            retorno();
        } else if (token.getImagem().equals("mostra")) {

            mostrar();
        } else {

            addErro("Erro código L261: Esperado 'int', 'rel', 'texto', 'logico', 'nada', '=', 'ID', 'se', 'le', 'enquanto', 'para', 'ret' ou 'mostra', recebido: ", token);
        }
    }

    //<mostrar> ::= 'mostra' <expr>
    private void mostrar() {

        if (token.getImagem().equals("mostra")) {

            nextToken();
            expr();
        } else {

            addErro("Erro código L274: Esperado 'mostra', recebido: ", token);
        }
    }

    //<retorno> ::= 'ret' <expr>
    private void retorno() {

        if (token.getImagem().equals("ret")) {

            nextToken();
            expr();
        } else {

            addErro("Erro código L287: Esperado 'ret', recebido: ", token);
        }
    }

    //<para> ::= 'para' <atrib> <expr> <atrib> <comandos>
    private void para() {

        if (token.getImagem().equals("para")) {

            nextToken();
            atrib();
            expr();
            atrib();
            comandos();
        } else {

            addErro("Erro código L303: Esperado 'para', recebido: ", token);
        }
    }

    //<enquanto> ::= 'enquanto' <expr> <comandos>
    private void enquanto() {

        if (token.getImagem().equals("enquanto")) {

            nextToken();
            expr();
            comandos();
        } else {

            addErro("Erro código L317: Esperado 'enquanto', recebido: ", token);
        }
    }

    //<leitura> ::= 'le' id
    private void leitura() {

        if (token.getImagem().equals("le")) {

            nextToken();
            if (token.getClasse().equals("ID")) {

                nextToken();
            } else {

                addErro("Erro código L332: Esperado 'ID', recebido: ", token);
            }
        } else {
            addErro("Erro código  L335: Esperando 'le', recebido: ", token);
        }
    }

    //<se> ::= 'se' <expr> '(' <comandos> ')' <senao>
    private void se() {

        if (token.getImagem().equals("se")) {

            nextToken();
            expr();

            if (token.getImagem().equals("(")) {

                comandos();

                if (token.getImagem().equals(")")) {

                    senao();
                } else {

                    addErro("Erro código L356: Esperado ')', recebido: ", token);
                }
            }
        } else {

            addErro("Erro código L361: Esperado 'se', recebido: ", token);
        }
    }

    //<senao> ::= '(' <comandos> ')' |
    private void senao() {

        if (token.getImagem().equals("(")) {

            nextToken();
            comandos();

            if (token.getImagem().equals(")")) {

                nextToken();
            } else {

                addErro("Erro código L378: Esperado ')', recebido: ", token);
            }
        }
    }

    //<atrib> ::= '=' id <expr>
    private void atrib() {

        if (token.getImagem().equals("=")) {

            nextToken();

            if (token.getClasse() == "ID") {

                nextToken();
                expr();
            } else {

                addErro("Erro código L396: Esperado 'ID', recebido: ", token);
            }
        } else {

            addErro("Erro código L400: Esperado '=', recebido: ", token);
        }
    }

    //<expr> ::= <operan> | '(' <op2> <expr> <expr> ')' | '(' <op1> id ')' | '(' <invoca> ')'
    private void expr() {
        if (token.getClasse().equals("ID") ||
                token.getClasse().equals("CLI") ||
                token.getClasse().equals("CLR") ||
                token.getClasse().equals("CLL") ||
                token.getClasse().equals("CLS")) {

            operan();
        } else if (token.getImagem().equals("(")) {

            if (Operadores.Operadores.contains(lookAhead(1).getImagem())) {

                nextToken();
                op2();
                expr();
                expr();

                if (token.getImagem().equals(")")) {

                    nextToken();
                } else {

                    addErro("Erro código L427: Esperado ')', recebido: ", token);
                }

            } else if (lookAhead(1).getImagem().equals("++") || lookAhead(1).getImagem().equals("--")) {

                nextToken();
                op1();

                if (token.getClasse().equals("ID")) {

                    nextToken();

                    if (token.getImagem().equals(")")) {

                        nextToken();
                    } else {

                        addErro("Erro código L444: Esperado ')', recebido: ", token);
                    }
                } else {

                    addErro("Erro código L448: Esperado 'ID', recebido: ", token);
                }
            } else if (lookAhead(1).getClasse().equals("ID")) {

                if (token.getImagem().equals("(")){
                    nextToken();
                    invoca();
                    if (token.getImagem().equals(")")){
                        nextToken();
                    }else{

                        addErro("Erro código L459: Esperado ')', recebido: ", token);
                    }

                } else {

                    addErro("Erro código L464: Esperado '(', recebido: ", token);
                }

            } else {

                addErro("Erro código L469: Esperado ')', recebido: ", token);
            }
        } else {

            addErro("Erro código L473: Esperando 'ID', 'CLI', 'CLR', 'CLL', 'CLR' ou '(', recebido: ", token);
        }
    }

    //<invoca> ::= id <args>
    private void invoca() {

        if (token.getClasse().equals("ID")) {

            nextToken();
            args();
        } else {

            addErro("Erro código L486: Esperando 'ID', recebido: ", token);
        }
    }

    //<args> ::= <expr> <args> |
    private void args() {

        if (token.getClasse().equals("ID") ||
                token.getClasse().equals("CLI") ||
                token.getClasse().equals("CLR") ||
                token.getClasse().equals("CLL") ||
                token.getClasse().equals("CLS") ||
                token.getImagem().equals("(")) {

            expr();
            args();
        }
    }

    //<op1> ::= '++' | '--'
    private void op1() {

        if (token.getImagem().equals("'++' || '--'")) {

            nextToken();
        } else {

            addErro("Erro código L513: Esperando '++' ou '--', recebido: ", token);
        }
    }

    //<op2> ::= '&&' | '||' | '>' | '>=' | '<' | '<=' | '==' | '!=' | '.' | '+' | '-' | '*' | '/'
    private void op2() {

        if (token.getImagem().equals("&&") || token.getImagem().equals("||") || token.getImagem().equals(">") ||
                token.getImagem().equals(">=") || token.getImagem().equals("<") || token.getImagem().equals("<=") ||
                token.getImagem().equals("==") || token.getImagem().equals("!=") || token.getImagem().equals(".") ||
                token.getImagem().equals("+") || token.getImagem().equals("-") || token.getImagem().equals("*") ||
                token.getImagem().equals("/")) {

            nextToken();
        } else {

            addErro("Erro código L529: Esperando '&&', '||', '>', '>=', '<', '<=', '==', '!=', '.', '+', '-', '*' ou '/', recebido: ", token);
        }
    }

    //<operan> ::= id | cli | clr | cll | cls
    private void operan() {

        if (token.getClasse().equals("ID") ||
                token.getClasse().equals("CLI") ||
                token.getClasse().equals("CLR") ||
                token.getClasse().equals("CLL") ||
                token.getClasse().equals("CLS")) {

            nextToken();
        } else {

            addErro("Erro código L545: Esperando 'ID', 'CLI', 'CLR', 'CLL' ou 'CLR', recebido: ", token);
        }
    }

    public boolean temErros() {

        return !erros.isEmpty();
    }

    public void mostraErros() {

        for (String erro : erros) {

            System.out.println(erro);
        }
    }

    private void nextToken() {

        token = tokens.get(pToken++);
    }

    private Token lookAhead(int quantidade) {

        return tokens.get(pToken);
    }

    private void addErro(String erro, Token tok) {

        erros.add(erro + ". " + tok.toString());
    }
}