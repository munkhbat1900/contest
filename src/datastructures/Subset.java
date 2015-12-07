package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * print all subsets. using backtrack.
 * */
public class Subset {
	private int[] arr;
	private List<Integer> solutions;
	
	public Subset() {
		arr = new int[5];
		arr[0] = 3;
		arr[1] = 4;
		arr[2] = 5;
		arr[3] = 6;
		arr[4] = 7;
		solutions = new ArrayList<>();
	}
	
	private void print() {
		System.out.print("[");
		for (Integer i : solutions) {
			System.out.print(arr[i.intValue()] + " ");
		}
		System.out.println("]");
	}
	
	private void subsets(int i) {
		if (i == arr.length) {
			print();
			return;
		}
		
		subsets(i + 1);
		
		solutions.add(Integer.valueOf(i));
		subsets(i + 1);
		solutions.remove(solutions.size() - 1);
	}
	
	public static void main(String[] args) {
		Subset subset = new Subset();
		subset.subsets(0);
	}
}
