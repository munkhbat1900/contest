package contest.backtrack;

public class Permutation {
	private static int[] a = new int[]{1, 2, 3};
	
	public static void main(String[] args) {
		permute(0);
	}
	
	private static void swap(int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void permute(int i) {
		if (i == a.length) {
			for (int k = 0; k < a.length; k++) {
				System.out.print(a[k]);
			}
			System.out.println();
		}
		for (int j = i; j < a.length; j++) {
			swap(i, j);
			permute(i + 1);
			swap(j, i);
		}
	}
}
