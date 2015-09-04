package contest.dfs;

/**
 * @author munkhbat
 * 
 */
public class PartialSum {
	private int[] a = new int[]{1,2,4,7};
	private int n = 4;
	private int k = 13;
	
	public boolean partialSum(int i, int sum) {
		if (i == n) return sum == k;
		if (partialSum(i + 1, sum)) return true;
		if (partialSum(i + 1, sum + a[i])) return true;
		return false;
	}
	
	public static void main(String[] args) {
		PartialSum partialSum = new PartialSum();
		System.out.println(partialSum.partialSum(0, 0));
	}
}
