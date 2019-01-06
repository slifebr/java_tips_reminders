package core.colecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import core.colecoes.classes.Celular;

class CelularPorNomeComparator implements Comparator<Celular> {

	@Override
	public int compare(Celular o1, Celular o2) {

		return o1.getNome().compareTo(o2.getNome());
	}

}

public class TesteArrayListBuscaBinaria {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();

		numeros.add(2);
		numeros.add(3);
		numeros.add(0);
		numeros.add(4);

		// regras para busca binaria
		// (1) a lista tem que ser ordenada pelo que se quer buscar
		// (2) se nao encontrar, o valor retornado sera (-(ponto de insercao) -1) (-1 -1
		// )=-2

		// indice: 0123
		// 0234
		Collections.sort(numeros);
		System.out.println(Collections.binarySearch(numeros, 3));
		System.out.println(Collections.binarySearch(numeros, 5)); // nao existe retorna -5
		System.out.println(Collections.binarySearch(numeros, 1)); // nao existe retorna -2

		Celular cel1 = new Celular("nokia   ", "n001");
		Celular cel2 = new Celular("iPhone 6", "n003");
		Celular cel3 = new Celular("motorola", "n004");
		Celular cel4 = new Celular("iPhone 4", "n002");

		List<Celular> celulares = new ArrayList<>();
		celulares.add(cel1);
		celulares.add(cel4);
		celulares.add(cel2);
		celulares.add(cel3);

		// celular a ser adicionado
		Celular cel5 = new Celular("iPhone 3", "n005");

		// sera classificado pelo IMEI pela implementacao de Comparable na classe
		// Celular
		// Collections.sort(celulares);
		//
		// System.out.println();
		// System.out.println("===================================");
		// System.out.println("binarySearch para uma lista de celulares por IMEI");
		// System.out.println("===================================");
		// celulares.forEach(c->{
		// System.out.println(c+" indice atual:"+Collections.binarySearch(celulares,
		// c));
		// });
		//
		// System.out.println(Collections.binarySearch(celulares, cel5));
		// celulares.add(Collections.binarySearch(celulares, cel5)*-1-1,cel5);
		//
		// Collections.sort(celulares);
		// celulares.forEach(c->{
		// System.out.println(c+" indice atual:"+Collections.binarySearch(celulares,
		// c));
		// });

		System.out.println("==========================================================");
		System.out.println("binarySearch para uma lista de celulares ordenado por nome");
		System.out.println("==========================================================");
		Collections.sort(celulares, new CelularPorNomeComparator());
		System.out.println(Collections.binarySearch(celulares, cel5));
		int indice = Collections.binarySearch(celulares, cel5);
		// sera classificado pelo Comparator

		celulares.forEach(c -> {
			System.out.println(c + " indice atual:" + Collections.binarySearch(celulares, c, new CelularPorNomeComparator()));
		});
		// System.out.println(cel5 + " indice de inclusao: " +
		// Collections.binarySearch(celulares, cel5,new CelularPorNome()));

		if (indice >= 0) {
			System.out.println("Celular ja esta incluso: indice: " + indice);
		} else {
			System.out.println("==========================================================");
			System.out.println("binarySearch apos inclusao de novo celular");
			celulares.add(indice * -1 - 1, cel5);
			Collections.sort(celulares, new CelularPorNomeComparator());
			celulares.forEach(c -> {
				System.out.println(c + " indice atual:" + Collections.binarySearch(celulares, c, new CelularPorNomeComparator()));
			});
		}
		//Collections.sort(celulares); // modifica totalmente os indices conforme classificacao
		System.out.println(celulares.get(0));
	}

}
