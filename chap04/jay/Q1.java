package chap04.jay;

import java.util.Scanner;

import chap04.IntStack;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while(true) {
			System.out.println("현재 데이터 수: " + s.size() +"/" + s.capacity());
			System.out.println("(1)푸시 (2)팝 (3)피크 (4)덤프 "
					+ "(5)찾기 (6)비우기 (0)종료");
			System.out.print("선택 :");
			
			int menu = sc.nextInt();
			if(menu==0) break;
			
			int x;
			switch(menu) {
			case 1:
				System.out.print("데이터:");
				x = sc.nextInt();
				if(s.isFull()) {
					System.out.println("스택이 가득 찼습니다.");
				}else {
					s.push(x);
				}
				break;
				
			case 2:
				if(s.isEmpty()) {
					System.out.println("스택이 비어 있습니다.");
				}else {
					x = s.pop();
					System.out.println("팝한 데이터는 "+x+"입니다.");
				}
				break;
				
			case 3:
				if(s.isEmpty()) {
					System.out.println("스택이 비어있습니다.");
				}else {
					x=s.peek();
					System.out.println("피크한 데이터는 "+x+"입니다.");
				}
				break;
				
			case 4:
				s.dump();
				break;
				
			case 5:
				if(s.isEmpty()) {
					System.out.println("스택이 비어있습니다.");
				}else {
					System.out.print("찾을 값 입력:");
					int idx = s.indexOf(sc.nextInt());
					if(idx>=0) {
						System.out.println("찾으시는 값은 인덱스"+idx+"에 있습니다.");
					}else {
						System.out.println("찾으시는 값이 없습니다.");
					}
				}
				break;
				
			case 6:
				if(s.isEmpty()) {
					System.out.println("스택이 비어있습니다.");
				}else {
					s.clear();
					System.out.println("스택을 초기화하였습니다.");
				}
				break;
			}
			
		}
	}

}
