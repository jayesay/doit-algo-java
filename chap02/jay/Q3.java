package chap02.jay;

public class Q3 {
	public int sumOf(int[] a) {
		int sum = 0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] array = {14,5,2,20,36,17,11};
		System.out.println("합계는 "+new Q3().sumOf(array)+"입니다.");
	}

}
