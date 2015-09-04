package competitiveprogramming.chapter2.linearDataStructure.STLAlgorithmsJavaCollections.SearchingQuickly;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Avirmed Munkhbat
 * UVA 123 - Searching Quickly
 * Here I was receiving Runtime error. So I used try-catch block. And it has accepted.
 * I don't know why. Maybe input doesn't follow specification in the problem description.
 */
public class Main {
	static List<String> ignoreList = new ArrayList<String>();
	static List<String> statements = new ArrayList<String>();
	static List<String> answer = new ArrayList<String>();

	static boolean isIgnore(String str) {
		return Collections.binarySearch(ignoreList, str) >= 0;
	}

	static void addStatement(String[] str, int index) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			if (i != index) {
				sb.append(str[i]);
			} else {
				sb.append(str[i].toUpperCase());
			}
			if (i < str.length - 1) {
				sb.append(" ");
			}
		}
		answer.add(sb.toString());
	}

	static int findUpperCaseWord(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if (!str[i].equals(str[i].toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		boolean isIgnore = true;
		ignoreList = new ArrayList<String>();
		statements = new ArrayList<String>();
		answer = new ArrayList<String>();

		while (true) {
			try {
				String line = br.readLine().toLowerCase();
				if (line == null || "".equals(line)) {
					break;
				}
				if ("::".equals(line)) {
					isIgnore = false;
					continue;
				}

				if (isIgnore) {
					ignoreList.add(line);
				} else {
					statements.add(line);
				}
			} catch(Exception e) {
				break;
			}
		}

		Collections.sort(ignoreList);

		for (String str : statements) {
			String[] words = str.split(" ", 0);
			for (int i = 0; i < words.length; i++) {
				if (!isIgnore(words[i])) {
					addStatement(words, i);
				}
			}
		}

		Collections.sort(answer, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] words1 = o1.split(" ", 0);
				String[] words2 = o2.split(" ", 0);
				int index1 = findUpperCaseWord(words1);
				int index2 = findUpperCaseWord(words2);
				return words1[index1].compareTo(words2[index2]);
			}
		});

		for (String statement : answer) {
			pw.println(statement);
		}

		pw.flush();
		br.close();
		pw.close();
	}
}
