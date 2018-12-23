package core.serializacao.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import core.serializacao.classes.Aluno;
import core.serializacao.classes.Turma;

public class Teste {
	public static void main(String[] args ){
		serializador();
		System.out.println("=================================");
		desserializador();
	}
	
	private static void serializador() {
		Turma  turma = new Turma("Tips And Reminders");
		Aluno sergio = new Aluno(1l,"Sergio",55,"secret1234",9,turma);
		try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("aluno.ser"))){
			oos.writeObject(sergio);
			System.out.println(sergio);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private static void desserializador() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser")) ){
				Aluno al = (Aluno) ois.readObject();
				System.out.println(al);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
