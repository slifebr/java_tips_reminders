package regex.classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressaoRegular {
	public void imprimirExemplo01() {
		String regex = "aba";  // informação a ser encontrada
		String texto = "ababababa"; // não é recursivo (acha a posicao 0 e 4)
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		System.out.println("Texto : " + texto);
		System.out.println("indice: 0123456789" );
		System.out.println("expressão: "+matcher.pattern());
		System.out.println("Posições encontradas");
		while(matcher.find()) {
			System.out.print(matcher.start() + " ");
		}
	}
	
}
