package core.colecoes.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TesteArrayListDelete {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(6);
		numeros.add(1);
		System.out.println(numeros);
		
		//provoca o erro
		//ConcurrentModificationException
		/*	for (Integer numero : numeros) {
				if ((numero % 2)==1) {
						numeros.remove(numero);
			}
		}*/
		
		Iterator<Integer> numerosIterator = numeros.iterator();
		while(numerosIterator.hasNext()) {
			//int numero = numerosIterator.next() ;
			if ((numerosIterator.next()  % 2)==0) {
				numerosIterator.remove();
			}
		}
		System.out.println(numeros);

	}

}
