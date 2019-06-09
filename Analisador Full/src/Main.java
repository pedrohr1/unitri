import Lexico.AnalisadorLexico;
import SRP.AnalisadorSintatico;

public class Main {

    public static void main(String[] args){

        //Editar caminho do arquivo
        String caminhodoarquivo = "\\Analisador Full\\Arquivos\\fatorial.slp";

        AnalisadorLexico analisadorLexico = new AnalisadorLexico();
        analisadorLexico.analisar(caminhodoarquivo);

        if(analisadorLexico.temErros()){

            System.out.println("O analisador léxico encontrou os erros:");

            analisadorLexico.mostraErros();

            System.exit(0);
        }else{

            System.out.println("Analisador léxico OK!");

            AnalisadorSintatico analisadorSintatico = new AnalisadorSintatico(analisadorLexico.getTokens());

            analisadorSintatico.analisar();

            if(analisadorSintatico.temErros()){

                System.out.println("O analisador sintático recursivo preditivo encontrou os erros:");

                analisadorSintatico.mostraErros();

                System.exit(0);
            }else{

                System.out.println("Analisador sintático recursivo preditivo OK!");
            }
        }
    }
}
