package com.mycompany.bim.trabalhoecd.models;


public class Conta {
    
    private int numero;
    private double saldo;
    private String nomeTitular;

    public Conta(int numero, double saldo, String nomeTitular) {
        this.numero = numero;
        this.saldo = saldo;
        this.nomeTitular = nomeTitular;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }
    
    public void depositar(double valor){
        saldo += valor;
    }
    
    public boolean sacar(double valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta bancária: " + "Numero = " + numero + ", Saldo = " + saldo + ", Nome do Titular = " + nomeTitular + '}';
    }
}