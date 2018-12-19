package core.arrays.classes;

import java.util.Scanner;

public class ArraysMultidimensional {
	/*
	 * Agenda com meses/dias/horas
	 */

	private byte mes = 0;
	private byte dia = 0;
	private byte hora = 0;
	private String[][][] agenda = new String[12][31][24];

	private Scanner scan;

	public void informarCompromisso() {
		scan = new Scanner(System.in);
		boolean fim = false;
		int opcao = 0;
		System.out.println("Informe 1 para novo agendamento");
		System.out.println("Informe 0 para sair do agendamento");
		while (!fim) {
			System.out.println("opção: Agendamento(1) ou Sair(0)");
			System.out.println();
			opcao = scan.nextInt();
			if (opcao == 1) {
				mes = informeData("mês", 1, 12);
				dia = informeData("dia", 1, 31);
				hora = informeData("hora", 0, 23);
				// informar compromisso
				System.out.println("Informe compromisso");
				mes--;
				dia--;
				agenda[mes][dia][hora] = scan.next();
			} else if (opcao == 0) {
				fim = true;
				scan.close();
			} else {
				System.out.println("Opção inválida. Informe novamente.");
			}
		}
	}

	public void mostrarCompromisso() {
		scan = new Scanner(System.in);
		boolean fim = false;
		int opcao = 0;
		System.out.println("Informe 1 para consultar agendamento");
		System.out.println("Informe 0 para Sair da consulta");
		while (!fim) {
			System.out.println("opção: Consultar(1) ou Sair(0)");
			System.out.println();
			opcao = scan.nextInt();
			if (opcao == 1) {
				mes = informeData("mês", 1, 12);
				dia = informeData("dia", 1, 31);
				hora = informeData("hora", 0, 23);
				// informar compromisso
				System.out.println("Consultar compromisso");
				mes--;
				dia--;
				if (agenda[mes][dia][hora] != null) {
					System.out.println("Compromisso para o dia: " + mes + " mes: " + dia + " hora: " + hora + " : "
							+ agenda[mes][dia][hora]);
					System.out.println("====================================================");
				} else {
					System.out.println("Sem compromisso para esta data");
				}
			} else if (opcao == 0) {
				fim = true;
				scan.close();
			} else {
				System.out.println("Opção inválida. Informe novamente.");
			}
		}
	}

	private byte informeData(String periodo, int faixaInicio, int faixaFinal) {

		byte retorno = 0;
		boolean sair = false;
		while (!sair) {
			System.out.println("Informe " + periodo + " do compromisso");
			System.out.println();
			retorno = scan.nextByte();
			if (retorno >= faixaInicio && retorno <= faixaFinal) {
				sair = true;
			} else {
				System.out.println("Informação inválida. Deve ficar entre : " + faixaInicio + " e " + faixaFinal);
			}
		}
		return retorno;

	}
}
