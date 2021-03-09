package chap02.jay;

import java.util.Scanner;

public class Q10 {
static final int VMAX = 21;
	
	static class PhyscData{
		String name;
		int height;
		double vision;
		
		public PhyscData(String name, int height, double vision) {
			this.name = name;
			this.height = height;
			this.vision = vision;
		}
		
	}
	
	static double aveHeight(PhyscData[] dat) {//키워 평균값
		double sum =0;
		
		for(int i=0; i<dat.length; i++) {
			sum+= dat[i].height;
		}
		
		return sum/dat.length;
	}
	
	static void distVision(PhyscData[] dat, int[] dist) {//dist 도수분포표..?
		int i=0;
		
		dist[i] = 0;
		for(i=0; i<dat.length; i++) {
			if(dat[i].vision >= 0.0 && dat[i].vision <=VMAX /10.0) { //최대시력이 2.1?
				dist[(int)(dat[i].vision*10)]++; 
				//i번째 시력값에 10을 곱하고 정수형 변환해서 값 1증가?
				//0.1단위로 시력을 구분해서 명수 카운트... 
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PhyscData[] x = { //객체 배열 선언
				new PhyscData("박현규", 162, 0.3),
				new PhyscData("함진아", 173, 0.7),
				new PhyscData("최윤미", 175, 2.0),
				new PhyscData("홍연의", 171, 1.5),
				new PhyscData("이수진", 168, 0.4),
				new PhyscData("김영준", 174, 1.2),
				new PhyscData("박용규", 169, 0.8),
		};
		int[] vdist  = new int[VMAX]; //시력분포
		
		System.out.println("신체 검사 리스트");
		System.out.println("이름\t키\t시력");
		System.out.println("-------------");
		for(int i=0; i<x.length; i++) {
			System.out.printf("%s\t%d\t%1.1f\n", x[i].name, x[i].height, x[i].vision);
		}
		
		System.out.printf("\n평균 키:%5.1fcm\n", aveHeight(x));
		
		distVision(x, vdist);
		
		System.out.println("\n시력 분포");
		for(int i=0; i<VMAX; i++) {
			System.out.printf("%3.1f~:", i/10.0);
			for(int j=0; j<vdist[i]; j++) {
				System.out.print("*");
			}System.out.println();
		}
	}
}
