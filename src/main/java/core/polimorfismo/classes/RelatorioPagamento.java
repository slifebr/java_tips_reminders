package core.polimorfismo.classes;

public class RelatorioPagamento {
	public void relatorioPagamentoGerente(Gerente gerente) {
		System.out.println("Gerando relatorio de pagamento de Gerente");
		gerente.calcularPagamento();
		System.out.println("Nome: " + gerente.getNome());
		System.out.println("Salário: " + gerente.getSalario());
		System.out.println("===================================");
	}
	
	public void relatorioPagamentoVendedor(Vendedor vendedor) {
		System.out.println("Gerando relatorio de pagamento de Vendedor");
		vendedor.calcularPagamento();
		System.out.println("Nome: " + vendedor.getNome());
		System.out.println("Salário: " + vendedor.getSalario());
		System.out.println("===================================");
	}	
	
	// método com parametro polimorfico
	public void relatorioPagamentoPolimorfo(Funcionario funcionario) {
		String cargoFuncionario = "Vendedor";
		if (funcionario instanceof Gerente) {
			cargoFuncionario = "Gerente";
		}
		System.out.println("Gerando relatorio de pagamento de "+ cargoFuncionario);
		funcionario.calcularPagamento();
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Salário: " + funcionario.getSalario());
		
		if (funcionario instanceof Gerente) {
			// forcando um cast explicito para gerente
			System.out.println("valor pnl do gerente: " + ((Gerente) funcionario).getPnl());
		}
		if (funcionario instanceof Vendedor) {
			System.out.println("Total de vendas: " + ((Vendedor)funcionario).getTotalVendas());
		}
		System.out.println("===================================");
	}	
	
}
