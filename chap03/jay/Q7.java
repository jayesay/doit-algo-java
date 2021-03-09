package chap03.jay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PhyscData[] x = {
				new PhyscData("이나령", 162, 0.3), 
				new PhyscData("유지훈", 168, 0.4),
				new PhyscData("김한결", 169, 0.8), 
				new PhyscData("홍준기", 171, 1.5), 
				new PhyscData("전서현", 173, 0.7),
				new PhyscData("이호연", 174, 1.2), 
				new PhyscData("이수민", 175, 2.0)
		};
		
		System.out.print("시력이 몇인 사람을 찾고 있나요?");
		double findVis = sc.nextDouble();
		
		int idx = Arrays.binarySearch(x, new PhyscData("",0,findVis), new VisionComparator());
		
		if(idx <0) {
			System.out.println("찾고 있는 사람이 없습니다.");
		}else {
			System.out.println("x["+idx+"]에 있습니다.");
			System.out.println("찾은 데이터 : " + x[idx]);
		}
		
	}

}

class PhyscData{
	private String name;
	private int height;
	private double vision;
	
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
	public double getVision() {return vision;}
	public void setVision(double vision) {this.vision = vision;	}

	@Override
	public String toString() {
		return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
	
}

class VisionComparator implements Comparator<PhyscData>{
	public int compare(PhyscData d1, PhyscData d2) {
		if(d1.getVision()>d2.getVision()) {
			return 1;
		}else if(d1.getVision()<d2.getVision()) {
			return -1;
		}else {
			return 0;
		}
	}
	
}