package datastructures.interesting;

/**
 * @author Munkhbat
 *Longest Substring Without Repeating Characters 
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * <br>
 * solution is by someone below. I think it's elegant solution.
 * {@link https://leetcode.com/discuss/57161/java-solution-without-hashmap} 
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) {
			return s.length();
		}
		
		int max = 0;
		// starting index of possible longest substring.
		int ptr = 0;
		for (int i = 1; i < s.length(); i++) {
			int index = s.indexOf(s.charAt(i), ptr);
			if (index < i) {
				ptr = index + 1;
			}
			max = Math.max(max, i - ptr + 1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		LongestSubstring l = new LongestSubstring();
		System.out.println(l.lengthOfLongestSubstring("bcadfa"));
	}
}
