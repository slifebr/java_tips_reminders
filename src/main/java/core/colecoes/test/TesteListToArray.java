package core.colecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TesteListToArray {

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(6);
		numeros.add(1);

		System.out.println("====================================================");
		System.out.println("conversao de um List para um Array");
		System.out.println("====================================================");
		// Object[] objs = numeros.toArray();
		Integer[] numerosArray = new Integer[numeros.size()];
		numeros.toArray(numerosArray);
		System.out.println(numeros);
		System.out.println(Arrays.toString(numerosArray));

		System.out.println("====================================================");
		System.out.println("conversao de um Array  para um  List");
		System.out.println("====================================================");
		List<Integer> numerosConvertidos = Arrays.asList(numerosArray);
		System.out.println();
		System.out.println(numerosConvertidos);
		/*
		 * O Arrays.asList faz a conversao de array para lista, mas
		 * ambos referencia o mesmo objeto na memoria heap.
		 * Ou seja se fizer alguma mudanca no array ou no list (inclusao, delecao, update), sera
		 * refletido em ambos.
		 */
		
		// teste
		numerosArray[0] = 10;
		System.out.println(numerosConvertidos);
		numerosConvertidos.set(1, 11);
		System.out.println(Arrays.toString(numerosArray));
		// entao se tentar adicionar um elemento na lista,
		// nao sera suportado devido ao array.
		
		// para evitar isso:
		List<Integer> numeros2 = new ArrayList<>();
		numeros2.addAll(Arrays.asList(numerosArray));
		numeros2.add(30);
		numeros2.add(50);
		System.out.println(numeros2);
		System.out.println(Arrays.asList(numerosArray));
		
		// criar um array
		List<Integer> numeros3 = new ArrayList<>(Arrays.asList(numerosArray));
		//Collections.copy(numeros3,numeros2);
		numeros3.add(50);
		System.out.println(numeros3);

	}

}
