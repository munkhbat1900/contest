package datastructures;

/**
 * @author Avirmed Munkhbat
 * Find all permutations
 */
public class Permutation {
	
	private void printSolution(int[] perm) {
		for (int x: perm) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public void permutation(int n, int[] perm, boolean[] flags) {
		if (n == perm.length) {
			printSolution(perm);
		} else {
			for (int i = 0; i < perm.length; i++) {
				if (flags[i]) {
					continue;
				}
				perm[n] = i;
				flags[i] = true;
				permutation(n + 1, perm, flags);
				flags[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Permutation perm = new Permutation();
		perm.permutation(0, new int[8], new boolean[8]);
	}
}
