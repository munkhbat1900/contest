package competitiveprogramming.chapter2.linearDataStructure.BrokenKeyboard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * @author Avirmed Munkhbat
 * 11988 - Broken Keyboard (a.k.a. Beiju Text)
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		while (true) {
			String line = br.readLine();
			if (line == null || "".equals(line)) {
				break;
			}
			
			LinkedList<String> beijuText = new LinkedList<String>();
			StringBuilder sb = new StringBuilder();
			boolean isLast = true;
			for (int i = 0; i  < line.length(); i++) {
				char c = line.charAt(i);
				if (c != '[' && c != ']') {
					sb.append(c);
				} else {
					if (isLast) {
						beijuText.addLast(sb.toString());
					} else {
						beijuText.addFirst(sb.toString());
					}
					sb = new StringBuilder();
					if (c == '[') {
						isLast = false;
					} else if (c == ']') {
						isLast = true;
					}
				}
			}
			
			// last element
			if (isLast) {
				beijuText.addLast(sb.toString());
			} else {
				beijuText.addFirst(sb.toString());
			}
			
			for (String str : beijuText) {
				pw.print(str);
			}
			pw.println();
		}
		
		pw.flush();
		br.close();
		pw.close();
	}
}
