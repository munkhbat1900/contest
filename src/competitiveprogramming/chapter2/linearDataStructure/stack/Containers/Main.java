package competitiveprogramming.chapter2.linearDataStructure.stack.Containers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Avirmed Munkhbat
 * UVA 1062 - Containers
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static String line;
	static List<Deque<Character>> stacks;
	
	static void add(char c) {
		for (Deque<Character> stack : stacks) {
			if (stack.peek().charValue() >= c) {
				stack.push(Character.valueOf(c));
				return;
			}
		}
		Deque<Character> s= new ArrayDeque<Character>();
		s.push(Character.valueOf(c));
		stacks.add(s);
	}
	
	public static void main(String[] args) throws IOException {
		int count = 0;
		while (true) {
			line = br.readLine();
			if ("end".equals(line)) {
				break;
			}
			count++;
			stacks = new ArrayList<Deque<Character>>();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if (stacks.isEmpty()) {
					Deque<Character> s= new ArrayDeque<Character>();
					s.push(Character.valueOf(c));
					stacks.add(s);
					continue;
				} else {
					// push onto existing stack
					add(c);
				}
			}
			
			pw.printf("Case %d: %d\n", Integer.valueOf(count), Integer.valueOf(stacks.size()));
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
