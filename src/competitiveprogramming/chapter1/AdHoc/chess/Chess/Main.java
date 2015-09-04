package competitiveprogramming.chapter1.AdHoc.chess.Chess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 278 - Chess
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			switch(str) {
			case "r" :
			case "Q" : 
				bw.write(Math.min(n, m) + "\n");
				break;
			case "k" :
				bw.write((n * m + 1) / 2 + "\n");
				break;
			case "K" :
				bw.write(((n + 1) / 2) * ((m + 1) / 2) + "\n");
				break;
			}
			
			t--;
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
