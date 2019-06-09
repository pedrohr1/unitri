package Lexico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Lexico.Listas.*;
import com.sun.deploy.util.StringUtils;

public class AnalisadorLexico {

    private List<String> erros = new ArrayList<String>();
    private List<Token> listaDeTokens = new ArrayList<Token>();

    public void analisar(String caminhodoarquivo) {

        Token token = new Token();

        try {

            int contaLinha = 0;
            String linha;
            List<String> listaDeId = new ArrayList<String>();

            BufferedReader br = new BufferedReader(new FileReader(new File(caminhodoarquivo)));

            while ((linha = br.readLine()) != null) {

                String[] splitado = StringUtils.splitString(linha, " ");

                contaLinha++;

                for (int i = 0; i < splitado.length; i++) {

                    if (splitado[i].matches("[\"]")) {

                        String imgStr = null;

                        token.setColuna(linha.indexOf(splitado[i]));
                        token.setLinha(contaLinha);

                        i++;

                        while (!splitado[i].matches("[\"]")) {

                            if (imgStr == null) {

                                imgStr = splitado[i];
                            } else {

                                imgStr = imgStr + " " + splitado[i];
                            }

                            i++;
                        }

                        token.setImagem(imgStr);
                        token.setClasse("CLS");
                        token.setIndice(-1);

                        listaDeTokens.add(new Token(token.getImagem(), token.getClasse(), token.getLinha(), token.getColuna(), token.getIndice()));

                        token = new Token();
                    } else if (PalavraReservada.PalavrasReservadas.contains(splitado[i]) && splitado[i] != " ") {

                        token.setImagem(splitado[i]);
                        token.setClasse("PR");
                        token.setColuna(linha.indexOf(splitado[i]));
                        token.setLinha(contaLinha);
                        token.setIndice(-1);

                        listaDeTokens.add(new Token(token.getImagem(), token.getClasse(), token.getLinha(), token.getColuna(), token.getIndice()));

                        token = new Token();
                    } else if (Operadores.Operadores.contains(splitado[i]) && splitado[i] != " ") {

                        token.setImagem(splitado[i]);
                        token.setClasse("OP");
                        token.setColuna(linha.indexOf(splitado[i]));
                        token.setLinha(contaLinha);
                        token.setIndice(-1);

                        listaDeTokens.add(new Token(token.getImagem(), token.getClasse(), token.getLinha(), token.getColuna(), token.getIndice()));

                        token = new Token();
                    } else if (Delimitadores.Delimitadores.contains(splitado[i]) && splitado[i] != " ") {

                        token.setImagem(splitado[i]);
                        token.setClasse("DE");
                        token.setColuna(linha.indexOf(splitado[i]));
                        token.setLinha(contaLinha);
                        token.setIndice(-1);

                        listaDeTokens.add(new Token(token.getImagem(), token.getClasse(), token.getLinha(), token.getColuna(), token.getIndice()));

                        token = new Token();
                    } else {

                        Pattern p = Pattern.compile("[a-zA-Z][0-9]");
                        Pattern p1 = Pattern.compile("[0-9]");
                        Pattern p3 = Pattern.compile("[a-z]");
                        Pattern p4 = Pattern.compile("[A-Z]");

                        if (splitado[i] != " ") {

                            Matcher m = p.matcher(splitado[i]);
                            Matcher m1 = p1.matcher(splitado[i]);
                            Matcher m3 = p3.matcher(splitado[i]);
                            Matcher m4 = p4.matcher(splitado[i]);

                            if (m.find() || m3.find() || m4.find()) {

                                if (!listaDeId.contains(splitado[i])) {

                                    token.setImagem(splitado[i]);
                                    token.setClasse("ID");
                                    token.setColuna(linha.indexOf(splitado[i]));
                                    token.setLinha(contaLinha);
                                    token.setIndice(-1);

                                    listaDeId.add(token.getImagem());

                                    listaDeTokens.add(new Token(token.getImagem(), token.getClasse(), token.getLinha(), token.getColuna(), token.getIndice()));

                                    token = new Token();
                                } else {

                                    token.setImagem(listaDeId.get(listaDeId.indexOf(splitado[i])));
                                    token.setClasse("ID");
                                    token.setLinha(contaLinha);
                                    token.setColuna(linha.indexOf(splitado[i]));
                                    token.setIndice(listaDeId.indexOf(splitado[i]));

                                    listaDeTokens.add(new Token(token.getImagem(), token.getClasse(), token.getLinha(), token.getColuna(), token.getIndice()));
                                }
                            } else if (m1.find()) {

                                if (!listaDeId.contains(splitado[i])) {

                                    token.setImagem(splitado[i]);
                                    token.setClasse("CLI");
                                    token.setColuna(linha.indexOf(splitado[i]));
                                    token.setLinha(contaLinha);
                                    token.setIndice(-1);

                                    listaDeId.add(token.getImagem());

                                    listaDeTokens.add(new Token(token.getImagem(), token.getClasse(), token.getLinha(), token.getColuna(), token.getIndice()));

                                    token = new Token();
                                } else {
                                    token.setImagem(listaDeId.get(listaDeId.indexOf(splitado[i])));
                                    token.setClasse("CLI");
                                    token.setLinha(contaLinha);
                                    token.setColuna(linha.indexOf(splitado[i]));
                                    token.setIndice(listaDeId.indexOf(splitado[i]));

                                    listaDeTokens.add(new Token(token.getImagem(), token.getClasse(), token.getLinha(), token.getColuna(), token.getIndice()));
                                }
                            } else {

                                if (splitado[i] != " ") {

                                    erros.add(splitado[i] + " não reconhecido!");
                                }
                            }
                        }
                    }
                }
            }

            listaDeTokens.add(new Token("$", "$", -1, -1, -1));
        } catch (Exception ex) {

            ex.printStackTrace();
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

    public List<Token> getTokens() {

        return listaDeTokens;
    }
}
