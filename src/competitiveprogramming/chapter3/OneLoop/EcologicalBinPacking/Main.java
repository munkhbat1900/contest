package competitiveprogramming.chapter3.OneLoop.EcologicalBinPacking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author  Avirmed Munkhbat
 * UVa 102 - Ecological Bin Packing
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	//brown, green, clear
	static int[][] bottles;
	static String[] combinations = new String[]{"BCG", "BGC", "CBG", "CGB", "GBC", "GCB"};
	static char[] types = new char[]{'B', 'G', 'C'};
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static int move(int index) {
		int count = 0;
		String combination = combinations[index];
		for (int i = 0; i < 3; i++) {
			// current bin
			char c = combination.charAt(i);
			for (int j = 0; j < 3; j++) {
				// glass type
				char cc = types[j];
				if (c != cc) {
					count += bottles[i][j];
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String s = br.readLine();
			if (s == null || s.equals("")) {
				break;
			}
			
			StringTokenizer st = new StringTokenizer(s);
			bottles = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					bottles[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] moves = new int[6];
			moves[0] = move(0);
			moves[1] = move(1);
			moves[2] = move(2);
			moves[3] = move(3);
			moves[4] = move(4);
			moves[5] = move(5);
			
			int min = Integer.MAX_VALUE;
			int index = 0;
			for (int i = 0; i < 6; i++) {
				if (min > moves[i]) {
					min = moves[i];
					index = i;
				}
			}
			
			pw.printf("%s %d\n", combinations[index], valueOf(moves[index]));
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
