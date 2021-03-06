package com.gabriel.exercicios.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		int numero = 0;
		boolean pertenceASequencia = false;
		List<Integer> valoresSequencia = new ArrayList<Integer>();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe um n?mero:");
		numero = entrada.nextInt();
		valoresSequencia.add(0);
		valoresSequencia.add(1);
		valoresSequencia.add(1);
		if (numero < 0) {
			System.out.println("O valor " + numero + " n?o pertence a sequ?ncia!");
			return;
		}
		if (valoresSequencia.contains(numero)) {
			System.out.println("O valor " + numero + " pertence a sequ?ncia!");
			return;
		}
		for (int i = 2; pertenceASequencia == false; i++) {
			int valorAtual = valoresSequencia.get(i);
			int valorIndiceAnterior = valoresSequencia.get(i - 1);
			int proximoValorSequencia = valorAtual + valorIndiceAnterior;
			valoresSequencia.add(proximoValorSequencia);
			if (proximoValorSequencia == numero) {
				pertenceASequencia = true;
			}
			if (proximoValorSequencia > numero) {
				break;
			}
			// System.out.println(proximoValorSequencia);
		}
		if (pertenceASequencia) {
			System.out.println("O valor " + numero + " pertence a sequ?ncia!");
		} else {
			System.out.println("O valor " + numero + " n?o pertence a sequ?ncia!");
		}
	}
}
