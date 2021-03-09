package chap01.jay;

import java.util.Scanner;

public class Q9 {

	static int sumof(int a, int b) {

		int sum = 0;
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("==a와 b사이의 정수의 합 구하기==");
		System.out.print("a값:");
		int a = sc.nextInt();
		System.out.print("b값:");
		int b = sc.nextInt();

		System.out.println(a + "부터 " + b + "까지의 합:" + sumof(a, b));

	}

}
