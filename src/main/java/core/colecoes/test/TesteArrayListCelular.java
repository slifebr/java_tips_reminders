package core.colecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import core.colecoes.classes.Celular;

class CelularPorNome implements Comparator<Celular> {

	@Override
	public int compare(Celular o1, Celular o2) {

		return o1.getNome().compareTo(o2.getNome());
	}

}

public class TesteArrayListCelular {
	public static void main(String[] args) {
		Celular cel1 = new Celular("nokia   ", "n001");
		Celular cel2 = new Celular("iPhone 6", "n002");
		Celular cel3 = new Celular("motorola", "n003");
		Celular cel4 = new Celular("iPhone 4", "n004");

		List<Celular> celulares = new ArrayList<>();
		celulares.add(cel1);
		celulares.add(cel4);
		celulares.add(cel2);
		celulares.add(cel3);

		System.out.println("======== Imprimindo lista usando REFERENCIA P/ METODO ===========");
		celulares.forEach(System.out::println);
		System.out.println();

		System.out.println("======== usando arrow function ===========");
		celulares.forEach(c -> {
			System.out.println(c.getNome() + " " + c.getIMEI());
		});

		// Classificando usando Collections e implementanto Comparable
		// Comparable e implementado na classe Celular

		System.out.println();
		System.out.println("======== Classificando usando Collections e implementanto Comparable ===========");
		Collections.sort(celulares);
		celulares.forEach(System.out::println);

		// Classificando usando Collections e classe de sort que
		// implementa interface Comparator
		//

		System.out.println();
		System.out.println(
				"======== Classificando usando Collections e classe de sort que implementa interface  Comparator===========");
		Collections.sort(celulares, new CelularPorNome());
		celulares.forEach(System.out::println);

		// Classificando usando Collections e classe de sort que
		// implementa interface Comparator
		//

		System.out.println();
		System.out.println(
				"======== Classificando por IMEI usando Collections e Anonymous Inner class Comparator ===========");
		Collections.sort(celulares, new Comparator<Celular>() {

			@Override
			public int compare(Celular o1, Celular o2) {

				return o1.getIMEI().compareTo(o2.getIMEI());
			}

		});
		celulares.forEach(System.out::println);

		System.out.println();
		System.out.println("======== Classificando por nome utilizando stream ===========");
		celulares.stream().sorted((c1, c2) -> c1.getNome().compareTo(c2.getNome())).forEach(c -> {
			System.out.println(c.getNome() + " " + c.getIMEI());
		});

		System.out.println();
		System.out.println("======== Checar se um celular existe na lista ===========");
		Celular cel5 = new Celular("iPhone 4", "n004");

		System.out.println("cel5 == cel4: " + (cel5 == cel4));
		System.out.println("cel5.equals( cel4): " + (cel5.equals(cel4)));
		System.out.println("celulares.contains(cel5): " + celulares.contains(cel5));

	}
}
