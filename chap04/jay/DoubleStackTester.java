package chap04.jay;

import java.util.Scanner;

import chap04.jay.DoubleStack;

public class DoubleStackTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DoubleStack s = new DoubleStack(64);

		while (true) {
			System.out.println("현재 A스택 데이터 수: " + s.size(true) + "/" + s.capacity());
			System.out.println("현재 B스택 데이터 수: " + s.size(false) + "/" + s.capacity());
			System.out.print("스택 선택 : 1) A 2) B :");
			boolean aorb = true;//일단 디폴트는 앞.
			if(sc.nextInt()==2) {
				aorb = false;
			}
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료 :");

			int menu = sc.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1:
				System.out.print("데이터:");
				x = sc.nextInt();
				try {
					s.push(x,aorb);
				} catch (DoubleStack.OverflowInputException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			case 2:
				try {
					x = s.pop(aorb);
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (DoubleStack.EmptyInputException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;

			case 3:
				try {
					x = s.peek(aorb);
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (DoubleStack.EmptyInputException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 4:
				s.dump(aorb);
				break;
			}
		}
	}
}
