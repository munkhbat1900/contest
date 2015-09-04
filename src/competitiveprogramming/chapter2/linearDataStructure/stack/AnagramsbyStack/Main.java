package competitiveprogramming.chapter2.linearDataStructure.stack.AnagramsbyStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Avirmed Munkhbat
 * UVA 732 - Anagrams by Stack
 * implemented not yet.
 */
public class Main {
	static String source;
	static String target;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static void dfs(String from, String to, Deque<Character> stack, String path, int n) {
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			source = br.readLine();
			if (source == null || "".equals(source)) {
				break;
			}
			target = br.readLine();
			pw.println("[");
			if (target.length() == source.length()) {
				dfs(source, "", new ArrayDeque<Character>(), "", 0);
			}
			pw.println("]");
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
