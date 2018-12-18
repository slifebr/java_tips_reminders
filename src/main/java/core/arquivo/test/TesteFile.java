package core.arquivo.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TesteFile {

	public static void main(String[] args) {
		
		File file = new File("arquivo.txt");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getParentFile());
		System.out.println(file.getAbsoluteFile());
		file.delete();
		// try with resources
		// dessa forma não precisa fechar os files
		
		try (FileWriter fw = new FileWriter(file,true);
			FileReader fr = new FileReader(file)	){
			
			fw.write("Escrevendo no arquivo e \n Pulando uma linha");
			fw.flush(); 
			
			//======================
			char[] in = new char[500];
			int size = fr.read(in);
			System.out.println("tamanho do arquivo: " + size);
			for (char letra : in) {
				System.out.print(letra);
			}
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
//		try {
//			System.out.println(file.getCanonicalPath());
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		file.delete();
//		try {
//			FileWriter fw = new FileWriter(file,true);
//			
//			fw.write("Escrevendo no arquivo e \n Pulando uma linha");
//			fw.flush(); 
//			fw.close();
//			
//			//======================
//			FileReader fr = new FileReader(file);
//			char[] in = new char[500];
//			int size = fr.read(in);
//			System.out.println("tamanho do arquivo: " + size);
//			for (char letra : in) {
//				System.out.print(letra);
//			}
//			fr.close();
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		

	}

}
