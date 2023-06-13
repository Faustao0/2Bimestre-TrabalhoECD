package com.mycompany.filaslista01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {
       
        Queue<String> fila = new LinkedList<>();
        Scanner scn = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Chamar o próximo paciente");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scn.nextInt();

            switch (opcao) {
                case 1:
                    scn.nextLine();
                    System.out.print("Digite o nome do paciente: ");
                    String nomePaciente = scn.nextLine();
                    adicionarPaciente(fila, nomePaciente);
                    System.out.println("Paciente adicionado à fila.");
                    break;
                case 2:
                    String proximoPaciente = chamarPaciente(fila);
                    if (proximoPaciente != null) {
                        System.out.println("Próximo paciente: " + proximoPaciente);
                    } else {
                        System.out.println("Não há pacientes na fila.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Digite novamente.");
            }
            System.out.println();
        } while (opcao != 0);
        
        scn.close();
    }

    private static void adicionarPaciente(Queue<String> fila, String nomePaciente) {
        fila.offer(nomePaciente);
    }

    private static String chamarPaciente(Queue<String> fila) {
        return fila.poll();
    }
}
