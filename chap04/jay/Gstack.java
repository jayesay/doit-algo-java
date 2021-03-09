package chap04.jay;

public class Gstack<E> {
	private int max;
	private int ptr;
	private E[] stk;
	
//	public class EmptyIntStackException<E extends RuntimeException>{
//		public EmptyIntStackException() {}
//	}
	//제네릭 타입의 객체는 예외처리를 할 수 없음. 대신 타입파라미터를 예외처리함
	//그리고 try~catch블록에서 타입 파라미터를 throws 처리 해줘야함.
//	public class OverflowIntStackException<E extends RuntimeException>{
//		public OverflowIntStackException() {}
//	}
	
	//교재에서 처리한 방식 static 키워드 추가
	public static class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	public static class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	
	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = (E[]) new Object[capacity];
			//제네릭 객체로 배열을 생성하려면 Object로 생성해서 다운 캐스팅을 해야함.
		}catch(OutOfMemoryError e) {
			max =0;
		}
	}
	
	public E push(E data) throws OverflowIntStackException{
		if(ptr >= max) {
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = data;
	}
	
	public E pop() throws EmptyIntStackException{
		if(ptr <=0) {
			throw new EmptyIntStackException();
		}
		return stk[--ptr];
	}
	
	public E peek() throws EmptyIntStackException{
		if(ptr<=0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr-1];
	}
	
	public void dump() {
		if(ptr <=0) {
			System.out.println("스택이 비어 있습니다.");
		}else {
			for(int i=0;i<ptr;i++) {
				System.out.print(stk[i]+" ");
			}
			System.out.println();
		}
	}
	
	public int indexOf(E e) {//객체를 파라미터로 받는 경우가...?
		for(int i=ptr-1;i>-0;i--) { //탑에서 바닥으로
			if(stk[i].equals(e)) { //객체간의 비교는 equals()로.
				return i;
			}
		}
		return -1;
	}
	
	public void clear() {
		ptr =0;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr<=0; //true of false;
	}
	
	public boolean isFull() {
		return ptr>=max;
	}
	
}
