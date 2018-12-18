package core.arrays.classes;

public class Arrays01 {
	/*
	 * Valores padrões na inicialização dos arrays
	 * byte, short, int, long,float, double = 0
	 * char = unicode representando vazio '0\u0000' = ' '
	 * boolean = false
	 * reference (objetos) = null
	 */
	private int[] idadeArraySimples = new int[4];
	private int[] idadeArraySimplesClone = new int[4];
	
	// outra maneria criacao: passar os valores diretamente no array
	private int[] numeros = {1,2,3,4,5,6,7,8,9,0};
	//private int[] numeros = new int[] {11,2,3,4,5,6,7,8,9,0}; // outra maneira
	
	
	//===========================================================
	// arrays bi-dimensionais
	//===========================================================
	private int[][] dias = new int[2][2]; 
	private int[][] meses = {{12,15},{10,25}};
	//private int[][] meses2 = new int[][]{{12,15},{10,25}};
	
	
	
	public Arrays01() {
		inicializaArraySimples();
		inicializaArrayBiDimensional();
	}

	private void inicializaArraySimples() {
		idadeArraySimples[0] = 10;
		idadeArraySimples[1] = 150;
		idadeArraySimples[2] = 40;
		idadeArraySimples[3] = 30;
	}
	private void inicializaArrayBiDimensional() {
		dias[0][0] = 10;
		dias[0][1] = 20;
		dias[1][0] = 11;
		dias[1][1] = 15;

	}
	public void imprime() {
		System.out.println(idadeArraySimples[1]);
		System.out.println(idadeArraySimples[0]);
		System.out.println(idadeArraySimples[2]);
		System.out.println("========================");
		for (int x = 0;x < idadeArraySimples.length; x++ ) {
			System.out.println("indice: " + x + " = " + idadeArraySimples[x]);
		}
	}
	
	public void imprimeForEach() {
		idadeArraySimplesClone = idadeArraySimples.clone();
		System.out.println("========================");
		System.out.println("original: " + idadeArraySimples);
		System.out.println("clone: " +idadeArraySimplesClone);
		System.out.println("========================");
		idadeArraySimplesClone = idadeArraySimples;
		System.out.println("atribuição direta: " +idadeArraySimplesClone);
		System.out.println("========================");
		
		for (int idade : idadeArraySimples) {
			System.out.println("idade: " + idade);
		}
	}
	
	public void imprimirNumeros() {
		System.out.println("========== Numeros ==============");
		int indice = 0 ;
		for (int numero : numeros) {
			
			System.out.println("indice:" + indice++ + " - Numero: " + numero);
		}
	}

	public void imprimirArrayBiDimensional() {
		System.out.println("========== Bi-Dimensional ==============");
		for (int x=0;x<dias.length;x++) {
			System.out.println("endereço de memoria: " + dias[x]);
			for (int y=0;y<dias[x].length;y++) {
				System.out.println(dias[x][y]);
			}
		}
	}
	
	public void imprimirArrayBiDimensionalForEach() {
		System.out.println("========== Bi-Dimensional ForEach ==============");
		for (int[] referencia : dias) {
			System.out.println("endereço de memoria: " + referencia);
			for (int dia : referencia) {
				System.out.println(dia);
			}
		}
	}
}
