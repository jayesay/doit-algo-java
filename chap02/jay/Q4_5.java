package chap02.jay;

public class Q4_5 {

	static void copy(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			a[i] = b[i];
		}
	}
	
	static void rcopy(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			a[a.length-1-i] = b[i];
		}
	}

	public static void main(String[] args) {
		int[] array1 = { 2, 4, 10, 5 };
		int[] array2 = new int[array1.length];
		//배열 카피
		copy(array2, array1);
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
		System.out.println();
		//역순 카피
		rcopy(array2, array1);
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");
		}
	}

}
