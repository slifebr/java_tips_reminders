package core.heranca.classe;

public class ClassePai {
	protected String str = "valor atrib pai";
	
	public ClassePai() {
		System.out.println("============== PAI ===================================");
		System.out.println("constructor da classe pai: -" + str);
		str = "construtor-pai";
	}

	static {
		System.out.println("============== PAI ===================================");
		System.out.println("bloco inicializacao stattic classe pai-1" );
	}
	
	{
		System.out.println("============== PAI ===================================");
		System.out.println("bloco inicializacao classe pai-1 :-" + str );
		str = "inicializacao-1-pai";
	}

	{
		System.out.println("bloco inicializacao classe pai-2 :" + str);
		str = "inicializacao-2-pai";
	}

}
