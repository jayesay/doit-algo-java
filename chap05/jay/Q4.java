package chap05.jay;

import java.util.Scanner;

public class Q4 {

	static void recur2(int n) { //recur와 출력순서가 정반대.
		if(n>0) {
			recur2(n-2);
			System.out.println(n);
			recur2(n-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int x = sc.nextInt();
		
		recur2(x);

	}
	
	//상향식 x=4 일때,
//	recur2(1)
//	System.out.println(1);
//	
//	recur2(2)
//	System.out.println(2);
//	recur2(1)
//	
//	recur2(3)
//	recur2(1)
//	System.out.println(3);
//	recur2(2)
//	
//	recur2(4)
//	recur2(2)
//	System.out.println(4);
//	recur2(3);
	
	
	//하향식 x=4일때, 
	//recur2(4)
//	recur2(2)
//	recur2(0)
//	System.out.println(2);
//	recur2(1)
//	System.out.println(1);
//	System.out.println(4)
//	recur2(3)
//	recur2(1)
//	System.out.println(1);
//	System.out.println(3);
//	recur2(2)
//	recur2(0)
//	System.out.println(2);
//	recur2(1)
//	System.out.println(1);

}
