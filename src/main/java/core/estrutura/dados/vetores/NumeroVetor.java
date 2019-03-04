package core.estrutura.dados.vetores;

import java.util.Arrays;

public class NumeroVetor {

	private Integer[] numeros;
	private int tamanho;

	public NumeroVetor(int length) {
		this.numeros = new Integer[length];
	}

	public void adiciona(Integer numero) {
		if (this.numeros.length == this.tamanho) {
			expandeVetor();
		}
		this.numeros[this.tamanho] = numero;
		this.tamanho++;
	}

	public void adicionaEntreMaiorMenorComForReversivo(Integer numero) {

		if (this.numeros.length == this.tamanho) {
			expandeVetor();
		}

		Integer[] arrayAux = new Integer[numeros.length + 1];

		sort();

		for (int i = this.tamanho - 1; i >= 0; i--) {

			if (numero >= 0 && this.numeros[i] >= numero) {
				arrayAux[i + 1] = this.numeros[i];
				if (i == 0)
					arrayAux[i] = numero;
			} else if (numero >= 0) {
				arrayAux[i + 1] = numero;
				arrayAux[i] = this.numeros[i];
				numero = -1; // determina que o numero foi inserido
			} else {
				arrayAux[i] = this.numeros[i];
			}

		}
		this.numeros = arrayAux;
		this.tamanho++;
	}

	public void adicionaEntreMaiorMenorComFor(Integer numero) {

		if (this.numeros.length == this.tamanho) {
			expandeVetor();
		}

		Integer[] arrayAux = new Integer[numeros.length + 1];

		sort();

		for (int i = 0; i <= this.tamanho - 1; i++) {

			if (numero >= 0 && this.numeros[i] <= numero) {
				arrayAux[i] = this.numeros[i];
				if (i == tamanho-1) {
					arrayAux[i+1] = numero;
					numero = -1;
				}
			} else if (numero >= 0) {
				arrayAux[i] = numero;
				arrayAux[i+1]  = this.numeros[i];
				numero = -1; // determina que o numero foi inserido
			} else {
				arrayAux[i+1] = this.numeros[i];
			}

		}
		this.numeros = arrayAux;
		this.tamanho++;
	}

	

	public void adicionaEntreMaiorMenor(Integer numero) {
		sort();
		if (this.numeros.length == this.tamanho) {
			expandeVetor();
		}

		Integer[] arrayAux = new Integer[numeros.length + 1];
		int posicao = this.tamanho;
		int iniPos = 0;
		int fimPos;
		boolean procura = true;
		int limite = 0;
		while (procura) {
			fimPos = achaMetade(iniPos, posicao);

			if (fimPos == 0 || this.numeros[fimPos] <= numero) {
				if (fimPos == 0 || fimPos + 1 == tamanho || this.numeros[fimPos + 1] >= numero) {
					arrayAux = copiar(numeros, 0, fimPos + 1, arrayAux, 0);
					if (iniPos == fimPos) {
						arrayAux[fimPos] = numero;
						arrayAux = copiar(numeros, fimPos, numeros.length, arrayAux, fimPos + 1);
					} else {
						arrayAux[fimPos + 1] = numero;
						arrayAux = copiar(numeros, fimPos + 1, numeros.length, arrayAux, fimPos + 2);
					}
					numeros = arrayAux;
					procura = false;
					break;
				} else {
					iniPos = fimPos;
				}
			} else {
				posicao = fimPos;
			}

			limite++;

			if (limite > tamanho) {
				procura = false;
				System.out.println("saiu pelo limite");
			}
		}
		this.tamanho++;
	}

	private Integer[] copiar(Integer[] origem, int iniPos, int fimPos, Integer[] destino, int iniDest) {
		for (int i = iniPos; i < fimPos; i++) {
			destino[iniDest] = origem[i];
			iniDest++;
		}
		return destino;
	}

	private int achaMetade(int iniPos, int tam) {
		int retorno = (tam - iniPos) / 2 + iniPos;
		return retorno;
	}

	public Integer[] getNumeros() {
		return numeros;
	}

	public void sort() {
		Arrays.sort(numeros, 0, tamanho);
	}

	public void bubleSort() {
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] == null)
				break;
			Integer aux;
			for (int y = i + 1; y < numeros.length; y++) {
				if (numeros[y] == null)
					break;
				if (numeros[i] > numeros[y]) {
					aux = numeros[i];
					numeros[i] = numeros[y];
					numeros[y] = aux;
				}
			}
		}
	}

	private void expandeVetor() {
		Integer[] aux = new Integer[this.numeros.length * 2];
		System.arraycopy(this.numeros, 0, aux, 0, this.numeros.length);
		this.numeros = new Integer[aux.length];
		System.arraycopy(aux, 0, this.numeros, 0, aux.length);
	}

	public int getTamanho() {
		return tamanho;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		String pipe = "";

		for (Integer numero : numeros) {
			if (numero == null)
				break;

			sb.append(pipe);
			sb.append(numero.toString());
			pipe = ",";

		}
		sb.append("]");
		return sb.toString();
	}

	public String toString(Integer[] numeros) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		String pipe = "";

		for (Integer numero : numeros) {
			if (numero == null)
				break;

			sb.append(pipe);
			sb.append(numero.toString());
			pipe = ",";

		}
		sb.append("]");
		return sb.toString();
	}
}
