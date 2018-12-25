package core.colecoes.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.colecoes.classes.Celular;
import core.colecoes.classes.Consumidor;

/*
 * Map - trabalha com chave e valor
 *       sendo qualquer objeto pode ser chave e qualver objeto pode ser valor
 *       nao pode ter chaves duplicadas
 *       
 * Map-Entry - Entry eh uma interface interna da Interface Map
 *       
 *       <<interface>>
 *           Map
 *       ------------------------------
 *       |              |             |
 *       HashTable    HashMap     <<interface>>
 *                      |           SortedMap
 *                LinkedHashMap       |   
 *                              <<interface>>
 *                              NavigableMap
 *                                    |
 *                                 TreeMap
 *                                    
 */
public class TesteConsumidorMap {

	public static void main(String[] args) {
		Consumidor consumidor1 = new Consumidor("Sergio", "1234");
		Consumidor consumidor2 = new Consumidor("Antonio", "0001");
		
		Celular cel1 = new Celular("nokia   ", "n001");
		Celular cel2 = new Celular("iPhone 6", "n002");
		Celular cel3 = new Celular("motorola", "n003");
		Celular cel4 = new Celular("iPhone 4", "n004");	
		Celular cel5 = new Celular("iPhone 7", "n007");	
		
		Map<Consumidor,Celular> carrinhoCompra = new HashMap<>();
		
		carrinhoCompra.put(consumidor1, cel1);
		carrinhoCompra.put(consumidor2, cel3);
		
		System.out.println("Mostrando os carrinhos de compra de um unico produto (Lambda)");
		System.out.println();
		carrinhoCompra.forEach((Consumidor cons, Celular cel) -> {
			System.out.println(cons.getNome() + " - " + cel);
		});
		
		System.out.println();
		System.out.println("Mostrando os carrinhos de compra de um unico produto(Map.Entry)");
		for (Map.Entry<Consumidor, Celular> entry : carrinhoCompra.entrySet()) {
			System.out.println(entry.getKey().getNome() + " - " + entry.getValue().getNome());
		}
		
		//=================================
		//map com uma lista de celulares
		//=================================
		System.out.println();
		System.out.println("map com uma lista de celulares (Map.Entry)");
		List<Celular> celularesCons1 = new ArrayList<>();
		List<Celular> celularesCons2 = new ArrayList<>();
		
		celularesCons1.add(cel1);
		celularesCons1.add(cel4);
		celularesCons1.add(cel3);
		
		celularesCons2.add(cel2);
		celularesCons2.add(cel5);
		
		Map<Consumidor, List<Celular>> carrinho = new HashMap<>();
		carrinho.put(consumidor1, celularesCons1);
		carrinho.put(consumidor2, celularesCons2);
		
		for(Map.Entry<Consumidor,List<Celular>> entry : carrinho.entrySet()) {
			System.out.println("Comprador: " + entry.getKey().getNome());
			for( Celular cel : entry.getValue()) {
				System.out.println("           " + cel.getNome());
			}
		}
		
		System.out.println();
		System.out.println("map com uma lista de celulares (lambda)");
		carrinho.forEach((cons, cels)->{
			System.out.println("Comprador: " + cons.getNome());
			cels.forEach(c->System.out.println("           " + c.getNome()));
		});
	}

}
