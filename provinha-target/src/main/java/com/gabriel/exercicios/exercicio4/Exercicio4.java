package com.gabriel.exercicios.exercicio4;

public class Exercicio4 {

	private static double calcularPercentualRepresentacao(double faturamento, double faturamentoTotal) {
		return (faturamento * 100) / faturamentoTotal;
	}
	public static void main(String[] args) {
		double faturamentoSP = 67.837;
		double faturamentoRJ = 36.679;
		double faturamentoMG = 29.230;
		double faturamentoES = 27.166;
		double faturamentoOutros = 19.850;
		double faturamentoTotal = faturamentoSP + faturamentoRJ + faturamentoES + faturamentoMG + faturamentoOutros;
		System.out.println("Faturamento total: R$" + faturamentoTotal);
		System.out.println("O faturamento de SP representa " + calcularPercentualRepresentacao(faturamentoSP, faturamentoTotal) + "% do faturamento total!");
		System.out.println("O faturamento de RJ representa " + calcularPercentualRepresentacao(faturamentoRJ, faturamentoTotal) + "% do faturamento total!");
		System.out.println("O faturamento de MG representa " + calcularPercentualRepresentacao(faturamentoMG, faturamentoTotal) + "% do faturamento total!");
		System.out.println("O faturamento de ES representa " + calcularPercentualRepresentacao(faturamentoES, faturamentoTotal) + "% do faturamento total!");
		System.out.println("O faturamento (Outros) representa " + calcularPercentualRepresentacao(faturamentoOutros, faturamentoTotal) + "% do faturamento total!");
	}
}
