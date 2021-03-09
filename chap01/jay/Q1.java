package chap01.jay;

import java.util.Scanner;

public class Q1 {
	private Scanner sc = new Scanner(System.in);
	
	public int max4(int a, int b, int c, int d) {
		int max = a;
		if(b>max) max = b;
		if(c>max) max = c;
		if(d>max) max = d;
		return max;
	}
	
	public void max() {
		System.out.println("---최댓값 구하기---");
		System.out.println("4개의 값을 입력해주세요");
		System.out.print("값1:");
		int a = sc.nextInt();
		System.out.print("값2:");
		int b = sc.nextInt();
		System.out.print("값3:");
		int c = sc.nextInt();
		System.out.print("값4:");
		int d = sc.nextInt();
		
		System.out.println("최댓값은 "+max4(a,b,c,d)+"입니다.");
	}
	
	//static을 선언하려면 변수도 같이 static이어야 하는듯
	public static void main(String[] args) {
		new Q1().max();
	}

}
