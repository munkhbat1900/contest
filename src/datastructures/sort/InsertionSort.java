package datastructures.sort;

/**
 * @author Munkhbat
 * Insertion sort algorithm
 */
public class InsertionSort {
	public void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j;
			int data = a[i];
			for (j = i; j > 0 && data < a[j - 1]; j--) {
				a[j] = a[j - 1];
			}
			a[j] = data;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {67,123,4576,9,2,1,3,7567,67};
		InsertionSort sort = new InsertionSort();
		sort.insertionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
