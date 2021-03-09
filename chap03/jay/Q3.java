package chap03.jay;

import java.util.Scanner;

public class Q3 {

	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count =0;
		for(int i=0; i<n; i++) {
			if(a[i]==key) {
				idx[count++] = i;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("요소의 갯수 : ");
		int num = sc.nextInt();
		
		int[] array = new int[num];
		int[] idxArray = new int[num];
		
		for(int i=0; i<num; i++) {
			System.out.print((i+1)+"번째 요소:");
			array[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값:");
		int findNum = sc.nextInt();
		
		int result = searchIdx(array, num, findNum, idxArray);
		System.out.println("결과값:"+result);
		System.out.print("idxArray: ");
		for(int i=0; i<result; i++) {
			System.out.print(idxArray[i] +" "); //인덱스
		}

	}

}
