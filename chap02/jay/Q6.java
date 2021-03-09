package chap02.jay;

import java.util.Scanner;

public class Q6 {

	static int cardConv(int x, int r, char[] d) {
		int digits = d.length-1;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits--] = dchar.charAt(x%r); //나눗셈 나머지를 정해진 문자열로 변환.
			x /=r; //나눗셈을 몫이 0이 될때까지 반복
		}while(x!=0);
		return digits;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no;
		int cd;
		int dno;
		int retry;
		char[] cno = new char[32];
		
		System.out.println("10진수를 기수 변환합니다.");
		do {
			do { //x값 입력 -> no
				System.out.print("변환하는 음이 아닌 정수:");
				no = sc.nextInt();
			}while(no <0);
			
			do {//r값 입력 -> cd
				System.out.print("어떤 진수로 변환할까요? (2~36) :");
				cd = sc.nextInt();
			}while(cd<2 || cd>36);
			
			dno = cardConv(no, cd, cno);
			
			System.out.print(cd+"진수로는 ");
			for(int i=dno; i<cno.length; i++) {
				System.out.print(cno[i]); //차례로 출력
			}System.out.println("입니다.");
			
			System.out.print("한 번 더 할까요? (1.예/0.아니오) :");
			retry = sc.nextInt();
		}while(retry ==1);
	}
}
