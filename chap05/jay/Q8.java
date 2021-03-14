package chap05.jay;

public class Q8 { 
	static boolean[] flag_a = new boolean[8]; //각 행에 퀸을 배치했는지 체크
	static boolean[] flag_b = new boolean[15]; // / 대각선 방향으로 퀸을 배치했는지 체크 /대각선 줄이 총 15개 i+j 로 구함
	static boolean[] flag_c = new boolean[15]; // ↖ 대각선 방향으로 퀸을 배치했는지 체크 i-j+7로 구함
	static int[] pos = new int[8]; //각열의 퀸의 위치
	
	static void print() {
		for(int i=0; i<8;  i++) {
			for(int k=0; k<8; k++) {
				if(pos[k]==i) System.out.print("■ "); //pos[k]는 x좌표
				else System.out.print("□ ");
			}System.out.println();
		}System.out.println();
		System.out.println("=================");
	}
	
	static void set(int i) {//퀸 배치하기
		for(int j=0; j<8; j++) {
			if(flag_a[j] == false && //j행에 퀸을 배치하지 않았으면
					flag_b[i+j] == false && // 대각선 /에 배치 안했으면
					flag_c[i-j+7] ==false ) {  //대각선 ↖에 배치 안했으면
				pos[i] = j; 
				if(i==7) print();
				else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7]= true;
					set(i+1); //j행에 배치한 채로 전체를 한번 돌고옴
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = false; 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		set(0);
	}
}
