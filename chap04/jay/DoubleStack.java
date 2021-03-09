package chap04.jay;

public class DoubleStack {
	private int max;
	private int ptrA;
	private int ptrB;
	private int[] stack;
	
	public class EmptyInputException extends RuntimeException{
		public EmptyInputException() {}
	}
	
	public class OverflowInputException extends RuntimeException{
		public OverflowInputException() {}
	}
	
	public DoubleStack(int capacity) {
		max = capacity;
		ptrA = 0;
		ptrB = capacity-1;
		stack = new int[capacity];
	}
	
	public int push(int value, boolean dir) {
		//앞뒤를 선택하되, 2가지 내에서 선택하도록 boolean input
		//true인 경우, 원래대로, false인 경우 반대로 시작
		if(ptrA==ptrB) {
			throw new OverflowInputException();
			//포인터가 만나는 경우는 데이터가 가득 찼으므로 예외 발생.
		}
		if(dir) {
			return stack[ptrA++] = value; //stack 앞에 저장하고 포인터 이동
		}else {
			return stack[ptrB--] = value; //stack 뒤에 저장하고 포인터 앞으로 이동.
		}
	}
	
	public int pop(boolean dir) {
		if(dir) {
			if(ptrA==0) {
				throw new EmptyInputException();
			}
			return stack[--ptrA]; //포인터의 위치 잘 생각.
		}else {
			if(ptrB==max-1) {
				throw new EmptyInputException();
			}
			return stack[++ptrB];
		}
	}
	
	public int peek(boolean dir) {
		if(dir) {
			if(ptrA==0) {
				throw new EmptyInputException();
			}
			return stack[ptrA-1];
		}else {
			if(ptrB==max-1) {
				throw new EmptyInputException();
			}
			return stack[ptrB+1];
		}
	}
	
	public void dump(boolean dir) {
		if(dir) {
			if(ptrA==0) {
				throw new EmptyInputException();
			}
			for(int i=0;i<ptrA;i++) {
				System.out.print(stack[i]+" ");
			}
			System.out.println();
		}else {
			if(ptrB==max-1) {
				throw new EmptyInputException();
			}
			for(int i=max-1;i>ptrB; i--) {
				System.out.print(stack[i]+" ");
			}
			System.out.println();
		}
	}
	
	public int indexOf(int value, boolean dir) {
		if(dir) {
			for(int i=0;i<ptrA;i++) {
				if(value==stack[i]) return i;
			}return -1;
		}else {
			for(int i=max-1;i>ptrB; i--) {
				if(value==stack[i]) return i;
			}return -1;
		}
	}
	
	public void clear(boolean dir) {
		if(dir) {
			ptrA =0;
		}else {
			ptrB =max-1;
		}
	}
	
	public boolean isEmpty(boolean dir) {
		if(dir) {
//			if(ptrA==0) return true;
			return ptrA==0;
		}else {
//			if(ptrB==max-1) return true;
			return ptrB==max-1;
		}
	}
	
	public boolean isFull() {
//		if(ptrA==ptrB) return true;
//		return false;
		return ptrA==ptrB;
	}
	
	public int size(boolean dir) {//스택에 쌓여있는 갯수
		if(dir) {
			if(ptrA>=0) return ptrA;
		}else {
			if(ptrB<=max-1) return max-1-ptrB;
		}
		return 0;
	}
	
	public int capacity() {
		return max;
	}
	
}
