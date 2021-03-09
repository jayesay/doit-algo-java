package chap01.jay;

import java.util.Scanner;

public class Q4 {
	// a,b,c 대소 관계의 13종류
	// 1) a = b = c
	// ---------------
	// 2) a > b > c 3) a > c > b
	// 4) b > a > c 5) b > c > a
	// 6) c > a > b 7) c > b > a
	// ----------------------
	// 8) a = b > c 10) b = c > a 12) c = a > b
	// 9) a > b = c 11) b > c = a 13) c > a = b

//생각의 과정
//	public int med3(int a, int b, int c) {
//		if (a == b) {
//			if (a == c) { // 1) a=b=c
//				return b;
//			} else if (a > c) { // 8) a=b>c
//				return b;
//			} else if (a < c) {// 13) c>a=b
//				return a;
//			}
//		} else if (a == c) {
//			if (a > b) {// 12)c=a>b
//				return a;
//			} else if (a < b) {// 11) b>a=c
//				return a;
//			}
//		} else if (b == c) {
//			if (a > b) { // 9) a>b=c
//				return b;
//			} else if (a < b) {// 10) b=c>a
//				return b;
//			}
//		} else if (a > b) {
//			if (b > c) {// 2) a>b>c
//				return b;
//			} else if (c > a) {// 6)c>a>b
//				return a;
//			} else if (a > c) {// a>b,c<b
//				// if(b>c) { // 2) a>b>c
//				// return b;
//				if (c > b) {// 3) a>c>b
//					return c;
//				}
//			}
//		} else if (b > c) { // a<b b>c
//			if (a > c) { // 4) b>a>c
//				return a;
//			} else if (a < c) {// 5)b>c>a
//				return c;
//			}
//		} else if (c > a) {
//			// if(a>b) { // 6) c>a>b
//			// return a;
//			if (b > a) { // b<c and c>a ,b>a : 7) c>b>a
//				return b;
//			}
//		}
//	}

	public static int med3(int a, int b, int c) {
		if (a == b) {// 1) a=b=c, 8) a=b>c, (a<c) 13) c>a=b
			return b;
		} else if (a == c) {// 11) b>a=c 12)c=a>b
			return a;
		} else if (b == c) {// 9) a>b=c 10) b=c>a
			return b;
		} else if (a > b) {
			if (b > c) {// 2) a>b>c
				return b;
			} else if (c > a) {// 6)c>a>b
				return a;
			} else {// a>b and c<b and a<c : 3) a>c>b
				return c;
			}
		} else if (b > c) { // a<b b>c
			if (a > c) { // 4) b>a>c
				return a;
			} else {// (a < c) 5)b>c>a
				return c;
			}
		} else {// (c > a) b<c and c>a ,b>a : 7) c>b>a
			return b;
		}
	}

	public static void main(String[] args) {
		System.out.println("---중앙값 구하기---");
		System.out.println("med3(1,2,3): "+med3(1,2,3)+"입니다.");
		System.out.println("med3(1,3,2): "+med3(1,3,2)+"입니다.");
		System.out.println("med3(2,1,3): "+med3(2,1,3)+"입니다.");
		System.out.println("med3(2,3,1): "+med3(2,3,1)+"입니다.");
		System.out.println("med3(3,2,1): "+med3(3,2,1)+"입니다.");
		System.out.println("med3(3,1,2): "+med3(3,1,2)+"입니다.");
		System.out.println("med3(3,3,2): "+med3(3,3,2)+"입니다.");
		System.out.println("med3(2,1,2): "+med3(2,1,2)+"입니다.");
		System.out.println("med3(3,2,2): "+med3(3,2,2)+"입니다.");
	}

}
