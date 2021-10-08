package v1;

import java.util.ArrayList;

public class Pessoa {
    private String nome, cpf = "";
    private int idade;
    public static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void cadastrarPessoa(Pessoa p){
        pessoas.add(p);
    }

    public boolean existePessoa(String cpf){
        boolean retorno = false;
        for (Pessoa pessoa : pessoas){
            if (pessoa.getCpf().equals(cpf))
                retorno = true;
        }
        return retorno;
    }
    public String retornaNome(String cpf){
        String nome = "";
        for (Pessoa pessoa : pessoas){
            if (pessoa.cpf.equals(cpf)){
                nome = pessoa.getNome();
            }
        }
        return nome;
    }

    public Pessoa(){}

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String dadosPessoa(){
        return "Nome: " + nome + "\n CPF: " + cpf + "\n Idade: " + idade;
    }
}