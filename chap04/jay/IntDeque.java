package chap04.re.jay;

public class IntDeque {
	private int max;
	private int num;
	private int front;
	private int rear;
	private int[] que;
	
	public static class EmptyIntDequeException extends RuntimeException {
		public EmptyIntDequeException() {}
	}
	
	public static class OverflowIntDequeException extends RuntimeException{
		public OverflowIntDequeException() {}
	}
	
	public IntDeque(int capacity) {
		max = capacity;
		num = front = rear = 0;
		que = new int[max];
	}
	
	public void enque(int x, boolean dir) { //true가 앞, false가 뒤
		if(num==max) throw new OverflowIntDequeException();
		if(dir) {
			if(front<0) front = max-1;
			que[front--] = x;
		}else {
			if(rear==max) rear = 0;
			que[rear++] = x;
		}
		num++;
	}
	
	public int deque(boolean dir) {
		if(num==0) throw new EmptyIntDequeException();
		int result = 0;
		if(dir) {
			if(front==max) front = 0;
			result = que[front++];
		}else {
			if(rear<0) rear = max-1;
			result = que[rear--];
		}
		num--;
		return result;
	}
	
	public int peek(boolean dir) {
		if(num==0) {
			System.out.println("데이터가 없습니다."); 
			return -1;
		}
		else {
			if(dir) return que[front+1];
			else return que[rear-1];
		}
	}
	
	public void dump(boolean dir) {
		if(num==0) System.out.println("큐가 비어있습니다.");
		else {
			if(dir) { //앞부터 출력
				for(int i=0; i<num; i++) System.out.println(que[(i+front)%max]+" ");
			}else { //뒤부터 출력
				for(int i=num-1; i>=0; i--) System.out.println(que[(i+rear%max)]+ " ");
			}
			System.out.println();
		}
	}
}
