package core.colecoes.test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import core.colecoes.classes.Celular;

public class TesteSet {

	/*
	 * https://www.javacodegeeks.com/2011/04/simple-big-o-notation-post.html Lists
	 * and Sets:
	 * 
	 * Structure 		get 	 add 		remove 		contains 
	 * ArrayList 		O(1) 	 O(1) 		O(n) 		O(n) 
	 * LinkedList		O(n) 	 O(1) 		O(1) 		O(n) 
	 * HashSet 			O(1) 	 O(1) 		O(1) 		O(1) 
	 * LinkedHashSet 	O(1) 	 O(1) 		O(1)		O(1) 
	 * TreeSet 			O(log n) O(log n) 	O(log n) 	O(log n)
	 * 
	 * Maps: Structure 	get 		put 		remove 		containsKey 
	 * HashMap 			O(1)	 	O(1) 		O(1) 		O(1)
	 * LinkedHashMap 	O(1) 		O(1) 		O(1) 		O(1) 
	 * TreeMap 			O(log n) 	O(log n) 	O(log n) 	O(log n)
	 * Better is the enemy of good!
	 */

	/*
	 * Set - HashSet - NAO permite elementos duplicados 
	 * Set - HashSet - NAO e indexado - portanto nao tem o metodo get como List 
	 * Set - HashSet - NAO possui ordem - nao existe certeza que serao mostrados conforme entrada do elemento
	 * 
	 * Set - LinkedHashSet - mantem a ordem de inclusao
	 * 
	 * Utiliza equals para verificar se ja existe e o hashCode da classe para
	 * organizar a colecao.
	 */
	public static void main(String[] args) {
		Set<Celular> celulares = new HashSet<>();
		Celular cel1 = new Celular("nokia   ", "n001");
		Celular cel2 = new Celular("iPhone 6", "n002");
		Celular cel3 = new Celular("motorola", "n003");
		Celular cel4 = new Celular("iPhone 4", "n004");
		Celular cel5 = new Celular("abcCel", "n005");
		Celular cel6 = new Celular("xxxCel", "n005");

		celulares.add(cel1);
		celulares.add(cel2);
		celulares.add(cel3);
		celulares.add(cel4);
		celulares.add(cel5);
		celulares.add(cel6);// nao sera incluido devido ao IMEI ser o mesmo
		
		System.out.println("HashSet");
		celulares.forEach(System.out::println);
		System.out.println();

		System.out.println("LinkedHashSet");

		Set<Celular> celularesLinked = new LinkedHashSet<>();
		celularesLinked.add(cel1);
		celularesLinked.add(cel2);
		celularesLinked.add(cel3);
		celularesLinked.add(cel4);
		celularesLinked.add(cel5);
		celularesLinked.add(cel6);// nao sera incluido devido ao IMEI ser o mesmo

		celularesLinked.forEach(System.out::println);
		System.out.println();
		
		System.out.println("HashSet Classificado por Comparable (IMEI)");
		
		celulares.stream().sorted().forEach(System.out::println);
		System.out.println();

	    System.out.println("HashSet Classificado por Comparator (Nome)");
		
		celulares.stream().sorted(new Comparator<Celular>() {
			@Override
			public int compare(Celular o1, Celular o2) {
			
				return o1.getNome().compareTo(o2.getNome());
			}
			
		}).forEach(System.out::println);
		System.out.println();
	}

}
