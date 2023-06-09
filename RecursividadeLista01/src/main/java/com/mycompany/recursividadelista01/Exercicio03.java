package com.mycompany.recursividadelista01;

import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Digite um número: ");
        
        int numero = scn.nextInt();
        
        System.out.println("A sequência fibonacci até o numero "+ numero +" é:");
            for(int i = 0; i <= numero; i++){
                System.out.print(calcularSequencia(i)+ " ");
            }
            
        scn.close();
    }
    
    public static int calcularSequencia(int numero){
        if(numero == 0){
            return 0;
        }else if (numero == 1 || numero == 2){
           return 1;
        }else{
            return calcularSequencia(numero - 1) + calcularSequencia(numero - 2);
        }
    }
}
