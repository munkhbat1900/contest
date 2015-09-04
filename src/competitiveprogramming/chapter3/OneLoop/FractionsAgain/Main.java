package competitiveprogramming.chapter3.OneLoop.FractionsAgain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Avirmed Munkhbat
 * UVA 10976 - Fractions Again?!
 * solution for x and y is as follows. x : arbitrary positive integer y = (k * x)/(t - k)
 * so x must be bigger than k;
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int k;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			k = Integer.parseInt(str);
			int x = k + 1;
			List<Integer> xs = new ArrayList<Integer>();
			List<Integer> ys = new ArrayList<Integer>();
			while (true) {
				if ((k * x) % (x - k) == 0) {
					int y = (k * x) / (x -k);
					if (x > y) {
						break;
					}
					xs.add(valueOf(x));
					ys.add(valueOf(y));
				} else if ((k * x) < 2 * (x - k)) {
					// impossible to divide
					break;
				}
				x++;
			}
			if (xs.size() == 0) {
				continue;
			}
			pw.println(xs.size());
			for (int i = 0; i < xs.size(); i++) {
				pw.printf("1/%d = 1/%d + 1/%d\n", valueOf(k), ys.get(i), xs.get(i));
			}
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
