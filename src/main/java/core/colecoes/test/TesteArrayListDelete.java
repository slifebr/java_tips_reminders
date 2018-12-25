package core.colecoes.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TesteArrayListDelete {

	public static void main(String[] args) {
		//LinkedList e mais rapido para REMOCAO.
		//ArrayList e mais rapido para RECUPERAR.

		/*        
        					  get  	add   contains  next  remove(0) iterator.remove
		ArrayList             O(1) 	O(1) 	O(n)    O(1) 	O(n)      O(n)
		LinkedList            O(n) 	O(1) 	O(n)    O(1) 	O(1)      O(1)
		CopyOnWrite-ArrayList O(1) 	O(n) 	O(n)    O(1) 	O(n)      O(n)		
		*/	
		
		List<Integer> numeros = new LinkedList<>();
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
			if ((numerosIterator.next()  % 2)==0) {
				numerosIterator.remove();
			}
		}
		System.out.println(numeros);

	}

}
