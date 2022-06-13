package com.gabriel.exercicios.exercicio5;

import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args) {
		String valor = "", valorInvertido = "";
		Scanner entrada = new Scanner(System.in);
		while (valor.equals("") || valor.isEmpty()) {
			System.out.println("Informe uma palavra:");
			valor = entrada.next();
			if (valor.isEmpty() || valor.equals("")) {
				System.out.println("Informe um valor para a String!");
			}
		}
		for (int i = valor.length() - 1; i >= 0; i--) {
			char caracter = valor.charAt(i);
			valorInvertido += caracter;
		}
		System.out.println("Valor: " + valor);
		System.out.println("Valor invertido: " + valorInvertido);
	}
}
