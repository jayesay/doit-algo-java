package chap05.jay;

import java.util.Scanner;

public class Q3 {

	static int gcdArray(int[] a) {
		int g = 1;
		for(int i=0; i<a.length; i++) {
			if(i==0) g = gcd(a[0], a[i]);
			else g = gcd(a[i], g);
		}
		return g;
	}
	
	static int gcd(int x, int y) {
		if(y==0) return x;
		else return gcd(y, x%y);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 0;

		System.out.println("배열의 최대공약수를 구합니다.");
		while(true) {
			System.out.print("배열의 크기를 입력하세요.(2이상)"); size= sc.nextInt();
			if(size>1) break;
		}
		
		int[] arr = new int[size];
		for(int i=0; i<arr.length; i++) {
			System.out.print("정수를 입력하세요: ");
			arr[i] = sc.nextInt();
		}
		System.out.println("입력하신 배열의 최대공약수는 "+gcdArray(arr)+"입니다.");
	}

}
