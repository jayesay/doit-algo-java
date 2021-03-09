package chap01.jay;

import java.util.Scanner;

public class Q3 {
	private Scanner sc = new Scanner(System.in);

	public void min() {
		System.out.println("---최솟값 구하기---");
		System.out.println("4개의 숫자를 입력해 주세요");
		System.out.print("숫자1:");
		int a = sc.nextInt();
		System.out.print("숫자2:");
		int b = sc.nextInt();
		System.out.print("숫자3:");
		int c = sc.nextInt();
		System.out.print("숫자4:");
		int d = sc.nextInt();

		System.out.println("최솟값은 " + min4(a, b, c, d) + "입니다.");

	}

	public int min4(int a, int b, int c, int d) {
		int min = a;
		if (b < min)
			min = b;
		if (c < min)
			min = c;
		if (d < min)
			min = d;
		return min;
	}

	public static void main(String[] args) {
		new Q3().min();
	}

}
