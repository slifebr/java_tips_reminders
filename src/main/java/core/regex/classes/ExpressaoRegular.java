package core.regex.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressaoRegular {
	public void imprimirExemplo01() {
		String regex = "aba"; // informação a ser encontrada
		String texto = "ababababa"; // não é recursivo (acha a posicao 0 e 4)
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		System.out.println("Texto : " + texto);
		System.out.println("indice: 0123456789");
		System.out.println("expressão: " + matcher.pattern());
		System.out.println("Posições encontradas");
		while (matcher.find()) {
			System.out.print(matcher.start() + " ");
		}
	}

	public void imprimirComMetaCaracter(String regex, String obs, String texto) {

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);

		System.out.println("expressão: " + matcher.pattern() + "  - " + obs);
		System.out.println("Posições encontradas");
		while (matcher.find()) {
			System.out.print(matcher.start() + " ");
		}
		System.out.println();
		System.out.println("========================================");

	}

	public List<String> imprimirGroup(String regex, String obs, String texto) {
		List<String> retorno = new ArrayList<>();
		retorno = imprimirGroup(regex, obs, texto, false, true);
		return retorno;
	}

	public List<String> imprimirGroup(String regex, String obs, String texto, boolean validar, boolean imprimir) {
		List<String> retorno = new ArrayList<>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);

		System.out.println("expressão: " + matcher.pattern() + "  - " + obs);
		System.out.println("Posições encontradas");
		String valorEncontrado;

		while (matcher.find()) {
			valorEncontrado = matcher.group();
			if (imprimir) {
				System.out.print(matcher.start() + " " + valorEncontrado);
				if (validar)
					System.out.print(" Valido: " + matcher.group().matches(regex));
				System.out.println();

			}
			retorno.add(valorEncontrado);
		}
		System.out.println();
		System.out.println("========================================");
		return retorno;
	}

	public void imprimirTexto(String texto) {
		System.out.println("=========================================");
		System.out.println("Texto : " + texto);
		System.out.println("indice: 012345678901234567890");
		System.out.println("=========================================");
	}

}
