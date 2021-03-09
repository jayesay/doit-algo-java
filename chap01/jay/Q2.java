package chap01.jay;

import java.util.Scanner;

public class Q2 {
	private Scanner sc = new Scanner(System.in);

	public void min() {
		System.out.println("---최솟값 구하기---");
		System.out.println("3개의 숫자를 입력해 주세요");
		System.out.print("숫자1:");
		int a = sc.nextInt();
		System.out.print("숫자2:");
		int b = sc.nextInt();
		System.out.print("숫자3:");
		int c = sc.nextInt();
		
		System.out.println("최솟값은 "+min3(a,b,c)+"입니다.");
		
	}
	
	public int min3(int a, int b, int c) {
		int min = a;
		if(b<min) min =b;
		if(c<min) min =c;
		return min;
	}

	public static void main(String[] args) {
		new Q2().min();
	}

}
