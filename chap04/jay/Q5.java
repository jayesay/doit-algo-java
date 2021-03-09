package chap04.re.jay;

public class Q5 {
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que;
	
	//검색 메소드만
	public int search(int x) {
		for(int i=0; i<num; i++) {
			int idx = (i+front)%max;
			if(que[idx]==x) return idx+1;  
		}
		return 0;
	}
}
