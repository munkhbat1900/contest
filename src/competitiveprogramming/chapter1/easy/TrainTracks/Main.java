package competitiveprogramming.chapter1.easy.TrainTracks;

import java.util.Scanner;

/**
 * @author munkhbat
 * UVA 11586 - Train Tracks
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while (t > 0) {
			String str = sc.nextLine();
			int mCounter = 0;
			int fCounter = 0;
			//System.out.println("str = " + str);
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'M') {
					mCounter++;
				} else if (str.charAt(i) == 'F') {
					fCounter++;
				}
			}
			if (mCounter > 1 && mCounter == fCounter) {
				System.out.println("LOOP");
			} else {
				System.out.println("NO LOOP");
			}
			t--;
		}
		sc.close();
	}
}
