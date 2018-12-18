package core.formatacao.test;

import java.text.NumberFormat;
import java.util.Locale;

public class TestFormatacaoNumero {

	public static void main(String[] args) {
		Locale lJP = Locale.US;
		Locale lBR = Locale.FRANCE;
		
		NumberFormat[] nfs = new NumberFormat[4];
		nfs[0] = NumberFormat.getInstance();
		nfs[1] = NumberFormat.getInstance(lBR);
		nfs[2] = NumberFormat.getCurrencyInstance();
		nfs[3] = NumberFormat.getCurrencyInstance(lBR);

		float valor = 1235.5545f;
		
		for (NumberFormat nf :  nfs) {
			System.out.println(nf.format(valor));
		}
		
		
	}

}
