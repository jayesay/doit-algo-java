package chap01.jay;

import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("--n까지의 합 구하기--");
		System.out.print("n 입력:");
		int n = sc.nextInt();
		
		int sum=0;
		String txt = "";
		for(int i=1; i<=n;i++) {
			sum+=i;
			txt += String.valueOf(i);
			if(i!=n) {txt += "+";}
		}
		
		System.out.println(txt +"="+sum);
	
	}

}
