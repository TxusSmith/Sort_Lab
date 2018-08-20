package model;

import java.io.*;

public class MainClass {
	
	private static String arraySize;	
	private static byte dataTipe;	
	private static byte howItWillBe;	
	private static byte aleatoryPorcentage;	
	
	public MainClass() {
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("ingresar numero de elementos a ordenar");
		arraySize = in.readLine();
		
		System.out.println("desea configurar el tipo de datos a ordenar[Y/N]");
		String answer = in.readLine();
		
		if(answer.equals("y") || answer.equals("Y")) {
			System.out.println("que tipo de dato quiere generar \n "
					+ "[{0}Byte, {1}Short, {2}Int, {3}Long, {4}Float, {5}Double]");
		
			answer = in.readLine();
			dataTipe = Byte.parseByte(answer);
			
			System.out.println("como desea que sean generado los valores \n"
					+ "[{0}Ord. ascendente, {1}ord. descendente, {2}aleatorio, {3}dar porcentaje de aleatoriedad]");
			
			answer = in.readLine();
			howItWillBe = Byte.parseByte(answer);
			
			if(howItWillBe == 3) {
				System.out.println("ingrese el porcetaje de aleatoriedad");
				answer = in.readLine();
				aleatoryPorcentage = Byte.parseByte(answer);
			}	
			
		}
	}

}
