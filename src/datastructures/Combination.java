package datastructures;

public class Combination {
	private int[] arr;
	private int size;
	private int[] sol;
	
	public Combination(int size) {
		arr = new int[5];
		arr[0] = 3;
		arr[1] = 4;
		arr[2] = 5;
		arr[3] = 6;
		arr[4] = 7;
		this.size = size;
		sol = new int[size];
	}
	
	public void solve(int k, int m) {
		if (k == size) {
			for (int i = 0; i < size; i++) {
				System.out.print(sol[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = m; i < arr.length; i++) {
			sol[k] = arr[i];
			solve(k + 1, i + 1);
		}
	}
	
	public static void main(String[] args) {
		Combination c = new Combination(3);
		c.solve(0, 0);
	}
}
