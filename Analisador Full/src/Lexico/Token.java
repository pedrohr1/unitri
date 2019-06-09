package Lexico;

import java.util.Objects;

public class Token {

    private String imagem;
    private String classe;
    private int linha;
    private int coluna;
    private int indice;

    public Token(){

        super();
    }


    public Token(String imagem, String classe, int linha, int coluna, int indice){

        super();

        this.imagem = imagem;
        this.classe = classe;
        this.linha = linha;
        this.coluna = coluna;
        this.indice = indice;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return linha == token.linha &&
                coluna == token.coluna &&
                indice == token.indice &&
                imagem.equals(token.imagem) &&
                classe.equals(token.classe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imagem, classe, linha, coluna, indice);
    }

    @Override
    public String toString() {
        return "Token{" +
                "imagem='" + imagem + '\'' +
                ", classe='" + classe + '\'' +
                ", linha=" + linha +
                ", coluna=" + coluna +
                ", indice=" + indice +
                '}';
    }
}
