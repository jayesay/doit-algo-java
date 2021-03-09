package chap01.jay;

import java.util.Scanner;

public class Q8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==가우스 공식을 이용한 총합 구하기==");
		System.out.print("숫자 입력:");
		int n = sc.nextInt();
		
		int sum = (1+n)*n/2;
		System.out.println("1부터 "+n+"까지의 총합:"+sum);
		
	}

}
