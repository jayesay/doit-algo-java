package chap04.jay;

import java.util.InputMismatchException;
import java.util.Scanner;

import chap04.IntStack;

public class GstackTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Gstack<String> s = new Gstack<String>(64);

		while (true) {
			System.out.println("현재 데이터 수: " + s.size() + "/" + s.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료 :");

			int menu = sc.nextInt();
			if (menu == 0)
				break;

			String data; //처리할 객체 레퍼런스
			switch (menu) {
			case 1:
				try {
					System.out.print("데이터:");
					data = sc.next(); //만약 String 이외에 다른 객체라면 캐스팅 필요.
					s.push(data);
				} catch (Gstack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				} catch (InputMismatchException e) {
					System.out.println("잘못 입력했습니다.");
				}
				break;

			case 2:
				try {
					data = s.pop();
					System.out.println("팝한 데이터는 " + data + "입니다.");
				} catch (Gstack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;

			case 3:
				try {
					data = s.peek();
					System.out.println("피크한 데이터는 " + data + "입니다.");
				} catch (Gstack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 4:
				s.dump();
				break;
			}
		}
	}
}
