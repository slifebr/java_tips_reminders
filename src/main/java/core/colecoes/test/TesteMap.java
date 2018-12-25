package core.colecoes.test;
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
 *       |               |            |
 *       HashTable    HashMap     <<interface>>
 *                      |           SortedMap
 *                LinkedHashMap       |   
 *                              <<interface>>
 *                              NavigableMap
 *                                    |
 *                                 TreeMap
 *                                    
 */
import java.util.HashMap;
import java.util.Map;

public class TesteMap {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("tecl", "teclado");
		map.put("mous", "mouse");
		map.put("mont", "monitor");
		map.put("cp", "cpu");
		
		
		// iterar somente sobre um dos elementos do map
		System.out.println("iterando sobre as chaves");
		for(String key : map.keySet()) {
			System.out.println(key + " - " + map.get(key));
	
		}
		System.out.println();
		System.out.println("iterando sobre os valores");
		for(String valor : map.values()) {
			System.out.println(valor);
		}
		
		System.out.println();
		System.out.println("iterando sobre as chaves e valores (Entry)");
		for(Map.Entry<String, String> entry : map.entrySet() ) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
	
		}
		System.out.println();
		System.out.println("iterando sobre as chaves e valores (Entry) usando lambda");
		map.entrySet().forEach( entry -> {
		       System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		   }); 
		

		
		System.out.println();
		System.out.println("java-8 - lambda");
		// java -8
		map.forEach((ky,vl)->System.out.println("Chave: "+ky+" - Valor: "+ vl));

		

	}

}
