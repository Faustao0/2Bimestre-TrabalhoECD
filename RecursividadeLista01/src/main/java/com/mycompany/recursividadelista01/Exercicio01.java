package com.mycompany.recursividadelista01;

public class Exercicio01 {

    public static void main(String[] args) {
        
        int resultado = resultado(50);
        System.out.println("A soma de 0 a 50 é: "+ resultado);        
    }
    
    public static int resultado(int numero){
        if(numero == 0){
            return 0;
        }else{
            return numero + resultado(numero - 1);
        }
    }

}
