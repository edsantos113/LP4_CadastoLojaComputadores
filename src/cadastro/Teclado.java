package cadastro;

import java.io.IOException;
import java.util.Scanner;

/**
 * Classe criada para tratar entrada do teclado
 * 
 * @author Werneck
 *
 */
public class Teclado {
	
	private static Scanner teclado = new Scanner(System.in);
	
	//lê float
	public static float getFloat(String campo){
		System.out.print(campo + ": ");
		float valor = teclado.nextFloat();
		teclado.nextLine();
		return valor;
	}
	
	//lê int
	public static int getInt(String campo){
		System.out.print(campo + ": ");
		int valor = teclado.nextInt();
		teclado.nextLine();
		return valor;
	}
	
	//lê long
	public static long getLong(String campo){
		System.out.print(campo + ": ");
		long valor = teclado.nextLong();
		teclado.nextLine();
		return valor;
	}
	
	//lê String
	public static String getString(String campo){
		System.out.print(campo + ": ");
		String valor = teclado.nextLine();
		return valor;
	}
	
	//espera pressionar a tecla enter
	public static void pause(){
		System.out.println("Pressione enter para continuar...");
		try{
			System.in.read();
		}catch(IOException e){
			System.out.println(e.toString());
			System.exit(1);
		}
	}
	
}