package chap04.re.jay;

public class IntAryQueue {
	private int max;
	private int num;
	private int[] queue;
	
	public class EmptyIntAryQueueException extends RuntimeException {
		public EmptyIntAryQueueException() {}
	}
	
	public class OverflowIntAryQueueException extends RuntimeException{
		public OverflowIntAryQueueException() {}
	}
	
	public IntAryQueue(int capacity) {
		max = capacity;
		num = 0;
		queue = new int[max];
	}
	
	public void enque(int x) {
		if(num==max) throw new OverflowIntAryQueueException();
		queue[num++] = x;
	}
	
	public int deque() {
		if(num==0) throw new EmptyIntAryQueueException();
		int result = queue[0]; //꺼낼 값
		for(int i=1; i<num; i++) {
			queue[i-1] = queue[i];
		}
		num--;
		return result;
	}
	
	public int peek() {
		return queue[num-1];
	}
	
	public int size() {
		return num;
	}
	
	public void clear() {
		num = 0;
	}
	
	public int indexOf(int x) {
		for(int i=0; i<num; i++) {
			if(queue[i]==x) return queue[i];
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return num ==0;
	}
	
	public boolean isFull() {
		return num ==  max;
	}
	
	public void dump() {
		if(num==0) System.out.println("큐가 비어있습니다.");
		else {
			for(int i=0; i<num; i++) {
				System.out.print(queue[i]+" ");
			}
			System.out.println();
		}
		
	}
}
