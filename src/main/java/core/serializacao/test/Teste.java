package core.serializacao.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import core.serializacao.classes.Aluno;

public class Teste {
	public static void main(String[] args ){
		//serializador();
		deserializador();
	}
	
	private static void serializador() {
		Aluno sergio = new Aluno(1l,"Sergio",55);
		try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("aluno.ser"))){
			oos.writeObject(sergio);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private static void deserializador() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser")) ){
				Aluno al = (Aluno) ois.readObject();
				System.out.println(al);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
