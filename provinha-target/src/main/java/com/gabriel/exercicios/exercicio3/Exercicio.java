package com.gabriel.exercicios.exercicio3;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Exercicio {

	private static List<Faturamento> lerDados() throws Exception {
		List<Faturamento> faturamentos = new ArrayList<Faturamento>();
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArrayFaturamentos = (JSONArray) jsonParser.parse(new InputStreamReader(new FileInputStream("dados.json")));
		for (Object fatuObjJson : jsonArrayFaturamentos) {
			JSONObject objJson = (JSONObject) fatuObjJson;
			Integer dia = Integer.parseInt(objJson.get("dia").toString());
			Double valor = Double.parseDouble(objJson.get("valor").toString());
			Faturamento faturamento = new Faturamento(dia, valor);
			faturamentos.add(faturamento);
		}
		return faturamentos;
	}
	private static double getMenorValorFaturamento(List<Faturamento> faturamentos) {
		double menorValorFaturamento = 9999999;
		for (Faturamento faturamento : faturamentos) {
			if (faturamento.getValor() < menorValorFaturamento) {
				menorValorFaturamento = faturamento.getValor();
			}
		}
		return menorValorFaturamento;
	}
	private static double getMaiorValorFaturamento(List<Faturamento> faturamentos) {
		double maiorValorFaturamento = 0;
		for (Faturamento faturamento : faturamentos) {
			if (faturamento.getValor() > maiorValorFaturamento) {
				maiorValorFaturamento = faturamento.getValor();
			}
		}
		return maiorValorFaturamento;
	}
	private static double calcularMediaFaturamentoMensal(List<Faturamento> faturamentos) {
		double media = 0;
		double soma = 0;
		int quantidadeDiasSemFaturamento = 0;
		for (Faturamento faturamento : faturamentos) {
			if (faturamento.getValor() == 0) {
				quantidadeDiasSemFaturamento++;
				continue;
			}
			soma += faturamento.getValor();
		}
		media = soma / (faturamentos.size() - quantidadeDiasSemFaturamento);
		// System.out.println(quantidadeDiasSemFaturamento);
		// System.out.println(media);
		return media;
	}
	public static int calcularQuantosDiasOValorDoFaturamentoFoiSuperiorAMediaMensal(List<Faturamento> faturamentos, double mediaMensal) {
		int quantidadeDeDias = 0;
		for (Faturamento fat : faturamentos) {
			if (fat.getValor() > mediaMensal) {
				quantidadeDeDias++;
			}
		}
		return quantidadeDeDias;
	}
	public static void main(String[] args) {
		try {
			List<Faturamento> faturamentos = lerDados();
			double menorValorFaturamento = getMenorValorFaturamento(faturamentos);
			double maiorValorFaturamento = getMaiorValorFaturamento(faturamentos);
			System.out.println("Menor valor de faturamento: R$" + menorValorFaturamento);
			System.out.println("Maior valor de faturamento: R$" + maiorValorFaturamento);
			double mediaFaturamentos = calcularMediaFaturamentoMensal(faturamentos);
			int quantidadeDiasQueOFaturamentoFoiMaiorQueAMediaMensal = calcularQuantosDiasOValorDoFaturamentoFoiSuperiorAMediaMensal(faturamentos, mediaFaturamentos);
			System.out.println("Valor da m?dia mensal: R$" + mediaFaturamentos);
			System.out.println("Quantidade de dias em que o faturamento foi maior que a m?dia mensal: " + quantidadeDiasQueOFaturamentoFoiMaiorQueAMediaMensal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
