package core.initializationBlocks.classes;


public class Cliente {
	
    // 0- Bloco de iniciliazação não estaticos sao executados assim que a jvm carrega a classe.
	// 1- Alocado espaço na memoria para o objeto que sera criado.
	// 2- Cada atributo de classe é criado e inicializado com seus valores default ou valores explicitos
	// 3- Bloco de inicialização é executado.
	// 4- Construtor é executado.
	
	private static int[] parcelas; // = {1,2,3,4,5,6,7,8,9,10,11,12}; // valores explicitos
	
	// bloco de inicialização
	{   

		System.out.println("bloco inicialização não estatico");
	}
	
	static {
		System.out.println("bloco inicialização estatico");
		parcelas = new int[100]; // criado um array com 100 posições
		for (int i = 1 ; i <= 100; i++) {
			parcelas[i-1] = i;
		}		
	}
	public static int[] getParcelas() {
		return parcelas;
	}

	public static void setParcelas(int[] parcelas) {
		parcelas = parcelas;
	}
	
	

}
