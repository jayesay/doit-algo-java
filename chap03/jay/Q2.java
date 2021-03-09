package chap03.jay;

import java.util.Scanner;

public class Q2 {

	static int seqSearchSen(int[] a, int n, int key) {
		a[n] = key;
		
		System.out.print("   | ");
		for (int i = 0; i < n; i++) {
			System.out.printf("%2s ", i);
		}
		System.out.println();
		System.out.print("---┼--");
		for (int i = 0; i < n; i++) {
			System.out.print("---");
		}
		System.out.println();
		
		int result = -1;
		
		for (int j = 0; j < n; j++) {
			System.out.print("   | ");
			for (int i = 0; i < n; i++) {
				if (i ==j) {
					System.out.print(" * ");
				}
				System.out.print("   ");
			}
			System.out.println();

			System.out.print("  " + j + "| ");
			for (int i = 0; i < n; i++) {
				System.out.printf("%2d ", a[i]);
			}
			System.out.println();
			if(a[j]==key) {
				result = j;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("요소 개수 : ");
		int num = sc.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]:");
			x[i] = sc.nextInt();
		}

		System.out.print("검색할 값: ");
		int ky = sc.nextInt();

		int idx = seqSearchSen(x, num, ky);

		if (idx == -1) {
			System.out.println("그 값의 요소가 없습니다.");
		} else {
			System.out.println(ky + "은(는) x[" + idx + "]에 있습니다");
		}
	}
}
