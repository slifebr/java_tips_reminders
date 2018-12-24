package core.regex.test;

import core.regex.classes.ExpressaoRegular;

public class TesteExpressao {

	public static void main(String[] args) {

		String regex;
		String obs;
		String texto = "ashsh1jdjkdjk234jdjdj";
		ExpressaoRegular busca = new ExpressaoRegular();
		
		//busca.imprimirExemplo01();
		

		texto = "-_#@abs1df5sd\tser _gio-";
		busca.imprimirTexto(texto);
        regex = "\\d";
        obs = "tudo que     for digito";
		busca.imprimirComMetaCaracter(regex, obs, texto);
		
        regex = "\\D";
        obs ="tudo que nao for digito";
		busca.imprimirComMetaCaracter(regex, obs, texto);
		
		regex = "\\s";
        obs ="espacos em branco \\t \\n \\f \\r";
		busca.imprimirComMetaCaracter(regex, obs, texto);
		regex = "\\S";
        obs ="tudo que NAO for espacos em branco \\t \\n \\f \\r";
		busca.imprimirComMetaCaracter(regex, obs, texto);	
		
		regex = "\\w";
        obs ="caracteres a-z A-Z digitos e _";
        busca.imprimirTexto(texto);
		busca.imprimirComMetaCaracter(regex, obs, texto);	
		
		regex = "\\W";
        obs ="tudo que NAO for caracteres a-z A-Z digitos e _";
     	busca.imprimirComMetaCaracter(regex, obs, texto);		
	}

}
