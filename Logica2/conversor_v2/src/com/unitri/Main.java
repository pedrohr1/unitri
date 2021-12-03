package com.unitri;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner opcao = new Scanner(System.in);
        Conversor conversor = new Conversor();
        int menu, opcaoSaida;
        String valorInformado = "";
        do {
            mostrarMenu();
            menu = opcao.nextInt();
            switch(menu){
                case 1: case 2: case 3: case 4:
                    System.out.println("Entre com o valor:");
                    valorInformado = opcao.next();
                    menuConversao();
                    opcaoSaida = opcao.nextInt();
                    if (opcaoSaida == menu) {
                        System.out.println("Por favor reveja as opcoes");
                        Thread.sleep(1500);
                        break;
                    } else {
                        System.out.println("O resultado convertido e " + conversor.Conversor(valorInformado, menu, opcaoSaida));
                        menu = 0;
                        opcaoSaida = 0;
                        valorInformado = "";
                        Thread.sleep(1500);
                        break;
                    }
                case 9:
                    System.out.println("Ate logo!");
                    Thread.sleep(1500);
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (menu != 9);
    }
    static void mostrarMenu() {
        System.out.println("---- CONVERSOR ----");
        System.out.println("Escolha um tipo de entrada:");
        System.out.println("1- Decimal");
        System.out.println("2- Binario");
        System.out.println("3- Octal");
        System.out.println("4- Hexadecimal");
        System.out.println("9- Sair");
    }
    static void menuConversao() {
        System.out.println("Escolha uma saida:");
        System.out.println("1- Decimal");
        System.out.println("2- Binario");
        System.out.println("3- Octal");
        System.out.println("4- Hexadecimal");
    }
}