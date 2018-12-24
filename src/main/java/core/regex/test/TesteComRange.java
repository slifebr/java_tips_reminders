package core.regex.test;

import java.util.List;

import core.regex.classes.ExpressaoRegular;

public class TesteComRange {

	/*
	 * \d - todos os digitos
	 * \D - NAO digitos
	 * \s - espacos em brancos \t(tabulacao) \n \f \r
	 * \S - NAO espacos em brancos \t(tabulacao) \n \f \r
	 * \w - caracteres a-z A-Z e _
	 * \W - NAO caracteres a-z A-Z e _
	 * [] - range de pesquisa
	 * =====================================
	 * Quantificadores
	 * =====================================
	 * ? - zero ou uma
	 * * - zero ou mais
	 * + - uma ou mais
	 * {n,m} - de n ate m
	 * ====================================
	 * () - agrupador 
	 * |  - uma ou outra
	 * $  - final da linha
	 * .  - coringa
	 * ^  - negacao
	 * exemplo: o(|v|c)o = ovo, oco
	 *          maca(rr|c)ao = macarrao, macacao
	 *          1.3 = 123, 133, 1a3, 1 3....
	 *          ^[abc] = qualquer coisa que nao seja abc
	 * 
	 */
	public static void main(String[] args) {
		String regex;
		String obs;
		String texto ;
		ExpressaoRegular busca = new ExpressaoRegular();
		
		texto = "cafe BABEL";
		busca.imprimirTexto(texto);
        regex = "[abcABC]";
        obs = "procura por abc minusculo ou maiusculo";
		busca.imprimirComMetaCaracter(regex, obs, texto);
		
        regex = "[a-zABC]";
        obs = "procura por a ate z minusculo e ABC maiusculo";
		busca.imprimirComMetaCaracter(regex, obs, texto);
		
		//  buscando por valores hexadecimais
		texto = "0s0x100 0xFFaag 0Xafff g0x48";
		busca.imprimirTexto(texto);
        regex = "0[xX][0-9a-fA-F]";
        obs = "busca valores hexadecimais";
		busca.imprimirGroup(regex, obs, texto);		
		
		//  buscando por valores hexadecimais com agrupamento
        regex = "0[xX]([0-9a-fA-F])+"; // uma ou mais vezes
        obs = "busca valores hexadecimais";
		busca.imprimirGroup(regex, obs, texto);	
		
		//  buscando por valores hexadecimais com agrupamento
        regex = "0[xX]([0-9a-fA-F])+(\\s|$)"; // uma ou mais vezes
        busca.imprimirTexto(texto);
        obs = "busca valores hexadecimais considerando delimitador de espaco ou fim de linha";
		busca.imprimirGroup(regex, obs, texto);	
		
		// emails
		texto = "fulano.tal@hotmail.com, 100abc@gmail.com, cicrano@uol.com.br, #@!qualquer@mail, teste@gmail.br, teste@mail";
        regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; // uma ou mais vezes
        busca.imprimirTexto(texto);
        obs = "buscando emails validos";
		busca.imprimirGroup(regex, obs, texto,true,true);	
		
		// datas
		texto = "5/10/20104, 31/134/00, 20/2/18, 11/01/2014, 1/1/01";
        regex = "\\d{1,2}/\\d{1,2}/\\d{2,4}([^,])*"; // uma ou mais vezes e excluindo virgulas
        busca.imprimirTexto(texto);
        obs = "buscando datas e excluindo virgulas";
        List<String> lista = busca.imprimirGroup(regex, obs, texto,true,false);	
        
        lista.forEach(System.out::println);
	}

}
