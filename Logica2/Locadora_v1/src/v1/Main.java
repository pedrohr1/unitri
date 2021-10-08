package v1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner opcao = new Scanner(System.in);
        Scanner opcaoString = new Scanner(System.in);
        Scanner opcaoChar = new Scanner(System.in);
        Aluguel aluguel = new Aluguel();
        Veiculo veiculo = new Veiculo();
        Pessoa pessoa;
        Carro carro;
        Moto moto;
        int menu;

        do {
            mostrarMenu();
            menu = opcao.nextInt();

            switch (menu){
                case 1:
                    System.out.println("Qual tipo de veiculo sera cadastrado?\n1- Carro simples\n2- Carro luxo\n3- Moto");
                    int tipoVeiculo = opcao.nextInt();
                    char disponivel = 's';
                    char luxo;
                    System.out.println("Qual a placa?");
                    String placa = opcaoString.nextLine();
                    System.out.println("Qual o modelo?");
                    String modelo = opcaoString.nextLine();
                    System.out.println("Qual a marca?");
                    String marca = opcaoString.nextLine();
                    if (tipoVeiculo == 1 || tipoVeiculo == 2){
                        if (tipoVeiculo == 1)
                            luxo = 'n';
                        else
                            luxo = 's';
                        carro = new Carro(placa, marca, modelo, luxo, disponivel);
                        Veiculo.cadastrarCarro(carro);
                    }
                    else {
                        moto = new Moto(placa, marca, modelo, disponivel);
                        Veiculo.cadastrarMoto(moto);
                    }
                    System.out.println("Veiculo cadastrado!\n\n");
                    Thread.sleep(1500);
                    break;

                case 2:
                    System.out.println("Selecione uma opcao:\n1- Carros simples\n2- Carros luxo\n3- Motos");
                    int tipoveiculo = opcao.nextInt();
                    String veiculoprocurado = "";
                    if (tipoveiculo == 1){
                        veiculoprocurado = "simples";
                    }
                    else if (tipoveiculo == 2) {
                        veiculoprocurado = "luxo";
                    }
                    else {
                        veiculoprocurado = "moto";
                    }
                    String retorno = aluguel.consultaVeiculosDisponiveis(veiculoprocurado);
                    System.out.println(retorno);
                    Thread.sleep(1500);
                    break;

                case 3:
                    System.out.println("Para qual tipo de veiculo sera feito o orcamento?\n1- Carros simples\n2- Carros luxo\n3- Motos");
                    int tipoveicorc = opcao.nextInt();
                    if (tipoveicorc == 1){
                        veiculoprocurado = "simples";
                    }
                    else if (tipoveicorc == 2) {
                        veiculoprocurado = "luxo";
                    }
                    else {
                        veiculoprocurado = "moto";
                    }
                    System.out.println("Quantas diarias?");
                    int qtdDiarias = opcao.nextInt();
                    System.out.println(String.format("O valor do aluguel seria de: R$%.2f",aluguel.simulaValorAluguel(qtdDiarias, veiculoprocurado)));
                    Thread.sleep(1500);
                    break;

                case 4:
                    System.out.println("Selecione uma opcao:\n1- Carros simples\n2- Carros luxo\n3- Motos");
                    int alugvei = opcao.nextInt();
                    System.out.println("Selecione um veiculo da lista:");
                    if (alugvei == 1){
                        veiculoprocurado = "simples";
                    }
                    else if (alugvei == 2) {
                        veiculoprocurado = "luxo";
                    }
                    else {
                        veiculoprocurado = "moto";
                    }
                    System.out.println(aluguel.consultaVeiculosDisponiveis(veiculoprocurado));
                    System.out.println("Informe a placa do veiculo desejado:");
                    String placaDoVeiculo = opcaoString.nextLine();
                    System.out.println("Quantas diarias?");
                    qtdDiarias = opcao.nextInt();
                    System.out.println("Qual o CPF do cliente?");
                    String cpfCliente = opcaoString.nextLine();
                    System.out.println(aluguel.alugar(veiculoprocurado, placaDoVeiculo, qtdDiarias, cpfCliente));
                    Thread.sleep(1500);
                    break;

                case 5:
                    System.out.println("Qual o nome do cliente?");
                    String nomeCliente = opcaoString.nextLine();
                    System.out.println("Qual o CPF do cliente?");
                    String cpfCLiente = opcaoString.nextLine();
                    System.out.println("Qual a idade do cliente?");
                    int idadeCliente = opcao.nextInt();
                    pessoa = new Pessoa(nomeCliente, cpfCLiente, idadeCliente);
                    Pessoa.cadastrarPessoa(pessoa);
                    System.out.println("Cliente cadastrado!");
                    Thread.sleep(1500);
                    break;

                case 7:
                    System.out.println("Ate logo!");
                    Thread.sleep(1500);
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }
        } while (menu != 7);
    }

    static void mostrarMenu(){
        System.out.println("---- ALUGUEL DE VEICULOS ----");
        System.out.println("1- Cadastrar veiculos");
        System.out.println("2- Exibir veiculos disponiveis");
        System.out.println("3- Fazer orcamento");
        System.out.println("4- Reservar veiculo");
        System.out.println("5- Cadastrar pessoa");
        System.out.println("7- Sair");
        System.out.println("\n Escolha uma opcao:");
    }
}