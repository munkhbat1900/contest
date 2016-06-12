package competitiveprogramming.chapter2.linearDataStructure.BitManipulation.OneLittleEndian;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Avirmed Munkhbat
 *
 * UVA 594 - One Little, Two Little, Three Little Endians
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	static int n;
	
	public static void main(String[] args) throws IOException {
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			n = Integer.parseInt(str);
			int ans = 0;
			for (int i = 0; i < 4; i++) {
				ans = (ans << 8) | ((n >> (8 * i)) & 255);
			}
			pw.printf("%d converts to %d\n", Integer.valueOf(n), Integer.valueOf(ans));
			//pw.printf("%d converts to %d\n", Integer.valueOf(n), Integer.valueOf(Integer.reverseBytes(n)));
		}
		pw.flush();
		pw.close();
		br.close();
	}
}
