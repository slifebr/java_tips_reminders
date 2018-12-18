package core.arquivo.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TesteBuffer {
	public static void main(String[] args) {

		File  file = new File("arquivo.txt");
			
		file.delete();
		try {
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Escrevendo no arquivo com bufferedWriter");
			bw.newLine();
			bw.write("Pulando uma linha");
			bw.flush(); 
			bw.close();
			
			//======================
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String s = null;
			while((s= br.readLine()) != null) {
				System.out.println(s);
			};
			br.close();
			
//			char[] in = new char[500];
//			int size = fr.read(in);
//			System.out.println("tamanho do arquivo: " + size);
//			for (char letra : in) {
//				System.out.print(letra);
//			}
//			fr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
}
