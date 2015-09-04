package competitiveprogramming.chapter1.LanguageDetection;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		while (true) {
			String s = sc.next();
			if ("#".equals(s)) {
				break;
			}
			counter++;
			switch(s) {
			case "HELLO" : 
				System.out.println("Case " + counter + ": ENGLISH");
				break;
			case "HOLA" : 
				System.out.println("Case " + counter + ": SPANISH");
				break;

			case "HALLO" : 
				System.out.println("Case " + counter + ": GERMAN");
				break;

			case "BONJOUR" : 
				System.out.println("Case " + counter + ": FRENCH");
				break;

			case "CIAO" : 
				System.out.println("Case " + counter + ": ITALIAN");
				break;

			case "ZDRAVSTVUJTE" : 
				System.out.println("Case " + counter + ": RUSSIAN");
				break;
			default :
				System.out.println("Case " + counter + ": UNKNOWN");
				break;	
			}
		}
		sc.close();
	}
}
