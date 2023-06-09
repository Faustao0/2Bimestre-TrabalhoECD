package com.mycompany.recursividadelista01;

import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
    
        System.out.println("Digite um número: ");
        int numero = scn.nextInt();
        
        long fatorial = calcularFatorial(numero);
        System.out.println("O fatorial do número "+ numero + " é: "+ fatorial);
        
        scn.close();
    }
    
    public static long calcularFatorial(int numero){
        if(numero == 0 || numero == 1){
            return 1;
        }else{
            return numero * calcularFatorial(numero - 1);
        }
    }
}
