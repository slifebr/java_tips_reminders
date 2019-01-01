package core.threads.test;

import javax.swing.JOptionPane;

import core.threads.classes.concorrencia.Entregador;
import core.threads.classes.concorrencia.ListaMembros;

public class TesteEntregador {

	public static void main(String[] args) {
		ListaMembros lista = new ListaMembros();
		Thread t1 = new Thread( new Entregador(lista), "Entregador-1");
		Thread t2 = new Thread( new Entregador(lista), "Entregador-2");
		t1.start();
		t2.start();
		
		while(true) {
			String email = JOptionPane.showInputDialog("Digite o email do membro");
			if (email == null || email.isEmpty()) {
				lista.fecharLista();
				break;
			}
			lista.adicionarEmailMembro(email);
		}
		System.out.println("t1-state " + t1.getState().toString() + " - " + t1.isAlive());
		System.out.println("t2-state " + t2.getState().toString() + " - " + t2.isAlive());

		System.exit(0);

	}

	
}
