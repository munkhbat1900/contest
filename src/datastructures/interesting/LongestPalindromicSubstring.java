package datastructures.interesting;

/**
 * @author Munkhbat
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len <= 1) {
			return s;
		}
		// i is length of palidromic substring
		for (int i = len - 1; i >= 2; i--) {
			// j is starting index of possible substring whose length is i.
			for (int j = 0; j < len - i; j++) {
				// check palindromic for each substring
				boolean b = true;
				for (int k = j; k < i / 2; k++) {
					if (s.charAt(k) != s.charAt(i + j - k)) {
						b = false;
						break;
					}
				}
				// it is palindromic;
				if (b) {
					return s.substring(j, i + j + 1);
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome("ddabcbaff"));
	}
}
