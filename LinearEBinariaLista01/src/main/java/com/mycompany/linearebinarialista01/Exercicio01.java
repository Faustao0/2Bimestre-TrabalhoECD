package com.mycompany.linearebinarialista01;

import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a quantidade de números a serem cadastrados: ");
        int quantidade = scanner.nextInt();

        int[] numeros = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Informe o número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        bubbleSort(numeros);

        int opcao;
        do {
            System.out.println("\nMenu de Pesquisa");
            System.out.println("1. Pesquisa Linear");
            System.out.println("2. Pesquisa Binária");
            System.out.println("0. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Informe o número a ser pesquisado: ");
                int numero = scanner.nextInt();
                int posicao = pesquisaLinear(numeros, numero);
                if (posicao == -1) {
                    System.out.println("Número não encontrado.");
                } else {
                    System.out.println("Número encontrado na posição " + posicao + ".");
                }
            } else if (opcao == 2) {
                System.out.print("Informe o número a ser pesquisado: ");
                int numero = scanner.nextInt();
                int posicao = pesquisaBinaria(numeros, numero);
                if (posicao == -1) {
                    System.out.println("Número não encontrado");
                } else {
                    System.out.println("Número encontrado na posição: " + posicao);
                }
            }
        } while (opcao != 0);

        System.out.println("Programa finalizado!");
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int pesquisaLinear(int[] array, int numero) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public static int pesquisaBinaria(int[] array, int numero) {
        int esquerda = 0;
        int direita = array.length - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;

            if (array[meio] == numero) {
                return meio;
            }

            if (array[meio] < numero) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }
}
