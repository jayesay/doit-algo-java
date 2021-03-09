package chap02.jay;

import java.util.Scanner;

public class Q11 {

	static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } // 윤년
	};

	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0; // 윤년인지를 파악
		// 윤년이면 1, 아니면 0 출력
	}

	static int leftDayOfYear(int y, int m, int d) {
		m--; // 인덱스 조정
		d = mdays[isLeap(y)][m++] - d; // m월의 일수에서 d만큼 빼기. m월에 남은 일수. 그리고 다음달
		while (m < 12) {
			d += mdays[isLeap(y)][m++]; // m+1월부터 12월까지의 합
		}
		return d;
	}

	static int dayOfYear(int y, int m, int d) {
		m--; // 인덱스 조정
		while (m > 0) {
			d += mdays[isLeap(y)][--m]; // 최근월부터 카운트
		}
		return d;
	}

	static class YMD {
		int y;// 년
		int m;// 월
		int d;// 일

		public YMD(int y, int m, int d) {
			this.y = y;
			this.m = m;
			this.d = d;
		}

		public void after(int n) {
			// 1) 그해 남은 날 구하기
			// 재사용을 위해 날짜 변수 다시 생성.
			int year = y;
			int month = m;
			int day = d;
			int aDay = n;
			int leftDays = leftDayOfYear(year, month, day);
			// 기준일 중심으로 연말까지 남은 날 계산
			while (true) {// 무한 루프
				if (leftDays >= aDay) {// 1-1)그해의 남은 날이 aDay보다 크거나 같은 경우 => 해를 넘기지 않음.
					// 2) 그 달의 말일이 aDay보다 큰 경우
					int lastDay = mdays[isLeap(year)][month - 1]; // m월의 말일
					if (lastDay - day >= aDay) { // 2-1) 월을 넘기지 않는 경우
						System.out.println(n + "일 후는 " + year + "년 " + month + "월 " + (day + aDay) + "일입니다.");
						break;
					} else {// 2-2) 월을 넘기는 경우 =>
						do {
							aDay -= (lastDay - day); // 처음은 남은 일수만큼 빼고, 한달씩 빼기
							day = 0;
							month++; // 달 추가
							lastDay = mdays[isLeap(year)][month - 1]; // 다음달의 말일
						} while (lastDay < aDay);// lastDay >=aDay인 경우 멈춤.
						System.out.println(n + "일 후는 " + year + "년 " + month + "월 " + aDay + "일입니다.");
						break;
					}
				} else { // 1-2)그해의 남은 날이 aDay보다 작은 경우 =>해를 넘김
					aDay -= leftDays;// aDay에서 남은날 빼고 계산
					// 남은 날을 빼면 년,월,일 재조정 필요. => 다음해 첫날에서 (aDay-leftDays)일 후로 변경됨.
					year++;// 년+1
					month = 1;
					day = 0; // 0일은 없지만 1일이 되면 계산에 1일의 오차가 생김.
					leftDays = leftDayOfYear(year, month, day); // 남은 날도 조정 필요.
				}
			}
		}

		public void before(int n) {
			// 1) 그해 남은 날 구하기
			// 재사용을 위해 날짜 변수 다시 생성.
			int year = y;
			int month = m;
			int day = d;
			int bDay = n;
			int pastDays = dayOfYear(year, month, day); 

			while (true) {
				if (pastDays > bDay) {// 1-1)지난 날들이 구하고자 하는 날보다 큰 경우 => 같은 경우는 0일이 되어버림
					// 2) 그 달의 말일이 bDay보다 큰 경우
					int lastDay = mdays[isLeap(year)][month - 1]; // m월의 말일
					if (day > bDay) { // 2-1) 월을 넘기지 않는 경우  => 같은 경우는 0일이 되어버림
						System.out.println(n + "일 전은 " + year + "년 " + month + "월 " + (day - bDay) + "일입니다.");
						break; 
					} else {// 2-2) 월을 넘기는 경우 =>
						do {
							bDay -= day; // 지난 일수만큼 빼기
							month--; // 달 감소
							lastDay = mdays[isLeap(year)][month - 1]; // 다음달의 말일
							day = lastDay;
						} while (day < bDay);// day >=n인 경우 멈춤.
						System.out.println(n + "일 전은 " + year + "년 " + month + "월 " + (lastDay-bDay) + "일입니다.");
						break; //n+1 오차 발생 맞춰줌.. but why?
					}

				} else {// 1-2)지난 날들보다 n이 큰 경우
					bDay -= pastDays;  
					year--; // 해가 바뀜.
					month = 12;
					day = 31; 
					pastDays = dayOfYear(year, month, day);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("기준이 되는 날짜 입력");
		System.out.print("년:");
		int y = sc.nextInt();
		System.out.print("월:");
		int m = sc.nextInt();
		System.out.print("일:");
		int d = sc.nextInt();
		YMD ymd = new YMD(y, m, d);
		System.out.println();

		System.out.println("1. 기준일보다 n일 전의 날짜 계산");
		System.out.println("2. 기준일보다 n일 후의 날짜 계산");
		System.out.print("선택>");
		int choice = sc.nextInt();
		System.out.print("n :");
		int n = sc.nextInt();

		if (choice == 1) {
			ymd.before(n);
		} else if (choice == 2) {
			ymd.after(n);
		}

	}

}
