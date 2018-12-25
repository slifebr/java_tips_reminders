package core.colecoes.test;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

import core.colecoes.classes.Celular;

public class TesteTreeSet {
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
	 * 				   Utiliza equals para verificar se ja existe e o hashCode da classe para
	 * 				   organizar a colecao.
	 * 
	 * Set - LinkedHashSet - mantem a ordem de inclusao
	 * 
	 * NavigableSet - TreeSet - PERMITE inclusao de DUPLICADOS
	 *                          TRAZ classificado, (A MAIOR vantagem), pelo comparable ou pelo Comparator
	 *                          a classe TEM que implementar um Comparable ou 
	 *                          na criacao do TreeSet, passar um Comparator.
	 *                          Eh melhor usar a interface NavigableSet que Set
	 *                          Eh um pouco mais lento
	 *                          Possui varios metodos adicionais(lower,floor, higher, ceiling, descendingSet)
	 *                           
	 * Set - LinkedHashSet - mantem a ordem de inclusao
	 * 
	 */
	public static void main(String[] args) {
		NavigableSet<Celular> celulares = new TreeSet<>( new Comparator<Celular>() {
			@Override
			public int compare(Celular o1, Celular o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		Celular cel1 = new Celular("nokia   ", "n001");
		Celular cel2 = new Celular("iPhone 6", "n002");
		Celular cel3 = new Celular("motorola", "n003");
		Celular cel4 = new Celular("iPhone 4", "n004");
		Celular cel5 = new Celular("abcCel", "n005");
		Celular cel6 = new Celular("xxxCel", "n005");

		celulares.add(cel1);
		celulares.add(cel4);
		celulares.add(cel3);
		celulares.add(cel2);
		celulares.add(cel5);
		celulares.add(cel6);// nao sera incluido devido ao IMEI ser o mesmo
		
		celulares.forEach(System.out::println);
		System.out.println();
		// lower - < menor
		// floor - <= menor ou igual
		// higher - > maior
		// ceiling - >= maior ou igaul
		// descendingSet - ordem inversa
		Celular celRefer = cel3;
		System.out.println("Refer.:" + celRefer);
		System.out.println();
		System.out.println("lower:" + celulares.lower(celRefer));
		System.out.println("floor:" + celulares.floor(celRefer));
		System.out.println("higher:" + celulares.higher(celRefer));
		System.out.println("ceiling:" + celulares.ceiling(celRefer));
		System.out.println();
		System.out.println(" ordem inversa");
		celulares.descendingSet().forEach(System.out::println);

	}

}
