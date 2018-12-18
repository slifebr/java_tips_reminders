package core.initializationBlocks.tests;

import core.initializationBlocks.classes.Cliente;

public class ClienteTest01 {

	public static void main(String[] args) {

		Cliente c = new Cliente();
		Cliente c2 = new Cliente(); // os blocos  não estaticos serao executados
		Cliente c3 = new Cliente();
		System.out.println("Exibindo parcelas");
		System.out.println("=================");
		for (int parcela : c.getParcelas()) {
			System.out.println("Parcela : " + parcela);
		}
		// tbem funciona
		System.out.println("==============================");
		System.out.println("Exibindo parcelas pela classe");
		System.out.println("=============================");
		for (int parcela : Cliente.getParcelas()) {
			System.out.println("Parcela* : " + parcela);
		}
	}
}
