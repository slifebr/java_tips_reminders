package core.heranca.classe;

public class ClasseFilha extends ClassePai{

	private String str = "valor-filha";
	
	public ClasseFilha() {
		System.out.println("============== FILHA ===================================");
		System.out.println("constructor da classe pai: " + super.str + " filha: " + str);
		str = " alterado no construtor-filha";
		super.str = "alterado o atributo do pai no construtor da filha";
	}

	static {
		System.out.println("============== FILHA ===================================");
		System.out.println("bloco inicializacao stattic classe filha-1" );
	}
	
	{
		System.out.println("============== FILHA ===================================");
		System.out.println("bloco inicializacao classe filha-1 :-" + super.str + "- filha: " + str);
		str = "inicializacao-1-filha";
		super.str = "alterado o atributo do pai no ini-1 da filha";
	}

	{
		System.out.println("============== FILHA ===================================");
		System.out.println("bloco inicializacao classe filha-2 :-" + super.str+ "- filha: " + str);
		str = "inicializacao-2-filha";
		super.str = "alterado o atributo do pai no ini-2 da filha";
	}
	
}
