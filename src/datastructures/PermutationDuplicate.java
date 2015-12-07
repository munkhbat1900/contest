package datastructures;

/**
 * @author Munkhbat
 * find all permutations. there are duplications in sequence. ex : "aab"
 */
public class PermutationDuplicate {
	/**
	 * assign a different number to same things.
	 */
	private int[] numbers;
	
	private void printSolution(int[] perm, int[] data) {
		for (int x: perm) {
			System.out.print(data[x] + " ");
		}
		System.out.println();
	}
	
	private void permutate(int n, int[] perm, boolean[] flags, int[] data) {
		if (n == perm.length) {
			printSolution(perm, data);
		} else {
			for (int i = 0; i < perm.length; i++) {
				if (flags[i]) {
					continue;
				}
				boolean b = false;
				for (int j = 0; j < n; j++) {
					if (data[perm[j]] == data[i] && numbers[perm[j]] > numbers[i]) {
						b = true;
						break;
					}
				}
				if (b) {
					continue;
				}
				flags[i] = true;
				perm[n] = i;
				permutate(n + 1, perm, flags, data);
				flags[i] = false;
			}
		}
	}
	
	public void solve(int[] a) {
		//Arrays.sort(a);
		System.out.println(a[0] + "" + a[1] + "" + a[2]);
		numbers = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int k = 0;
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					k++;
				}
			}
			numbers[i] = k;
		}
		System.out.println(numbers[0] + "" + numbers[1] + "" + numbers[2] + "" + numbers[3]);
		permutate(0, new int[a.length], new boolean[a.length], a);
	}
	
	public static void main(String[] args) {
		PermutationDuplicate pd = new PermutationDuplicate();
		pd.solve(new int[]{1, 1, 2, 2});
	}
}
