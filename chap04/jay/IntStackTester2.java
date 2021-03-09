package chap04.re.jay;

import java.util.Scanner;

import chap04.re.IntStack;
import chap04.re.IntStack.EmptyIntStackException;
import chap04.re.IntStack.OverflowIntStackException;

public class IntStackTester2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);

		while (true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("1.푸시 2.팝 3.피크 4.덤프. 5.인덱스 6.비우기 0.종료:");

			int menu = sc.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1:
				System.out.print("데이터 :");
				x = sc.nextInt();
				try {
					s.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			case 2:
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다");

				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 3:
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 4:
				s.dump();
				break;

			case 5:
				System.out.println("검색할 데이터 입력 :");
				x = sc.nextInt();
				if(s.indexOf(x)!= -1) System.out.println("x는 위치 " + s.indexOf(x) + "에 있습니다.");
				else System.out.println(x+"는 스택에 없습니다.");
				break;
			case 6:
				s.clear();
				System.out.println("스택을 초기화하였습니다.");
				break;
			}
		}
	}

}
