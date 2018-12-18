package core.polimorfismo.test;

import core.polimorfismo.classes.Funcionario;
import core.polimorfismo.classes.Gerente;
import core.polimorfismo.classes.RelatorioPagamento;
import core.polimorfismo.classes.Vendedor;

public class TestePolimorfismo {

	public static void main(String[] args) {
		
		//------------------------------------------------------
		// sem polimorfismo
		//------------------------------------------------------
		Gerente g = new Gerente("Sergio", 10000, 5000);
		Vendedor v = new Vendedor("João", 2500, 20000);
		
		RelatorioPagamento rp = new RelatorioPagamento();
		
		//rp.relatorioPagamentoGerente(g);
		//rp.relatorioPagamentoVendedor(v);

		//------------------------------------------------------
		// com polimorfismo
		//------------------------------------------------------
		
		rp.relatorioPagamentoPolimorfo(g);
		rp.relatorioPagamentoPolimorfo(v);
		
	}

}
