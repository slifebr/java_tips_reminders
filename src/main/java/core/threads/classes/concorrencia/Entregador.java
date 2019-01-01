package core.threads.classes.concorrencia;

public class Entregador implements Runnable {
	private ListaMembros lista;

	public Entregador(ListaMembros lista) {
		this.lista = lista;

	}

	@Override
	public void run() {
		String nomeThread = Thread.currentThread().getName();

		System.out.println(nomeThread + " começando a entregar");
		int qtdPendente = lista.getEmailsPendentes();
		boolean aberta = lista.isAberta();
		while (aberta || qtdPendente > 0) {
			try {
				String email = lista.obterEmailMembro();
				if (email != null) {
					System.out.println(nomeThread + "Enviando email para: " + email);
					Thread.sleep(2000);
					System.out.println("Envio para " + email + "concluido");

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aberta = lista.isAberta();
			qtdPendente = lista.getEmailsPendentes();
		}
		System.out.println("Trabalho de entrega finalizado");
	}

}
