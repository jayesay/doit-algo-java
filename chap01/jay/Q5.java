package chap01.jay;

public class Q5 {
	static int med2(int a, int b, int c) {
		if((b>=a && a>=c )||(c>=a && a>=b)) { // b>=a>=c or c>=a>=b
			return a;
		}else if((a>b && b>c )||(c>b&& b>a)){ // a>b>c or c>b>a
			return b;
		}return c; //이외의 경우
	}

	//효율이 떨어지는 이유 : 기존의 코드는 판별이 끝나면 바로 return하지만
	//and나 or 연산의 경우 연산을 다 해야 return하기 때문.?? 
}
