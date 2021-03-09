package chap01.jay;

import java.util.Scanner;

public class Q15 {
	
	static void triangleLB(int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangleLU(int n) {
		for(int i=0; i<n; i++) {
			for(int j=(n-i); j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangleRU(int n) {
		for(int i=1; i<=n; i++) {
			System.out.printf("%"+i+"s","*");//i가 0이면 못넣음
			for(int j=(n-i); j>=1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangleRB(int n) {
		for(int i=0; i<n; i++) {
			System.out.printf("%"+(n-i)+"s","*");//i가 0이면 못넣음
			for(int j=0; j<i; j++) {//일부러 1개 적개 출력
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단 수 입력:");
		int n = sc.nextInt();
		
		triangleLB(n);
		triangleLU(n);
		triangleRU(n);
		triangleRB(n);
		
	}

}
