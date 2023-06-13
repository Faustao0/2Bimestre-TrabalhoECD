package com.mycompany.filaslista01;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
             
        Queue<Cliente> filaPrioritaria = new LinkedList<>();
        Queue<Cliente> filaNormal = new LinkedList<>();
        
        Scanner scn = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Chamar próximo cliente");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scn.nextInt();

            switch (opcao) {
                case 1:
                    scn.nextLine();
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scn.nextLine();
                    System.out.print("Digite o ano de nascimento do cliente: ");
                    int anoNascimento = scn.nextInt();
                    Cliente cliente = new Cliente(nomeCliente, anoNascimento);
                    adicionarCliente(filaPrioritaria, filaNormal, cliente);
                    System.out.println("Cliente adicionado à fila.");
                    break;
                case 2:
                    Cliente proximoCliente = ProximoCliente(filaPrioritaria, filaNormal);
                    if (proximoCliente != null) {
                        System.out.println("Próximo cliente: " + proximoCliente.getNome());
                    } else {
                        System.out.println("Não há clientes na fila.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente.");
            }
            System.out.println();
        } while (opcao != 0);
        
        scn.close();
    }

    private static void adicionarCliente(Queue<Cliente> filaPrioritaria, Queue<Cliente> filaNormal, Cliente cliente) {
        if (cliente.getIdade()>= 65) {
            filaPrioritaria.offer(cliente);
        } else {
            filaNormal.offer(cliente);
        }
    }

    private static Cliente ProximoCliente(Queue<Cliente> filaPrioritaria, Queue<Cliente> filaNormal) {
        if (filaPrioritaria.size() >= 2) {
            return filaPrioritaria.poll();
        } else if (!filaPrioritaria.isEmpty()) {
            return filaPrioritaria.poll();
        } else if (!filaNormal.isEmpty()) {
            return filaNormal.poll();
        } else {
            return null;
        }
    }
    
    private static class Cliente {
        
        private String nome;
        private int dataNascimento;

        public Cliente(String nome, int dataNascimento) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return java.time.Year.now().getValue() - dataNascimento;
        }
    }
}
