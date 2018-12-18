package core.polimorfismo.test;

import java.util.Scanner;

import core.polimorfismo.classes.poi.ArquivoDAOImpl;
import core.polimorfismo.classes.poi.DatabaseDAOImpl;
import core.polimorfismo.classes.poi.GenericDAO;
import core.polimorfismo.classes.poi.TipoDestino;

public class TesteDAO {
	public static void main(String[] args) {
		String escolha = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite (1) para salvar no banco \n(2) para salvar em arquivo");
		escolha = scanner.next();
		scanner.close();
		System.out.println("escolha:" + escolha);

		TipoDestino td;

		if (escolha.equals("1"))
			td = TipoDestino.BANCO;
		else
			td = TipoDestino.Arquivo;

		GenericDAO dao = td.DAOFactory();
		dao.save();
	}
}
