package com.mycompany.linearebinarialista01;

import com.mycompany.linearebinarialista01.models.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exercicio02 {

    private static List<Cliente> clientes = new ArrayList<>();
    
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        int opcao = 0;
        do {
            System.out.println("1) Cadastrar cliente");
            System.out.println("2) Pesquisar cliente");
            System.out.println("3) Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scn.nextInt();
            scn.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente(scn);
                    break;
                case 2:
                    pesquisarCliente(scn);
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 3);

        scn.close();
    }

    public static void cadastrarCliente(Scanner scn) {
        System.out.print("Digite o código do cliente: ");
        int codigo = scn.nextInt();
        scn.nextLine();
        System.out.print("Digite o nome do cliente: ");
        String nome = scn.nextLine();
        System.out.print("Digite a data de nascimento do cliente: ");
        String dataNascimento = scn.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scn.nextLine();

        Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
        clientes.add(cliente);

        Collections.sort(clientes, Comparator.comparingInt(Cliente::getCodigo));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void pesquisarCliente(Scanner scn) {
        System.out.print("Digite o código do cliente a ser pesquisado: ");
        int codigoPesquisa = scn.nextInt();
        scn.nextLine();

        int index = buscaBinaria(codigoPesquisa);

        if (index != -1) {
            Cliente cliente = clientes.get(index);
            System.out.println("Cliente encontrado");
            System.out.println("Código: " + cliente.getCodigo());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println("CPF: " + cliente.getCpf());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public static int buscaBinaria(int codigoPesquisa) {
        int esquerda = 0;
        int direita = clientes.size() - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            int codigoAtual = clientes.get(meio).getCodigo();

            if (codigoAtual == codigoPesquisa) {
                return meio;
            } else if (codigoAtual < codigoPesquisa) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }     
        return -1;
    }
}
