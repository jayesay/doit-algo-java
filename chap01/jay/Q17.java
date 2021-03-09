package chap01.jay;

import java.util.Scanner;

public class Q17 {

	static void npira(int n) {
		for(int i=0; i<n; i++) {
			System.out.printf("%"+(n-i)+"s", " ");//n-i가 0이되면 에러
			for(int j=0; j<i*2+1; j++) {//초기값이 0이라 종료값도 -1.
				System.out.print((i+1)%10);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단 수 입력:");
		int n = sc.nextInt();
		
		npira(n);
	}

}
