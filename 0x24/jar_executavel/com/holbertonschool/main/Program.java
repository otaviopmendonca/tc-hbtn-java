package com.holbertonschool.main;

import com.holbertonschool.matematica.*; 

public class Program {
    public static void main(String[] args) {
        int soma = Aritmeticos.somar(2, 3);
        System.out.println(soma);

        int divisao = Aritmeticos.dividir(5, 2); // Corrigido
        System.out.println(divisao);

        int multiplicacao = Aritmeticos.multiplicar(12, 4); // Corrigido
        System.out.println(multiplicacao);

        int subtracao = Aritmeticos.subtrair(2, 3);
        System.out.println(subtracao);        
    }
}