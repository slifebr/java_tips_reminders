package core.colecoes.test;

import java.util.ArrayList;
import java.util.List;

public class TesteArrayList {

	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();
		List<String> nomes2 = new ArrayList<>();

		nomes.add("sergio");
		nomes.add("joao");
		nomes.add("maria");
		System.out.println("Lista nomes (usando um for tradicional)");
		System.out.println("================================");
		// usando um for tradicional
		for (int i = 0; i < nomes.size(); i++) {
			System.out.println(nomes.get(i));
		}
		
		System.out.println();
		
		
		nomes2.add("sergio");
		nomes2.add("jose");
		nomes2.add("sandra");
		System.out.println("Lista nomes(2) (usando um foreach do java-7)");
		System.out.println("================================");
		
		//usando um foreach do java-7
		for(String nome : nomes2) {
			System.out.println(nome);
		}
		System.out.println();
		
		// fazer um merge
		nomes.addAll(nomes2);
		// usando foreach do java-8
		System.out.println("Lista nomes(Merge da lista 1 e lista 2) (usando um foreach do java-8)");
		System.out.println("================================");
		nomes.forEach(System.out::println);
	}

}
