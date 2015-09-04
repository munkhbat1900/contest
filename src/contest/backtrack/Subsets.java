package contest.backtrack;

public class Subsets {
	static int[] a = new int[]{1, 2, 3};
	static int[] solution;
	
	public static void main(String[] args) {
		solution = new int[a.length];
		subset(0, solution);
	}
	
	static void subset(int k, int[] solution) {
		if (k == solution.length) {
			// found solution
			System.out.print("{");
			for (int i = 0; i < solution.length; i++) {
				if (solution[i] == 1) {
					System.out.print(" ");
				    System.out.print(a[i]);
				}
			}
			System.out.println(" }");
			return;
		}
		
		// i = 0 means subset does not contain element, i = 1 subset contains element
		for (int i = 0; i < 2; i++) {
			solution[k] = i;
			subset(k + 1, solution);
		}
	}
}
