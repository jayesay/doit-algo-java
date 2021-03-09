package chap02.jay;

public class Q2 {
	public void swap(int[] array, int idx1, int idx2) {
		int tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}

	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public void reverse(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			print(array);
			swap(array, i, array.length - 1 - i);
			System.out.println("a[" + i + "]과(와) a[" + (array.length - 1 - i) + "]를 교환합니다.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 5, 10, 73, 2, -5, 42 };
		Q2 q = new Q2();
		q.reverse(array);
		q.print(array);
		System.out.println("역순 정렬을 마쳤습니다.");
	}

}
