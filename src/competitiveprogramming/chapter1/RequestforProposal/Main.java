package competitiveprogramming.chapter1.RequestforProposal;

import java.util.Scanner;

/**
 * @author Avirmed Munkhbat
 * UVA 10141 - Request for Proposal
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		while (true) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			if (n == 0 && p == 0) {
				break;
			}
			sc.nextLine();
			
			if (counter > 0) {
				System.out.println();
			}
			
			counter++;
			for (int i = 0; i < n; i++) {
				sc.nextLine();
			}
			float max = -1000000000.0f;
			float minPrice = 1000000000.0f;
			String ans = "";
			for (int i = 0; i < p; i++) {
				String prop = sc.nextLine();
				float d = sc.nextFloat();
				int r = sc.nextInt();
				sc.nextLine();
				for (int k = 0; k < r; k++) {
					sc.nextLine();
				}

				float compliance = (float)r / p;
				
				if ((max < compliance) || (max == compliance && minPrice > d)) {
					ans = prop;
					max = compliance;
					minPrice = d;
				} 
			}
			System.out.println("RFP #" + counter);
			System.out.println(ans);
		}
		sc.close();
	}
}
