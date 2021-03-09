package chap05.jay;

import java.util.Scanner;

public class Q6 {
	static void move(int no, int x, int y) {//no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
		if(no >1) move(no-1, x, 6-x-y); //기둥이 3개라서 6.
		
		System.out.println("원반["+no+"]을 " +getPillar(x)+"기둥에서 "+getPillar(y)+"기둥으로 옮김");
		
		if(no>1) move(no-1, 6-x-y, y);
	}
	
	static String getPillar(int n) {
		switch(n) {
		case 1: return "A"; 
		case 2: return "B"; 
		case 3: return "C"; 
		default : return "";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("하노이의 탑");
		System.out.print("원반 개수 :");
		int n = sc.nextInt();
		
		move(n, 1, 3); //1번 기둥에서 3번기둥으로 옮기는 작업
	}
}
