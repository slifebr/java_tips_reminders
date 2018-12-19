package core.arquivo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TesteStream {

	public static void main(String[] args) {
		File dir = new File("pasta");
		dir.mkdir();
		//gravador(dir);
		leitor(dir);
		
	}
	
	public static void gravador(File dir) {
		byte[] dados = {65,66,67,68,69,70};

		try(FileOutputStream grava = new FileOutputStream(dir.getPath()+"\\stream.txt",true)){
			grava.write(dados);
			System.out.println("Dados gravados com sucesso");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void leitor(File dir) {
		try(FileInputStream leitor = new FileInputStream(dir.getPath()+"\\stream.txt")){
			int dados;
			while ((dados = leitor.read()) != -1) {
				byte b = (byte)dados;
				System.out.println(" " + b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
